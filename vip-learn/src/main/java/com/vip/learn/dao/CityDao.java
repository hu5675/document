package com.vip.learn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CityDao extends BaseMapper<ArkCase>{


//	void test();

	@Select("select * from ark_case")
	List<Map<String,Object>> select();
}
