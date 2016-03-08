package com.waterwood.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.waterwood.entity.MerchandisePatch;
import com.waterwood.service.IMerchandisePatchService;

@Controller
@RequestMapping("merchandise")
public class MerchandiseController {
	@Autowired
	private IMerchandisePatchService merchandisePatchService;
	
	/**
	 * 保存商品信息
	 * 
	 * @param mer
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("saveMerchandisePatchInfo")
	@ResponseBody
	public String saveMerchandisePatchInfo(MerchandisePatch mer, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(request.getParameter("name"));
		try {
			String patchcode = merchandisePatchService.saveMerchandisePatchInfo(mer);
			request.getSession().setAttribute("patchcode", patchcode);
			return "success";
		} catch (ParseException e) {
			e.printStackTrace();
			return "failed";
		}
	}
}
