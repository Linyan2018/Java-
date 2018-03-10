package com._520it.day01._02_javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class User {
	private Long id;
	private String fistName;
	private String lastName;
	private boolean man;
	
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isMan() {
		return man;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
