package com._520it.day02._01_junit;

/**
 * 数学运算
 * @author Administrator
 *
 */
public interface IMath {
	
	/**
	 * 求两个数之和
	 * @param a 加数
	 * @param b 另一个加数
	 * @return 两数之和
	 */
	int add(int a, int b);
	
	/**
	 * 求两个数相除
	 * @param a 被除数
	 * @param b 除数
	 * @return  商
	 */
	int devide(int a, int b);
}
