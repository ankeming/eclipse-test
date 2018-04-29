package com.ankang.test1;

public class Person {
	private String name;
	private int age;
	private Integer aa;
	private int test;	
	public Person(String name, int age, Integer aa) {
		super();
		this.name = name;
		this.age = age;
		this.aa = aa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getAa() {
		return aa;
	}
	public void setAa(Integer aa) {
		this.aa = aa;
	}
}
