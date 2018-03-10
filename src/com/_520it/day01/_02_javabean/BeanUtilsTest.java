package com._520it.day01._02_javabean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.LongConverter;

//测试commons-beanutils提供的工具类BeanUtils
public class BeanUtilsTest {
	public static void main(String[] args) throws Exception {
		//把一个Map对象/JavaBean对象中的数据拷贝到另一个对象中
		Person p = new Person();
		Map<String,Object> map1 = new HashMap<>();
		map1.put("id", "");
		map1.put("firstName", "燕");
		map1.put("lastName", "林");
		map1.put("man", "false");
		map1.put("hireDate", "2018-03-10");
		
		DateConverter dateConverter = new DateConverter(null);
		dateConverter.setPatterns(new String[]{"yyyy-mm-dd","yyyy/mm/dd"});
		ConvertUtils.register(dateConverter, java.util.Date.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		
		BeanUtils.copyProperties(p, map1);
		System.out.println(p);
		
		Person p2 = new Person();
		BeanUtils.copyProperties(p2, p);
		System.out.println(p2);
		
		//获取指定对象中指定属性的值
		String value = BeanUtils.getProperty(p, "firstName");
		System.out.println(value);
	}
}
