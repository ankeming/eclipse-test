package com.ankang.test1;

import java.math.BigDecimal;

public class VolatileTest implements Runnable{
	private volatile int i=0;
	public void increment(){
		i++;
	}
	public static void main(String[] args) throws InterruptedException {
		while(true){
			VolatileTest vt = new VolatileTest();
			Thread t1 = new Thread(vt);
			Thread t2 = new Thread(vt);
			Thread t3 = new Thread(vt);
			Thread t4 = new Thread(vt);
			Thread t5 = new Thread(vt);
			t1.start();t2.start();t3.start();t4.start();t5.start();
			t1.join();t2.join();t3.join();t4.join();t5.join();
			System.out.println(vt.i);
		}
	}
	@Override
	public void run() {
		for(int i=0;i<1000;i++){
			increment();
		}
	}
}
