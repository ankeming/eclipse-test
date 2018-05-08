package com.test.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	
	private Object target;
	
	public MyInvocationHandler() {
		super();
	}
	
	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object o, Method method, Object[] arg)
			throws Throwable {
		Object result = null;
		System.out.println("jdk��̬������ǿ��ʼ��������");
		result = method.invoke(target, arg);
		System.out.println("jdk��̬������ǿ����.....");
		return result;
	}

}
