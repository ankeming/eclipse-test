package com.ankang.test1;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueDemo {
	private Vector<Object> vector = new Vector<Object>();
	private int size = 16;
	ReentrantLock lock = new ReentrantLock();
	Condition con = lock.newCondition();
	public BlockQueDemo() {
		super();
	}
	
	public BlockQueDemo(int size) {
		this.size = size;
	}
	
	public void put(Object object){
//		final ReentrantLock lock = this.lock;
		try{
			lock.lock();
			while(vector.size()==size)
				con.await();
			vector.add(object);
			Thread.sleep(10000);
			con.signal();
		}catch(Exception e){
			
		}finally{
			lock.unlock();
		}
	}
	
	public Object take(){
//		final ReentrantLock lock = this.lock;
		Object result = null;
		try{
			lock.lock();
			while(vector.size()==0)
				con.await();
			result = vector.get(0);
			vector.remove(0);
			con.signal();
		}catch(Exception e){
			
		}finally{
			lock.unlock();
		}
		return result;
	}
	
	public static void main(String[] args) {
		BlockQueDemo que = new BlockQueDemo(2);
//		new Thread(que.new get()).start();
		new Thread(que.new set()).start();
		new Thread(que.new set()).start();
//		new Thread(que.new get()).start();
		
	}
	class get implements Runnable{
		@Override
		public void run() {
			System.out.println(take());
		}
		
	}
	
	class set implements Runnable{
		
		@Override
		public void run() {
			put(1);
			System.out.println(Thread.currentThread().getName());
		}
		
	}
}
