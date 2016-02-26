package com.waterwood.service;

import java.util.List;

import com.waterwood.common.validateMerchandiseData;
import com.waterwood.entity.Logistics;

public interface ILogisticsService {
	public List<Logistics> findLogisticsListByQRCode(String qrcode_code);

	public validateMerchandiseData validateQrcode(String qrcode_code);
}
