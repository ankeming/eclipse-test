package com.ankang.test1;

import org.junit.Test;

public class TestNumber {
	private int a;
	private long b;
	private double c;
	private char d = 'บว';
	private Byte e =1;;
	private short f;
	private boolean g;
	private float h;
	@Test
	public void main() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(String.valueOf(e));
		String aa="11";
		
	}
	String aa = "11";
	int bb = 120;
	Integer cc=10000000;
	Person person = new Person("ankang", 23, 24);
	public void aaaa(int num,String str,Integer nn,Person per){
		num = 22;
		str = "22";
		nn=200000000;
		per.setName("zhangsan");
		per.setAa(27);
		per.setAa(21);
	}
	@Test 
	public void test(){
		aaaa(bb,aa,cc,person);
		System.out.println(aa+":"+bb+":"+cc);
		System.out.println(person.getName()+":"+person.getAge()+":"+person.getAa());
	}
	public static void main(int aa) {
		Thread thred = new Thread();
		
	}
}
