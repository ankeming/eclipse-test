package com.ankang.test1;

public class Son extends Father {
	public static String str ="bbb";
	static{
		System.out.println("子类靜態代碼塊");
		System.out.println("子类靜態變量"+str);
	}
	public Son() {
		System.out.println("自雷構造函數");
	}
	{
		System.out.println("自雷費靜態代碼塊");
	}
	public static void main(String[] args) {
		System.out.println(Son.str);
	}
}
