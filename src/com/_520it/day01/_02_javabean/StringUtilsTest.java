package com._520it.day01._02_javabean;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
	public static void main(String[] args) {
		//isBlank():使用了trim()方法
		System.out.println(StringUtils.isBlank(null));//true
		System.out.println(StringUtils.isBlank(""));//true
		System.out.println(StringUtils.isBlank("  "));//true
		System.out.println("--------------------------------");
		System.out.println(StringUtils.isEmpty(null));//true
		System.out.println(StringUtils.isEmpty(""));//true
		System.out.println(StringUtils.isEmpty("  "));//false
		System.out.println(StringUtils.isEmpty("  ".trim()));//true
	}
}
