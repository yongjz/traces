package com.waterwood.service;

import java.text.ParseException;

import com.waterwood.entity.MerchandisePatch;

public interface IMerchandisePatchService {
	public String saveMerchandisePatchInfo(MerchandisePatch mer) throws ParseException;
	
	public MerchandisePatch getMerchandisePatchByCode(String patchCode);
	
	public MerchandisePatch getMerchandisePatchByInsideQrcode(String qrCode);
	
	public MerchandisePatch getMerchandisePatchByOutsideQrcode(String qrCode);
}
