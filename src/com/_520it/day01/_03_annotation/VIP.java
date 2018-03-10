package com._520it.day01._03_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VIP {
	String value();
	int age() default 18;
	String[] favs() default {"A","B"};
}
//在注解中，合法的属性类型只有：基本数据类型，String，Class，annotation，枚举，以及数组
