package com._520it.day01._02_javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private Long id;
	private String fistName;
	private String lastName;
	private boolean man;
	
	/*//属性为fullName   ：Kobe#Bryant
	public void setFullName(String fullName){
		String[] names = fullName.split("#");
		if(names != null && names.length == 2){
			this.fistName = names[0];
			this.lastName = names[1];
		}
	}
	
	//属性为fullName:此时fullName只有属性，没有字段
	public String getFullName(){
		return this.fistName + "#" + this.lastName;
	}*/
	
	
}
