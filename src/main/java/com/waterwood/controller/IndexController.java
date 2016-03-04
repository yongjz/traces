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

	@RequestMapping("/index")
	public String goNewIndex(HttpServletRequest request) throws Exception {
		System.out.println("访问qr-gen-form.html");
		request.getSession().setAttribute("test", Util.nameSdf.format(new Date()));
		return "redirect:/pages/qrdemo/qr-gen-form.html";
	}
	
	@RequestMapping("/preview")
	public String goQrGenPreview(HttpServletRequest request) throws Exception {
		System.out.println("访问qr-gen-preview.html");
		System.out.println(request.getSession().getAttribute("test"));
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
}
