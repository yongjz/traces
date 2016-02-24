package com.waterwood.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waterwood.entity.Logistics;
import com.waterwood.entity.validateMerchandiseData;
import com.waterwood.service.ILogisticsService;

@Controller
@RequestMapping("/logistics")
public class LogisticsController {
	@Autowired
	private ILogisticsService logisticsService;
	
	@RequestMapping("out")
	public List<Logistics> showLogisticsInfo(String code,HttpServletRequest request){
		List<Logistics> logisticsList = logisticsService.findLogisticsListByQRCode(code);
		
		return logisticsList;
	}
	
	@RequestMapping("in")
	public validateMerchandiseData validateMerchandise(String code,HttpServletRequest request){
		validateMerchandiseData qrc = logisticsService.validateQrcode(code);
		return qrc;
	}
}
