package com.test.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestJdk {
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		InvocationHandler myInvocation = new MyInvocationHandler(userService);
		userService = (UserService) Proxy.newProxyInstance(userService.getClass()
				.getClassLoader(), userService.getClass().getInterfaces(), myInvocation);
		
		System.out.println(userService.getClass().getName());
		userService.getName("ankang");
		userService.getAge(1);
	}
}
