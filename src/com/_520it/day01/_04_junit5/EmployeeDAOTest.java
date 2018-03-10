package com._520it.day01._04_junit5;

//EmployeeDAO的测试类
public class EmployeeDAOTest {
	@MyBefore
	public void init(){
		System.out.println("初始化...");
	}
	
	@MyAfter
	public void destroy(){
		System.out.println("销毁...");
	}
	
	//测试保存
	@MyTest
	public void testSave() throws Exception{
		System.out.println("save.....");
	}
	//测试删除
	@MyTest
	public void testDelete() throws Exception{
		System.out.println("delete.....");
	} 
}
