package com.waterwood.service;

import java.util.List;

import com.waterwood.entity.Logistics;
import com.waterwood.entity.validateMerchandiseData;

public interface ILogisticsService {
	public List<Logistics> findLogisticsListByQRCode(String qrcode_code);
	
	public validateMerchandiseData validateQrcode(String qrcode_code);
}
