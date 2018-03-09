package com._520it.day01._01_reflect;

public class App {
	public static void main(String[] args) {
		/*Mouse m = new Mouse();
		MotherBoard.install(m);
		//匿名内部类
		MotherBoard.install(new IUSB(){
			public void swapData() {
				System.out.println("键盘在输入...");
			}
			
		});
		MotherBoard.install(new KeyBoard());*/
		
		MotherBoard.work();
	}
}
