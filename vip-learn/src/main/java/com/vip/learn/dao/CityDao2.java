package com.vip.learn.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CityDao2 {


//	void test();

	@Select("select * from ark_case")
	List<Map<String,Object>> select();
}
