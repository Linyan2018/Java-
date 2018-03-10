package com._520it.day01._04_junit5;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//赋予@MyBefore，@MyAfter，@MyTest功能
//保证三种注解标注方法的执行流程
/*
 操作步骤:
    1):先找到测试类的字节码:EmployeeDAOTest
    2):获取EmployeeDAOTest类中所有的公共方法.
    3):迭代出每一个Method对象.
    4):边迭代边判断,哪一些方法使用了@Before/@Test/@After标签标注.    
             beforeList:  存储使用了@Before标签标注的方法对象.
             testList:       存储使用了@Test标签标注的方法对象.
             afterList:     存储使用了@After标签标注的方法对象.
     5):控制方法执行的流程.
                执行beforeList中的方法
                迭代出testList集合中的每一个方法对象,并执行.
                执行afterList中的方法
*/
public class Junit5Mock {
	public static void main(String[] args) throws Exception {
		//1):先找到测试类的字节码:EmployeeDAOTest
		Class clzz = EmployeeDAOTest.class;
		Object obj = clzz.newInstance();
		//2):获取EmployeeDAOTest类中所有的公共方法.
		Method[] ms = clzz.getMethods();
		//3):迭代出每一个Method对象.
		//4):边迭代边判断,哪一些方法使用了@Before/@Test/@After标签标注.    
		List<Method> beforeList = new ArrayList<>();
		List<Method> testList = new ArrayList<>();
		List<Method> afterList = new ArrayList<>();
		for (Method method : ms) {
			//beforeList: 存储使用了@Before标签标注的方法对象.
			//testList:   存储使用了@Test标签标注的方法对象.
			//afterList:  存储使用了@After标签标注的方法对象.
			if(method.isAnnotationPresent(MyBefore.class)){
				beforeList.add(method);
			}else if(method.isAnnotationPresent(MyTest.class)){
				testList.add(method);
			}else if(method.isAnnotationPresent(MyAfter.class)){
				afterList.add(method);
			}
		}
		//5):控制方法执行的流程.
		//迭代出testList集合中的每一个方法对象,并执行.
		for (Method testM : testList) {
			//执行beforeList中的方法
			for (Method beforeM : beforeList) {
				beforeM.invoke(obj);
			}
			testM.invoke(obj);
			//执行afterList中的方法
			for (Method afterM : afterList) {
				afterM.invoke(obj);
			}
		}
	}
}
