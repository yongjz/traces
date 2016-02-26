package com.waterwood.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waterwood.common.validateMerchandiseData;
import com.waterwood.dao.LogisticsMapper;
import com.waterwood.dao.MerchandisePatchMapper;
import com.waterwood.dao.QuickResponseCodeMapper;
import com.waterwood.entity.Logistics;
import com.waterwood.entity.MerchandisePatch;
import com.waterwood.entity.QuickResponseCode;
import com.waterwood.service.ILogisticsService;
import com.waterwood.utils.Util;

@Service("logisticsService")
public class LogisticsServiceImpl implements ILogisticsService {
	@Autowired
	private LogisticsMapper logisticsDAO;
	@Autowired
	private QuickResponseCodeMapper qrcodeDAO;
	@Autowired
	private MerchandisePatchMapper merDAO;
	
	@Override
	public List<Logistics> findLogisticsListByQRCode(String qrcode_code) {
		return logisticsDAO.selectByOutsideCode(qrcode_code);
	}
	
	@Override
	public validateMerchandiseData validateQrcode(String qrcode_code) {
		//根据二维码内码查询二维码属性
		QuickResponseCode qrcode = qrcodeDAO.selectByInsideCode(qrcode_code);
		if(qrcode==null) {
			return null;
		}
		
		validateMerchandiseData v = new validateMerchandiseData();
		v.setDateTime(Util.sdf.format(new Date()));
		if(qrcode.getQrcodeStatus().equals("00")) {
			v.setIsOpen(false);
			//如果是第一次扫描该码，则将状态置为已开启
			qrcode.setQrcodeStatus("01");
			qrcodeDAO.updateByPrimaryKey(qrcode);
		} else {
			v.setIsOpen(true);
		}
		
		MerchandisePatch mer = merDAO.selectByCode(qrcode.getQrcodeMerchandisepatchcode());
		v.setMerchandisePatch(mer);
		return v;
	}
}
