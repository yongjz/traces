package com.waterwood.service;

import java.util.List;

import com.waterwood.entity.QuickResponseCode;

public interface IQuickResponseCodeService {
	public QuickResponseCode generateQRCode(QuickResponseCode qrc);
	
	public List<QuickResponseCode> generateQRCodeList(int count,String patchCode, String path, String realpath);
	
	public String getQRCodeSrc(String qr_code);
}
