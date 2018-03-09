package com._520it.day01._01_reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


//主板
public class MotherBoard {
	/*public static void install(IUSB m){
		System.out.println("安装" + m.getClass().getSimpleName());
		m.swapData();
	}*/
	private static Properties p = new Properties();
	//用来存储安装的所有插件名称
	private static Map<String,IUSB> plugins = new HashMap<>();
	static {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream inStream = loader.getResourceAsStream("plugins.properties");
			p.load(inStream);
			
			//初始化
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//创建plugins.properties中配置的插件对象，把插件对象存储起来
	private static void init() throws Exception {
		Set<Object> keys = p.keySet();
		for (Object key : keys) {
			String name = (String)key;//获取key
			String className = p.getProperty(name);
			//System.out.println(name + "," + className);
			
			//使用反射创建对象,保证有公共的无参构造器
			Object obj = Class.forName(className).newInstance();
			
			//判断当前对象是否实现了IUSB规范
			if(!(obj instanceof IUSB)){
				throw new RuntimeException(name + "没有遵循USB规范");
			}
			
			plugins.put(name,(IUSB)obj);
		}
	}
	
	//让主板上的插件工作起来
	public static void work(){
		//迭代出安装在主板上的每一个插件，并调用每个插件工作的方法
		for (IUSB plugin : plugins.values()) {
			plugin.swapData();
		}
	}

}
