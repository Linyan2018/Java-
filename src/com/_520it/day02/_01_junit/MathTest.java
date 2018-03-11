package com._520it.day02._01_junit;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;

/**
 * MathImpl的测试类
 * @author Administrator
 *
 */
public class MathTest {
	//依赖
	private IMath math = new MathImpl();
	
	@Test
	public void testAdd() {
		int ret = math.add(2, 3);
		//断言方法返回的结果是否和某一个值相等
		Assert.assertEquals("断言失败提示信息", 5, ret);
	}
	
	//期望报错，算术异常:ArithmeticException
	@Test(expected=ArithmeticException.class)
	public void testDevide() {
		int ret = math.devide(9, 3);
		//断言方法返回的结果是否和某一个值相等
		Assert.assertEquals("断言失败提示信息", 3, ret);
	}
	
	@Test(timeout=20)
	public void testTimeOut() throws Exception {
		long begin = System.currentTimeMillis();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			str.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}

}
