package com.waterwood.service.impl;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.waterwood.common.Global;
import com.waterwood.dao.QuickResponseCodeMapper;
import com.waterwood.entity.QuickResponseCode;
import com.waterwood.service.IQuickResponseCodeService;
import com.waterwood.utils.LogoConfig;
import com.waterwood.utils.QrCodeUtil;
import com.waterwood.utils.Util;

@Service("qrcodeService")
public class QuickResponseCodeServiceImpl implements IQuickResponseCodeService {
	@Autowired
	private QuickResponseCodeMapper qrcodeDAO;
	
	@Override
	public QuickResponseCode generateQRCode(QuickResponseCode qrc) {
		if(StringUtils.isEmpty(qrc.getQrcodeInfo())){
			qrc.setQrcodeInfo("empty qrcode");
		}
		qrc.setQrcodeOutsidecode("out_" + Util.getRandomGUID(true));
		qrc.setQrcodeInsidecode("in_" + Util.getRandomGUID(true));
		qrc.setQrcodeStatus("11"); //11表示预生成状态，00表示已经正式生成；01表示已经启用了
		qrc.setQrcodeType("00");
		qrc.setQrcodeCreatetime(new Date());
		qrcodeDAO.insert(qrc);
		return qrc;
	}
	
	@Override
	public List<QuickResponseCode> generateQRCodeList(int count,String patchCode, String path, String realpath){
		List<QuickResponseCode> list = new ArrayList<QuickResponseCode>();
		
		for(int i = 0;i<count;i++){
			QuickResponseCode qrcode = new QuickResponseCode();
			qrcode.setQrcodeOutsidecode("out_"+Util.getRandomGUID(true));
			qrcode.setQrcodeInsidecode("in_"+Util.getRandomGUID(true));
			qrcode.setQrcodeInfo("这是一个二维码");
			qrcode.setQrcodeStatus("00");
			qrcode.setQrcodeType("1");
			qrcode.setQrcodeMerchandisepatchcode(patchCode);
			
			//TODO QuickResponseCode缺少两个属性，分别记录内码和外码的内容
			
			String outsideCodeText = String.
					format(path+ Global.URL_LOGISTICS + "?code="+qrcode.getQrcodeOutsidecode());
			String insideCodeText = String.
					format(path+ Global.URL_VALIDATE +"?code="+qrcode.getQrcodeInsidecode());
			
			String outsideSrc = createOutsideCode(outsideCodeText,realpath);
			if(!outsideSrc.equals("failed")){
				qrcode.setQrcodeOutsidesrc(outsideSrc);
			}
			String insideSrc = createInsideCode(insideCodeText,realpath);
			if(!insideSrc.equals("failed")){
				qrcode.setQrcodeInsidesrc(insideSrc);
			}
			
			qrcode.setQrcodeSeller("");
			qrcode.setQrcodeUsertime(new Date());
			qrcode.setQrcodeCreatetime(new Date());
			//调用保存二维码的service方法
			qrcodeDAO.insert(qrcode);
			list.add(qrcode);
		}
		
		return list;
	}
	
	/**
     * 外部二维码的生成
     *
     */
	public String createOutsideCode(String text,String realpath){
		int width = 300;
		int height = 300;
		// 二维码的图片格式
		String format = "png";
		
		//设置二维码的参数
		HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(text,BarcodeFormat.QR_CODE,width,height,hints);
			// 生成二维码
			String relativePath = QrCodeUtil.OUT_QRCODE_IMG+"/"+
					Util.directorySdf.format(new Date())+"/"+
					Util.nameSdf.format(new Date())+
					QrCodeUtil.IMG_SUFFIX;
			File outputFile = new File(realpath+relativePath);
			MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
			return relativePath;
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
	/**
     * 内部二维码的生成
     *
     */
	public String createInsideCode(String text,String realpath){
		int width = 350;
		int height = 350;
		// 二维码的图片格式
		String format = "png";
		
		//设置二维码的参数
		HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		try {
			//BitMatrix bitMatrix = new MultiFormatWriter().encode(text,BarcodeFormat.QR_CODE,width,height,hints);
			BitMatrix bitMatrix = new MultiFormatWriter()
					.encode(text,BarcodeFormat.QR_CODE,width,height,hints);
			// 生成二维码
			String relativePath = QrCodeUtil.IN_QRCODE_IMG+"/"+
					Util.directorySdf.format(new Date())+"/"+
					Util.nameSdf.format(new Date())+
					QrCodeUtil.IMG_SUFFIX;
			File outputFile = new File(realpath+relativePath);
			MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
			
			addLogo_QRCode(realpath+relativePath,new File(realpath+relativePath),
					new File(realpath+QrCodeUtil.LOGO_IMG), new LogoConfig());
			
			return relativePath;
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
	/**
     * 给二维码图片添加Logo
     * 
     * @param qrPic
     * @param logoPic
     */
    private void addLogo_QRCode(String qrPicStr,File qrPic, 
    		File logoPic, LogoConfig logoConfig){
    	try{
    		if (!qrPic.isFile() || !logoPic.isFile()){
    			System.out.print("file not find !");
    			System.exit(0);
    		}

    		/**
    		 * 读取二维码图片，并构建绘图对象
    		 */
    		BufferedImage image = ImageIO.read(qrPic);
    		Graphics2D g = image.createGraphics();

    		/**
    		 * 读取Logo图片
    		 */
    		BufferedImage logo = ImageIO.read(logoPic);

    		int widthLogo = logo.getWidth(), heightLogo = logo.getHeight();

    		// 计算图片放置位置
    		int x = (image.getWidth() - widthLogo) / 2;
    		int y = (image.getHeight() - logo.getHeight()) / 2;

    		//开始绘制图片
    		g.drawImage(logo, x, y, widthLogo, heightLogo, null);
    		g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
    		g.setStroke(new BasicStroke(logoConfig.getBorder()));
    		g.setColor(logoConfig.getBorderColor());
    		g.drawRect(x, y, widthLogo, heightLogo);

    		g.dispose();

    		ImageIO.write(image, "jpg", new File(qrPicStr));
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public String getQRCodeSrc(String qr_code){
    	String type = qr_code.split("_")[0];
    	String src = "";
    	if(type.equals("out")){
    		QuickResponseCode qrc = qrcodeDAO.selectByOutsideCode(qr_code);
    		src = qrc.getQrcodeOutsidesrc();
    	}else{
    		QuickResponseCode qrc = qrcodeDAO.selectByInsideCode(qr_code);
    		src = qrc.getQrcodeInsidesrc();
    	}
    	
    	return src;
    }
    
    /** 
     * 二维码的解析 
     * 
     * @param file 
     *//*  
    public void parseCode(File file)  
    {  
        try  
        {  
            MultiFormatReader formatReader = new MultiFormatReader();  
   
            if (!file.exists())  
            {  
                return;  
            }  
   
            BufferedImage image = ImageIO.read(file);  
   
            LuminanceSource source = new BufferedImageLuminanceSource(image);  
            Binarizer binarizer = new HybridBinarizer(source);  
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
   
            Map hints = new HashMap();  
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
   
            Result result = formatReader.decode(binaryBitmap, hints);  
   
            System.out.println("解析结果 = " + result.toString());  
            System.out.println("二维码格式类型 = " + result.getBarcodeFormat());  
            System.out.println("二维码文本内容 = " + result.getText());  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  */
	
}
