package com.waterwood.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class QuickResponseCodeServiceTest {
	@Autowired
	private IQuickResponseCodeService quickResponseCodeService;
	
	@Test
	public void testGenerateQRCode() {
		String path = "http://localhost:8080/traces/";
		String realpath = "d://imgs";
		quickResponseCodeService.generateQRCode(5, "201602261238", path, realpath);
	}
}
