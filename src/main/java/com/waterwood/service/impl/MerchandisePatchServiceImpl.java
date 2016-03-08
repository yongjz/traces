package com.waterwood.service.impl;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waterwood.dao.MerchandisePatchMapper;
import com.waterwood.dao.QuickResponseCodeMapper;
import com.waterwood.entity.MerchandisePatch;
import com.waterwood.entity.QuickResponseCode;
import com.waterwood.service.IMerchandisePatchService;
import com.waterwood.utils.Util;

@Service("merchandisePatchService")
public class MerchandisePatchServiceImpl implements IMerchandisePatchService {
	@Autowired
	private MerchandisePatchMapper merDAO;
	@Autowired
	private QuickResponseCodeMapper qrcodeDAO;
	
	//保存商品批次信息
	public String saveMerchandisePatchInfo(MerchandisePatch mer) throws ParseException {
		mer.setMerchandisepatchCode(Util.getRandomGUID(true));
		mer.setMerchandisepatchInfo("商品描述信息");
		mer.setMerchandisepatchProductingarea("China");
		mer.setAcceptanceauthorityCode("受理机关编号");
		mer.setMerchandisepatchCatalogcode("产品类别编号");
		mer.setMerchandisepatchBuyercode("购买机构编号");
		mer.setMerchandisepatchPro("生产厂商");
		mer.setMerchandisepatchCreatetime(new Date());
		merDAO.insert(mer);
		return mer.getMerchandisepatchCode();
	}
	
	@Override
	public MerchandisePatch getMerchandisePatchByCode(String patchCode) {
		MerchandisePatch mer = merDAO.selectByCode(patchCode);

		return mer;
	}

	@Override
	public MerchandisePatch getMerchandisePatchByInsideQrcode(String qrCode) {
		QuickResponseCode qrcode = qrcodeDAO.selectByInsideCode(qrCode);
		if(qrcode==null) {
			return null;
		}
		MerchandisePatch mer = merDAO.selectByCode(qrcode.getQrcodeMerchandisepatchcode());
		return mer;
	}
	
	@Override
	public MerchandisePatch getMerchandisePatchByOutsideQrcode(String qrCode) {
		QuickResponseCode qrcode = qrcodeDAO.selectByOutsideCode(qrCode);
		if(qrcode==null) {
			return null;
		}
		MerchandisePatch mer = merDAO.selectByCode(qrcode.getQrcodeMerchandisepatchcode());
		return mer;
	}
}
