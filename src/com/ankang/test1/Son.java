package com.ankang.test1;

public class Son extends Father {
	public static String str ="bbb";
	static{
		System.out.println("�����o�B���a�K");
		System.out.println("�����o�B׃��"+str);
	}
	public Son() {
		System.out.println("���ט��캯��");
	}
	{
		System.out.println("�����M�o�B���a�K");
	}
	public static void main(String[] args) {
		System.out.println(Son.str);
	}
}
