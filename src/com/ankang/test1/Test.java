package com.ankang.test1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {
	public static void main(String[] args) {
//		String[] fileList = {"list_1.htnl","list_10.html","list_100.html","list_111.html","list_109.html","list_11.html"};
//	      List<String> list = Arrays.asList(fileList);
//	      Collections.sort(list, new Comparator<String>() {
//
//			@Override
//			public int compare(String arg0, String arg1) {
//				return Integer.valueOf(arg0.substring(arg0.indexOf("_")+1, arg0.indexOf(".")))-Integer.valueOf(arg1.substring(arg1.indexOf("_")+1, arg1.indexOf(".")));
//			}
//	    	  
//		});
//	      for(String str : list){
//	    	  System.out.println(str);
//	      }
		String str = "I am a student a boy" ;
		String[] array = str.split(" ");
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String string:array){
			if(map.containsKey(string)){
				map.put(string, map.get(string)+1);
			}else{
				map.put(string, 1);
			}
		}
        Map<String, Integer> sortMap = new TreeMap<String, Integer>(
                new Comparator<String>(){

					@Override
					public int compare(String arg0, String arg1) {
						// TODO Auto-generated method stub
//						return arg0.length()-arg1.length();
						return arg0.compareTo(arg1);
					}
                	
                });
        sortMap.putAll(map);
		for(Map.Entry<String,Integer> entry:sortMap.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
