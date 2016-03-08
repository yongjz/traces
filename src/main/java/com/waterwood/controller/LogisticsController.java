package com.waterwood.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.waterwood.common.validateMerchandiseData;
import com.waterwood.entity.Logistics;
import com.waterwood.service.ILogisticsService;

@Controller
@RequestMapping("/logistics")
public class LogisticsController {
	@Autowired
	private ILogisticsService logisticsService;
	
	/**
	 * 扫外部二维码访问的链接，显示物流信息
	 * @param code
	 * @param request
	 * @return
	 */
	@RequestMapping("out")
	@ResponseBody
	public List<Logistics> showLogisticsInfo(String code,HttpServletRequest request){
		List<Logistics> logisticsList = logisticsService.findLogisticsListByQRCode(code);
		
		return logisticsList;
	}
	
	/**
	 * 扫内部二维码访问的链接，显示商品是否被启用过
	 * @param code
	 * @param request
	 * @return
	 */
	@RequestMapping("in")
	@ResponseBody
	public validateMerchandiseData validateMerchandise(String code,HttpServletRequest request){
		return logisticsService.validateQrcode(code);
	}
}
