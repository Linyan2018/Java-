package com._520it.day02._01_junit.junit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeDAOTest {
	@BeforeClass
	public static void staticInit() throws Exception {
		System.out.println("begin...........");
	}
	
	@Before
	public void init() throws Exception {
		System.out.println("初始化...........");
	}
	
	@After
	public void destroy() throws Exception{
		System.out.println("销毁............");
	}
	
	@AfterClass
	public static void staticDestroy() throws Exception{
		System.out.println("end............");
	}
	
	@Test
	public void testSave() throws Exception {
		System.out.println("save...............");
	}
	
	@Test
	public void testDelete() throws Exception {
		System.out.println("delete..............");
	}
	
}
