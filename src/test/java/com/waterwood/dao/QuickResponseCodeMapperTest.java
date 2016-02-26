package com.waterwood.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.waterwood.entity.QuickResponseCode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class QuickResponseCodeMapperTest {
	@Autowired
	private QuickResponseCodeMapper qrcodeDAO;
	
	@Test
	public void testSelectByOutsideCode() {
		QuickResponseCode qr = qrcodeDAO.selectByOutsideCode("20150113001001");
		System.out.println(qr.getQrcodeId());
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		QuickResponseCode qr = qrcodeDAO.selectByPrimaryKey(1);
		System.out.println(qr.getQrcodeInsidecode());
	}
	
	@Test
	public void testSelectByInsideCode() {
		QuickResponseCode qr = qrcodeDAO.selectByInsideCode("20150113002001");
		System.out.println(qr.getQrcodeId());
	}
}
