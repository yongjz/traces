package com.waterwood.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.waterwood.entity.MerchandisePatch;
import com.waterwood.common.Global;
import com.waterwood.common.validateData;
import com.waterwood.entity.QuickResponseCode;
import com.waterwood.service.IQuickResponseCodeService;
import com.waterwood.utils.LogoConfig;
import com.waterwood.utils.QrCodeUtil;
import com.waterwood.utils.Util;

@Controller
@RequestMapping("/qrcode")
public class QuickResponseCodeController {
	@Autowired
	private IQuickResponseCodeService qrcodeService;
	

	@RequestMapping("/generateQrCodes")
	@ResponseBody
	public List<QuickResponseCode> generateQrCodes(HttpServletRequest request, HttpServletResponse response) {
		MerchandisePatch mp = (MerchandisePatch)request.getSession().getAttribute("mer");
		if(mp == null) {
			return null;
		}
		//path形式为http://localhost:8080/traces
		String path = Util.getServerFullPath(request);
		//realpath形式为D://tomcat/webapp/traces
		String realpath = request.getSession().getServletContext().getRealPath("");
		//List<QuickResponseCode> list = qrcodeService.generateQRCodeList(mp.getMerchandiseCount(),mp.getMerchandisepatchCode(), path, realpath);
		List<QuickResponseCode> list = qrcodeService.generateQRCodeList(mp, path, realpath);
		request.getSession().setAttribute("mer", null);
		return list;
	}
	
	/**
	 * 根据页面传来的信息生成二维码方法
	 * @param request
	 * @param response
	 * @param id
	 * @throws Exception
	 * 
	 */
	@RequestMapping("/saveMerchandiseInfo/out/{id}")
	public void saveMerchandisePatchInfoOut(HttpServletRequest request,
			HttpServletResponse response,@PathVariable String id) throws Exception {
		//预生成二维码记录
		String merPatchCode = (String)request.getSession().getAttribute("patchcode");
		if(StringUtils.isEmpty(merPatchCode)) {
			return;
		}
		QuickResponseCode qrc = new QuickResponseCode();
		qrc.setQrcodeMerchandisepatchcode(merPatchCode);
		qrcodeService.generateQRCode(qrc);
		request.getSession().setAttribute("insidecode", qrc.getQrcodeInsidecode());

		//二维码内容
		String context = Util.getServerFullPath(request) + "logistics?code="+qrc.getQrcodeOutsidecode();
		//二维码尺寸
		int width = 300;
		int height = 300;
		// 二维码的图片格式
		String format = "jpg";
		//设置二维码的参数
		Map<EncodeHintType, Object> hints = QrCodeUtil.getDecodeHintType();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		
		//生成外部二维码PNG流返回给前台
		try {
			BitMatrix bitMatrix = new MultiFormatWriter()
			.encode(context,BarcodeFormat.QR_CODE,width,height,hints);
			OutputStream outStream = response.getOutputStream();
			// 生成二维码流
			MatrixToImageWriter.writeToStream(bitMatrix, format, outStream);
			outStream.flush();  
			outStream.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/saveMerchandiseInfo/in/{id}")
	public void saveMerchandisePatchInfoIn(HttpServletRequest request,
			HttpServletResponse response,@PathVariable String id) throws Exception {
		String realpath = request.getSession().getServletContext().getRealPath("");
		//二维码内容
		//String context = Util.getServerFullPath(request) + Global.URL_VALIDATE + "?code=" + id +"_"+Util.nameSdf.format(new Date());
		String insideCode = (String)request.getSession().getAttribute("insidecode");
		String context = Util.getServerFullPath(request) + "validate?code=" + insideCode;
		//二维码尺寸
		int width = 300;
		int height = 300;
		// 二维码的图片格式
		String format = "jpg";
		//设置二维码的参数
		Map<EncodeHintType, Object> hints = QrCodeUtil.getDecodeHintType();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		try {
			BitMatrix bitMatrix = new MultiFormatWriter()
				.encode(context,BarcodeFormat.QR_CODE,width,height,hints);
			// 生成二维码
			File outputFile = new File(realpath+QrCodeUtil.OUT_QRCODE_IMG+id+QrCodeUtil.IMG_SUFFIX);
			MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
			
			QrCodeUtil.addLogo_QRCode(id,new File(realpath+QrCodeUtil.OUT_QRCODE_IMG+id+QrCodeUtil.IMG_SUFFIX),
				new File(realpath+QrCodeUtil.LOGO_IMG), new LogoConfig(),realpath);
			
			//读取二维码图片
			FileInputStream logoFileStream = new FileInputStream(realpath+QrCodeUtil.IN_QRCODE_IMG+id+QrCodeUtil.IMG_SUFFIX);
			OutputStream outStream = response.getOutputStream();
			byte data[]=new byte[1024];
			int read=logoFileStream.read(data);  
			while(read!=-1)  
			{  
				outStream.write(data,0,read);  
				read=logoFileStream.read(data);  
			}
			logoFileStream.close();
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/validate")
	@ResponseBody
	public validateData validateQrcode(HttpServletRequest request, HttpServletResponse response) {
		validateData v = new validateData();
		v.setIsOpen(Global.qrcodeStatus);
		v.setDateTime(Util.sdf.format(new Date()));
		if(Global.qrcodeStatus == false){
			Global.qrcodeStatus = true;
		}
		return v;
	}
	
	//根据二维码code获取二维码图片src
	@RequestMapping("getQrcodeSrc")
	public String getQRCodeSrcByCode(String qr_code,HttpServletRequest request,ModelMap map) throws Exception {
		return qrcodeService.getQRCodeSrc(qr_code);
	}
	
	//生成商品信息之后，要根据商品批次信息生成二维码
	@RequestMapping("generateQrcode")
	public String generateQRCode(String patch_code,HttpServletRequest request,ModelMap map) throws Exception {
		return "qrdemo/qrcode";
	}
}
