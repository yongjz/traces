package com.waterwood.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.waterwood.entity.QuickResponseCode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class QuickResponseCodeServiceTest {
	@Autowired
	private IQuickResponseCodeService quickResponseCodeService;

	// @Test
	public void testGenerateQRCodeList() {
		String path = "http://localhost:8080/traces/";
		String realpath = "H://imgs";
		quickResponseCodeService.generateQRCodeList(5, "201602261238", path, realpath);
	}

	@Test
	public void testGenerateQRCode() {
		QuickResponseCode qrc = new QuickResponseCode();
		qrc.setQrcodeInfo("info");
		quickResponseCodeService.generateQRCode(qrc);
	}
}
