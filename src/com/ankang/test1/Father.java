package com.ankang.test1;

public class Father {
	public static String str ="aaa";
	static{
		System.out.println("����o�B���a�K");
		System.out.println("����o�B׃��"+str);
	}
	public Father() {
		System.out.println("����캯��");
	}
	{
		System.out.println("����M�o�B���a�K");
	}
}
