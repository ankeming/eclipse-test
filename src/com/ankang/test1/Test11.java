package com.ankang.test1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test11 {
	public int aa(int[] a){
		int result = 0;
		for(int i = 0;i<32;i++){
			int sum = 0;
			for(int j=0;j<a.length;j++){
				sum += (a[i]>>i)&1;
			}
			result |=(sum%3)<<i;
		}
		return result;
	}
	
	public void bb(int[] a,int n){
		int start = 0;
		int len = a.length-1;
		if(a[start]>n){
			return;
		}
		while(len>start){
			if((a[start]+a[len]) == n){
				System.out.println(a[start] +"+"+a[len]+"="+n);
				start++;
				len--;
			}else if((a[start]+a[len]) > n){
				len--;
			}else if((a[start]+a[len]) < n){
				start++;
			}
		}
	}
	
	public void bb(int n){
		int k=2;
		System.out.print(n+"=");
		while(n>k){
			if(n%k==0){
				System.out.print(k+"*");
				n=n/k;
			}else{
				k++;
			}
		}
		System.out.println(k);
	}
	
	public void cc(){
		for(int i=1;i<1000;i++){
			int gewei = i%10;
			int shiwei = i/10%10;
			int baiwei = i/100%10;
			if((gewei*gewei*gewei+shiwei*shiwei*shiwei+baiwei*baiwei*baiwei)==i){
				System.out.println(i);
			}
		}
	}
	
	public int dd(int n){
		if(n<2){
			return 1;
		}
		return dd(n-1)*n;
	}
	
	public boolean ee(int n){
		boolean result = true;
		for(int i=2;i<n;i++){
			if(n%i==0){
				result = false;
				break;
			}
		}
		return result;
	}
	public void ff(){
		for(int i = 1;i<1000;i++){
			int sum = 0;
			for(int j=1;j<i;j++){
				if(i%j==0){
					sum+=j;
				}
			}
			if(sum==i){
				System.out.println(i);
			}
		}
	}
	
	public void gg(){
		Set<Character> set = new TreeSet<Character>();
		Random random = new Random();
		while(set.size()<20){
			char a = (char) (random.nextInt()%26+97);
			set.add(a);
		}
	}
	
	public int hh(int[] a){
		int result = -1;
		int start = 0;
		int end = a.length;
		if(a[start]==2){
			result= 1;
		}else if(a[end]==999){
			result= 1000;
		}
		if(result == -1){
			while(end>start){
				int middle = (start+end)/2;
				if(a[middle]==a[middle+1]-2){
					result = a[middle]+1;
					break;
				}else if(a[middle]==middle+1){
					start =middle;
				}else if(a[middle]==middle+2){
					end = middle;
				}
			}
		}
		return result;
		
	}
	
	public void hh(int a,int b){
		a=a^b;
		b=a^b;
		a=a^b;
		a=a+b;
		b=a-b;
		a=a-b;
	}
	
	public int hh(){
		List<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<=50;i++){
			list.add(i);
		}
		int index = -1;
		while(list.size()>1){
			index = (index+3)/list.size();
			list.remove(index--);
		}
		return list.get(0);
	}
	
	public int[] ii(int[] a,int[] b){
		int[] c = new int[a.length+b.length];
		int i=0,j=0,k=0;
		while(i<a.length&&j<b.length){
			if(a[i]>b[j]){
				c[k++]=b[j++];
			}else{
				c[k++]=a[i++];
			}
			
		}
		while(i<a.length){
			c[k++]=a[i++];
		}
		while(j<b.length){
			c[k++]=b[j++];
		}
		return c;
	}
	
	public boolean ii(int[] a){
		boolean c = true;
		for(int i = 0;i<a.length;i++){
			if(a[i]>a[i+1]){
				c= false;
				break;
			}
		}
		return c;
	}
	
	public int ii(int month){
		if(month==1||month==2){
            return 1;
     }else if(month==3){
            return 2;
     }
	
     return ii(month-1)+ii(month-3);
	}
	
	public static void main(String[] args) {
//		Integer a = Integer.valueOf(200);
//		int b = Integer.parseInt("200");
//		Integer i1 = 200, i2 = 200; 
//		String str1 = "aaa";
//		String str2 = new String("aaa");
//		String str3 = str2.intern();
//		System.out.println(Integer.MIN_VALUE);
		int[] a = {100,10,5,54,6,63,11,9,21};
		int[] b = null;
		int[] c = {3,1};
//		maopaoSort1(a);
//		maopaoSort2(a);
//		selectSort1(a);
//		selectSort2(a);
//		quickSort(c,0,c.length-1);
//		insertSort(a);
		heapSort(a);
		printArray(a);
	}
	
	public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        buildMaxHeap(arr);  //构建最大堆
        for (int i = arr.length - 1; i >= 1; i--) {
            exchangeElements(arr, 0, i);  //交换堆顶和第0位置元素
            maxHeap(arr, i, 0);  //因为交换元素后，有可能违反堆的性质，所以沉降元素
        }
    }

    private static void buildMaxHeap(int[] arr) {  //构建最大堆
        if (arr == null || arr.length <= 1) {
            return;
        }
        int half = arr.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
    }

    private static void maxHeap(int[] arr, int heapSize, int index) {
        int left = index * 2 + 1;  //左子树上的元素
        int right = index * 2 + 2;  //右子树上的元素
        int largest = index;  //初始化最大元素
        if (left < heapSize && arr[left] > arr[index]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (index != largest) {  //判断根元素是否为最大元素
            exchangeElements(arr, index, largest);
            maxHeap(arr, heapSize, largest);
        }
    }
    
    public static void printArray(int[] arr) {  //打印数组
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void exchangeElements(int[] arr, int index1, int index2) {  //交换元素
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
	
	public static void insertSort(int[] a){
		for(int i=1;i<a.length;i++){
			for(int j = i;j>0;j--){
				if(a[j]<a[j-1]){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}else{
					break;
				}
			}
		}
	}
	
	public static void quickSort(int[] a,int start,int end){
		if(a==null||end-start<1){
			return;
		}
		int value = a[end];
		int index = start-1;
		for(int i = start;i<end;i++){
			if(a[i]<value){
				index++;
				if(index != i){
					int temp1 = a[index];
					a[index] = a[i];
					a[i] = temp1;
				}
			}
		}
		index++;
		if(index != end){
			int temp2 = a[index];
			a[index] = a[end];
			a[end] = temp2;
		}
		if(index == start){
			quickSort(a,index+1,end);
		}else if(index == end){
			quickSort(a,start,index-1);
		}else{
			quickSort(a,start,index-1);
			quickSort(a,index+1,end);
		}
	}
	
	public static void maopaoSort1(int[] a){
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	public static void maopaoSort2(int[] a){
		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	public static void selectSort1(int[] a){
		for(int i=a.length-1;i>0;i--){
			int maxIndex = i;
			for(int j=0;j<i;j++){
				if(a[maxIndex]<a[j]){
					maxIndex = j;
				}
			}
			if(maxIndex != i){
				int temp = a[i];
				a[i] = a[maxIndex];
				a[maxIndex] = temp;
			}
		}
	}
	public static void selectSort2(int[] a){
		for(int i=0;i<a.length-1;i++){
			int maxIndex = i;
			for(int j=i;j<a.length;j++){
				if(a[maxIndex]<a[j]){
					maxIndex = j;
				}
			}
			if(maxIndex != i){
				int temp = a[i];
				a[i] = a[maxIndex];
				a[maxIndex] = temp;
			}
		}
	}
	
	
}
