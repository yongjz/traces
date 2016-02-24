package testwebapp;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.waterwood.entity.Logistics;
import com.waterwood.entity.User;
import com.waterwood.service.ILogisticsService;
import com.waterwood.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)		
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private IUserService userService = null;
	@Resource
	private ILogisticsService logisticsService = null;
	
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	//@Test
	public void test1() {
		User user = userService.getUserById(1);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		logger.info(JSON.toJSONString(user));
	}
	
	@Test
	public void testLogisticsService() {
		List<Logistics> list = logisticsService.findLogisticsListByQRCode("20150113001025");
		for(Logistics logistic:list){
			System.out.println(logistic.getLogisticsId());
			System.out.println(logistic.getLogisticsCity());
		}
	}
}

