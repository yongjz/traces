package com.waterwood.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.waterwood.entity.Logistics;

@RunWith(SpringJUnit4ClassRunner.class)		
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class LogisticsServiceTest {
	@Autowired
	private ILogisticsService logisticsService = null;
	
	@Test
	public void testLogisticsService() {
		List<Logistics> list = logisticsService.findLogisticsListByQRCode("20150113001002");
		for(Logistics logistic:list){
			System.out.println(logistic.getLogisticsId());
			System.out.println(logistic.getLogisticsCity());
			System.out.println(logistic.getLogisticsStation());
		}
	}
}
