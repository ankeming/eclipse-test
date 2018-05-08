package com.ankang.test1;

public class Father {
	public static String str ="aaa";
	static{
		System.out.println("父類靜態代碼塊");
		System.out.println("父類靜態變量"+str);
	}
	public Father() {
		System.out.println("父類構造函數");
	}
	{
		System.out.println("父類費靜態代碼塊");
	}
}
