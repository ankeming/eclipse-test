package com.ankang.test1;

public class TestSort {
	public static void main(String[] args) {
		int[] a = {100,10,5,54,6,63,11,9,21};
//		heapSelect(a);
//		quickSort(a,0,a.length-1);
//		maopaoSort(a);
//		selectSort1(a);
//		selectSort2(a);
//		insertSort(a);
		unionSort(a);
		printArray(a);
	}
	
	//πÈ≤¢≈≈–Ú----------start
	public static void unionSort(int[] array){
		unionSort(array,0,array.length-1);
	}
	public static void unionSort(int[] array, int start, int end) {
		if(start==end){
			return;
		}
		int split;
		int totalSize = end - start +1;
		if(totalSize%2==0){
			split = start + totalSize/2-1;
		}else{
			split = start + totalSize/2;
		}
		unionSort(array,start,split);
		unionSort(array,split+1,end);
		mergeArray(array,start,split,end);
	}
	public static void mergeArray(int[] array, int start, int split, int end) {
		int total = end - start +1;
		int size1 = split - start +1;
		int size2 = end - split;
		int[] arr1 = new int[size1];
		int[] arr2 = new int[size2];
		int mergeCount = 0,index1=0,index2=0;
		for(int i = 0;i<size1;i++){
			arr1[i] = array[start+i];
		}
		for(int i = 0;i<size2;i++){
			arr2[i] = array[split+1+i];
		}
		while(mergeCount < total){
			if(index1==size1){
				for(int i=index2;i<size2;i++){
					array[start+mergeCount] = arr2[i];
					mergeCount++;
					index2++;
				}
			}
			else if(index2==size2){
				for(int i=index1;i<size1;i++){
					array[start+mergeCount] = arr1[i];
					mergeCount++;
					index1++;
				}
			}
			else{
				int value1 = arr1[index1];
				int value2 = arr2[index2];
				if(value1==value2){
					array[start+mergeCount] = value1;
					array[start+mergeCount+1] = value2;
					mergeCount++;
					index1++;
					index2++;
				}else if(value1<value2){
					array[start+mergeCount] = value1;
					mergeCount++;
					index1++;
				}else if(value1>value2){
					array[start+mergeCount] = value2;
					mergeCount++;
					index2++;
				}
			}
		}
	}
	//πÈ≤¢≈≈–Ú----------end

	//≤Â»Î≈≈–Ú----------start
	public static void insertSort(int[] array){
		for(int i=1;i<array.length;i++){
			for(int j=i;j>0;j--){
				if(array[j]<array[j-1]){
					changeValue(array, j, j-1);
				}else{
					break;
				}
			}
		}
	}
	//≤Â»Î≈≈–Ú----------end
	//√∞≈›≈≈–Ú----------start
	public static void maopaoSort(int[] array){
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(array[j]>array[j+1]){
					changeValue(array, j, j+1);
				}
			}
		}
	}
	//√∞≈›≈≈–Ú----------end
	//—°‘Ò≈≈–Ú----------start
	public static void selectSort1(int[] array){
		for(int i=array.length-1;i>0;i--){
			int maxIndex = i;
			for(int j=i;j>=0;j--){
				if(array[j]>array[maxIndex]){
					maxIndex = j;
				}
			}
			if(maxIndex != i){
				changeValue(array, i, maxIndex);
			}
		}
	}
	public static void selectSort2(int[] array){
		for(int i=array.length-1;i>0;i--){
			int maxIndex = i;
			for(int j=0;j<i;j++){
				if(array[j]>array[maxIndex]){
					maxIndex = j;
				}
			}
			if(maxIndex != i){
				changeValue(array, i, maxIndex);
			}
		}
	}
	//—°‘Ò≈≈–Ú----------end
	//øÏÀŸ≈≈–Ú----------start
	public static void quickSort(int[] array,int start,int end){
		if(array==null||end-start<1){
			return;
		}
		int value = array[end];
		int index = start - 1;
		for(int i = start;i <end;i++){
			if(array[i]<value){
				index++;
				if(i != index){
					changeValue(array, index, i);
				}
			}
		}
		index++;
		if(index != end){
			changeValue(array, index, end);
		}
		if(index==start){
			quickSort(array, index+1, end);
		}else if(index == end){
			quickSort(array, start, index-1);
		}else{
			quickSort(array, start, index-1);
			quickSort(array, index+1, end);
		}
		
	}
	//øÏÀŸ≈≈–Ú----------end
	//∂—≈≈–Ú----------start
	public static void heapSelect(int[] array){
		if(array==null||array.length<2){
			return;
		}
		buildHeap(array);//¥¥Ω®◊Ó¥Û∂—
		for(int i = array.length-1;i>0;i--){
			changeValue(array, 0, i);
			maxHeap(array, i, 0);
		}
	}

	public static void buildHeap(int[] array) {
		if(array==null||array.length<2){
			return;
		}
		int half = array.length/2;
		for(int i = half;i>=0;i--){
			maxHeap(array,array.length,i);
		}
	}

	public static void maxHeap(int[] array, int heapSize, int index) {
		int left = index*2 + 1;
		int right = index*2 +2;
		int largest = index;
		if(left < heapSize && array[left] > array[index]){
			largest = left;
		}
		if(right < heapSize && array[right] > array[largest]){
			largest = right;
		}
		if(largest != index){
			changeValue(array,index,largest);
			maxHeap(array, heapSize, largest);
		}
	}
	//∂—≈≈–Ú----------end
	
	public static void changeValue(int[] array,int index1,int index2) {
		if(array==null||array.length<2||index1<0||index2<0||index1>array.length-1||index2>array.length-1){
			return;
		}
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void printArray(int[] array) {
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
			if(i != array.length-1){
				System.out.print(",");
			}
		}
		System.out.println();
	}
}
