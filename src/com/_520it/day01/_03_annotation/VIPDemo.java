package com._520it.day01._03_annotation;

import java.lang.annotation.Annotation;

//被贴的程序元素
@VIP(value="A",age=99,favs={"A","B","C"})
@SuppressWarnings("all")
class Employee {
	
}

//第三方程序，赋予VIP注解特殊的功能
public class VIPDemo {
	public static void main(String[] args) {
		//需求1：获取Employee类上所有的注解
		Annotation[] as = Employee.class.getAnnotations();
		System.out.println(as.length);
		
		//需求2：获取Employee类上的VIP注解
		if(Employee.class.isAnnotationPresent(VIP.class)){
			VIP vip = Employee.class.getAnnotation(VIP.class);
			String l = vip.value();
			System.out.println(l);
		}
		
	}
}
