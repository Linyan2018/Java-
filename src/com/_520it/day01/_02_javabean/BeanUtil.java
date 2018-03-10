package com._520it.day01._02_javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

//javabean的工具类
public class BeanUtil {
	//把JavaBean转换为Map对象.
	  public static Map<String,Object> bean2map(Object bean) throws Exception{
		Map<String, Object> map = new HashMap<>();
		//获取JavaBean中所有的属性名和属性值
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass(),Object.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			String propertyName = pd.getName();//获得属性名
			Object propertyValue = pd.getReadMethod().invoke(bean);//调用高属性的get方法
			map.put(propertyName, propertyValue);
		}
		
		return map ;
	  }
	//把Map对象转换为JavaBean.
	  public static <T> T map2bean(Map<String,Object> beanMap, Class<T> beanType) 
			  throws Exception{
		  
		  T obj = beanType.newInstance();
		  //获取属性名和属性值
		  BeanInfo beaninfo = Introspector.getBeanInfo(beanType,Object.class);
		  PropertyDescriptor[] pds = beaninfo.getPropertyDescriptors();
		  
		  for (PropertyDescriptor pd : pds) {
			String propertyName = pd.getName();
			Object propertyValue = beanMap.get(propertyName);
			pd.getWriteMethod().invoke(obj, propertyValue);
		  }  
		  return obj;
	  }
	  
	  public static void main(String[] args) throws Exception {
		Person p = new Person(123L,"Kobe","Bryant",true);
		Map<String,Object> map = BeanUtil.bean2map(p);
		System.out.println(map);
		
		Person p2 = BeanUtil.map2bean(map, Person.class);
		System.out.println(p2);
	}

}
