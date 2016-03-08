package com.waterwood.service;

import java.text.ParseException;

import com.waterwood.entity.MerchandisePatch;

public interface IMerchandisePatchService {
	String saveMerchandisePatchInfo(MerchandisePatch mer) throws ParseException;
	
	MerchandisePatch getMerchandisePatchByCode(String patchCode);
	
	MerchandisePatch getMerchandisePatchByInsideQrcode(String qrCode);
	
	MerchandisePatch getMerchandisePatchByOutsideQrcode(String qrCode);
}
