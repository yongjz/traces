package com.waterwood.service;

import com.waterwood.entity.MerchandisePatch;

public interface IMerchandisePatchService {
	MerchandisePatch getMerchandisePatchByCode(String patchCode);
	
	MerchandisePatch getMerchandisePatchByInsideQrcode(String qrCode);
	
	MerchandisePatch getMerchandisePatchByOutsideQrcode(String qrCode);
}
