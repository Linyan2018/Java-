package com._520it.day01._02_javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

//操作User类中的属性
public class IntrospectorDemo {
	public static void main(String[] args) throws Exception {
		//static BeanInfo getBeanInfo(Class<?> beanClass):获取一份字节码的JavaBean对象
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class,Object.class);
		// PropertyDescriptor[] getPropertyDescriptors()：返回JavaBean对象中的所有属性描述器
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			//属性的名称和类型
			System.out.println(pd.getName() + "," + pd.getPropertyType());
			//属性的操作方法
			Method setter = pd.getWriteMethod();
			Method getter = pd.getReadMethod();
			System.out.println("setter: " + setter);
			System.out.println("getter: " + getter);
			System.out.println("---------------------------------------------");
		}
				
	}
}
