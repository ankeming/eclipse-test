package com.ankang.test1;

import java.math.BigDecimal;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClass {
	public static void main(String[] args) {
		enumTest test = enumTest.valueOf("RED");
		System.out.println(test.name()+":"+test.ordinal());
		System.out.println(Integer.TYPE==int.class);
		String aa = "111wq222";
		System.out.println(aa.matches("\\d*"));
		Pattern pattern = Pattern.compile("\\d*");
		Matcher matcher = pattern.matcher(aa);
		System.out.println(matcher.matches());
		while(matcher.find()){
			System.out.println(matcher.groupCount());
			System.out.println(matcher.group());
		}
	}
	
	enum enumTest{
		RED(),YELLOW;
	}
}
