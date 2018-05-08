package com.test.jdk;

public class UserServiceImpl implements UserService {

	@Override
	public void getName(String name) {
		System.out.println("my name is "+name);
	}

	@Override
	public void getAge(Integer age) {
		System.out.println("I am "+age+" years old.");
	}

}
