package com.waterwood.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public String goNewIndex(HttpServletRequest request) throws Exception{
		System.out.println("aaaaaaaa");
		return "pages/index.html";
	}
}
