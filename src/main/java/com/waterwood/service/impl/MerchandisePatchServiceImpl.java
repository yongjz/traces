package com.waterwood.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waterwood.dao.MerchandisePatchMapper;
import com.waterwood.dao.QuickResponseCodeMapper;
import com.waterwood.entity.MerchandisePatch;
import com.waterwood.entity.QuickResponseCode;
import com.waterwood.service.IMerchandisePatchService;

@Service("merchandisePatchService")
public class MerchandisePatchServiceImpl implements IMerchandisePatchService {
	@Autowired
	private MerchandisePatchMapper merDAO;
	@Autowired
	private QuickResponseCodeMapper qrcodeDAO;
	
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
