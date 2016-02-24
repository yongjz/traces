package com.waterwood.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.waterwood.entity.MerchandisePatch;
import com.waterwood.entity.QuickResponseCode;

public interface IQuickResponseCodeService {
	public String saveMerchandisePatchInfo(MerchandisePatch mer) throws ParseException;
	
	public List<QuickResponseCode> generateQRCode(int count,String patchCode,HttpServletRequest request);
	
	public String getQRCodeSrc(String qr_code);
}
