package com.waterwood.service;

import java.util.List;

import com.waterwood.entity.MerchandisePatch;
import com.waterwood.entity.QuickResponseCode;

public interface IQuickResponseCodeService {
	public QuickResponseCode generateQRCode(QuickResponseCode qrc);
	
	public List<QuickResponseCode> generateQRCodeList(MerchandisePatch mp, String path, String realpath);
	
	public String getQRCodeSrc(String qr_code);
	
	public void updateQrCodeState(String codeStr);
}
