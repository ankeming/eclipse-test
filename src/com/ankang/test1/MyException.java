package com.ankang.test1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class MyException extends RuntimeException{
//	public static void main(String[] args) {
//		File file = new File("");
//		Calendar aa = Calendar.getInstance();
//		System.out.println(Math.round(11.51111));
//		System.out.println(Math.round(-11.5111));
//		System.out.println(2*17);
//		System.out.println(2<<4);
//		System.out.println(1+2+3+4+5+6+7+8+9+10);
//		System.out.println(((1+10)*10)/2);
//	}
	
	@Test
	public void test(){
		double hight = ss(100,10);
		System.out.println("sum:"+sum+"=== hight："+hight);
	}
	
	double sum = 0;
	int count = 0;
	public double ss(double hight,int num){
		if(hight != 0){
			count++;
			if(count==1){
				sum += hight;
			}else{
				sum += 2*hight;
			}
			hight = hight/2;
			if(count<num){
				hight = ss(hight,num);
			}
		}
		return hight;
	}
	
	public boolean isZhiS(int number){
		boolean flag = true;
		if(number<2){
			flag = false;
		}else{
			for(int i=2;i<number;i++){
				if(number%i==0){
					flag = false;
					break;
				}
			}
		}
		return flag;
		
	}
	@Test
	public void test1(){
		int sum = 0;
		for(int i=100;i<=1000;i++){
			boolean flag = isZhiS(i);
			if(flag){
				System.out.println(i);
				sum+=i;
			}
		}
		System.out.println("sum:"+sum);
	}
	
	public int jiec(int number){
		if(number<2){
			return 1;
		}
		return jiec(number-1)*number;
	}
	
	@Test
	public void test2(){
		System.out.println("jiec:"+jiec(4));
	}
	
	@Test
	public void test3(){
		for(int i=1;i<=50;i++){
			if(!(i%3==0)){
				System.out.println(i);
			}
		}
	}
	
	@Test
	public void test4(){
		Set treeSet = new TreeSet<Character>();
		Random rdm = new Random();
		while(treeSet.size()<20){
			int  bb =Math.abs(rdm.nextInt(25))+97;
			treeSet.add((char)bb);
		}
		System.out.println(treeSet.toString());
	}
	
	@Test
	public void test5(){
		System.out.println(removeNM(50,3)); 
	}
	
	public int removeNM(int n, int m) {   
        LinkedList ll = new LinkedList();   
        for (int i = 0; i < n; i++)   
            ll.add(new Integer(i + 1));   
        int removed = -1;   
        while (ll.size() > 1) {   
            removed = (removed + m) % ll.size(); 
            System.out.println((removed + m)+":"+(removed + m) % ll.size()+":"+ll.size());
            ll.remove(removed--);   
        }   
        return ((Integer) ll.get(0)).intValue();   
    }   
	
	@Test
	public void test6(){
		String src = "test测试字符串";
		   int length = 12;
		   String result = null;
		   for (int i = 0; i < src.length(); i++) {
		    if (src.substring(0, i).getBytes().length >= length) {
		     result = src.substring(0, i);
		     break;
		    }
		   }
		   System.out.println(result + "\n");
	}
	@Test
	public void test7(){
		// 在Double和Float类型中有NaN值; Integer,Long中没有.
		   double a = 0, b = 0, c;
		   c = a / (a + b);
		   System.out.println(c + "\n");
	}
	
	@Test
	public void test8(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			if(iterator.next()==3){
				iterator.remove();
			}
		}
		System.out.println(list.toString());
	}
	
	@Test
	public void test9(){
		System.out.println(rabbitNum(10));
	}
	public int rabbitNum(int month){
		//第一个月----1
		//第2个月----1
		//第3个月----2
		//第4个月----3
		//第5个月----4
		//第6个月----6
		//第7个月----9
		//第8个月----13
		//第9个月----19
		//第10个月----28
		if(month==1||month==2){
			return 1;
		}else if(month==3){
			return 2;
		}
		return rabbitNum(month-1)+rabbitNum(month-3);
	}
	
	@Test
	public void test10(){
		String reg="\\d*";
		String str="12345";
		System.out.println(str.matches(reg));
	}
	
}
