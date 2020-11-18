package com.vip.learn.service;


import com.vip.learn.dao.CityDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
//public class CitySeriviceImpl implements CityService {
public class CitySeriviceImpl {
    //有2个CityDao实现类，先根据名字找cityDao的bean，找不到
    //再根据byType找 CityDao类型的bean，这时有2个bean，CityDaoImplOne，CityDaoImplTwo
//	@Resource
//
//	@Autowired
//	private CityDao cityDao;

//	@Resource
//	private CityDaoImplOne cityDao;

//
//    @Autowired
//    private OrderService orderService;

    //先名字找到cityDaoImplOne的bean，类型是CityDaoImplOne
    //而参数类型是类型是CityDaoImplTwo ,所以报错
//	@Resource
//	public void setCityDaoImplOne(CityDaoImplTwo cityDao) {
//		this.cityDao = cityDao;
//	}

    public CitySeriviceImpl() {
//		System.out.println("init CityService");
    }


////	@Override
//	public void query() {
////		cityDao.test();
//		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
//
//		List<Map<String, Object>> select = cityDao.select();
//
//		System.out.println("query --- db ----");
//	}

    //	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware setApplicationContext");
    }

    //	@Override
//	@PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    //PostConstruct 是 applyBeanPostProcessorsBeforeInitialization 调用

    //InitializingBean 是 invokeInitMethods 调用
}
