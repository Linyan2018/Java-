package com._520it.day02._01_junit.junit3;

import static org.junit.Assert.*;

import junit.framework.TestCase;

//EmployeeDAO的测试类，用来测试员工的增删改查操作
public class EmployeeDAOTest extends TestCase{
	
	//若要在测试方法之前做准备操作
	protected void setUp() throws Exception {
		System.out.println("初始化...........");
	}
	
	//若要在测试方法之后做回收操作
	protected void tearDown() throws Exception {
		System.out.println("销毁操作...........");
	}
	
	//测试保存操作
	public void testSave() throws Exception{
		System.out.println("save.........");
	}
	
	//测试删除操作
	public void testDelete() throws Exception{
		System.out.println("delete..........");
	}
	
		
}
