package com.waterwood.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waterwood.utils.Util;


@Controller
public class IndexController {

	@RequestMapping("/index")
	public String goNewIndex(HttpServletRequest request) throws Exception{
		System.out.println("访问qr-gen-form.html");
		request.getSession().setAttribute("test", Util.nameSdf.format(new Date()));
		return "redirect:/pages/qrdemo/qr-gen-form.html";
	}
	
	@RequestMapping("/preview")
	public String goQrGenPreview(HttpServletRequest request) throws Exception{
		System.out.println("访问qr-gen-preview.html");
		System.out.println(request.getSession().getAttribute("test"));
		return "redirect:/pages/qrdemo/qr-gen-preview.html";
	}
}
