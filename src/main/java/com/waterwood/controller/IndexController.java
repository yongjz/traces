package com.waterwood.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waterwood.service.ILogisticsService;
import com.waterwood.service.IMerchandisePatchService;
import com.waterwood.utils.Util;

@Controller
public class IndexController {
	@Autowired
	private IMerchandisePatchService merchandisePatchService;
	@Autowired
	private ILogisticsService logisticsService;
	
	@RequestMapping("index")
	public String goNewIndex(HttpServletRequest request) throws Exception {
		System.out.println("访问qr-gen-form");
		request.getSession().setAttribute("test", Util.nameSdf.format(new Date()));
		return "qr-gen-form";
	}
	
	@RequestMapping("preview")
	public String goQrGenPreview(String name, String time, HttpServletRequest request) throws Exception {
		System.out.println(request.getSession().getAttribute("patchcode"));
		return "redirect:/pages/qrdemo/qr-gen-preview.html";
	}
	
	@RequestMapping("logistics")
	public String goLogistics(String code, HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("logisticsList",logisticsService.findLogisticsListByQRCode(code));
		model.addAttribute("mer", merchandisePatchService.getMerchandisePatchByOutsideQrcode(code));
		return "logistics";
	}
	
	@RequestMapping("validate")
	public String goValidate(String code, HttpServletRequest request, Model model) throws Exception {
		model.addAttribute("mer", merchandisePatchService.getMerchandisePatchByInsideQrcode(code));  
		return "validate";
	}
	
	@RequestMapping("qr-gen-form")
	public String goQrGenForm(String code, HttpServletRequest request, Model model) throws Exception {
		return "qr-gen-form";
	}
	
	@RequestMapping("qr-gen-preview")
	public String goQrGenPreview(String code, HttpServletRequest request, Model model) throws Exception {
		
		return "qr-gen-preview";
	}
	
	@RequestMapping("frame-print-template")
	public String goFramePrintTemplate(String code, HttpServletRequest request, Model model) throws Exception {
		return "frame-print-template";
	}
}
