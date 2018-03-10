package com._520it.day01._03_annotation;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//认识一些注解
@SuppressWarnings({ "rawtypes", "unused" })
public class AnnotationDemo extends Object{
	
	public void doWork1(){
		Set set = new HashSet();
		List list = null;
	}

	
	//检查当前方法是否覆盖父类的方法
	@Override
	public String toString(){
		return "ABC";
	}
	
	@SuppressWarnings("deprecation")
	public void doWork2(){
		java.util.Date d = new java.util.Date();
		d.toLocaleString();
		this.doWrok3();
	}
	
	@Deprecated
	public void doWrok3(){
		
	}
	
	/**
	 * 在JDK1.5之前，没有注解，如何表示一个成员过时
	 * 由文档注释
	 * @deprecated
	 */
	public void doWork4(){
		
	}
}
