package com.ankang.test1;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class TestString {
	@Test 
	public void test() throws UnsupportedEncodingException{
		System.out.println(reverse("123456"));
		System.out.println(reverseC("Hello World"));
		charSetChange();
	}
	
	public String reverse(String str){
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		return sb.toString();
	}
	
	public String reverseC(String str){
		String[] array = str.split(" ");
		for(int i=0;i<array.length;i++){
			StringBuffer sb = new StringBuffer(array[i]);
//			array[i]=sb.reverse().toString();
			System.out.print(sb.reverse().toString()+" ");
		}
		return array.toString();
	}
	
	public void charSetChange() throws UnsupportedEncodingException{
		System.out.println(Charset.defaultCharset());
		String str1 = new String("hello world".getBytes(),"GB2312" );
		System.out.println(str1);
		String str2 = new String(str1.getBytes("GB2312"),"ISO-8859-1");
		System.out.println(str2);
		
	}
	
	@Test 
	public void test1(){
		List list1 = new ArrayList<>();
		List list2 = new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list1.add("2");
		list1.add("4");
		list2.add("1");
		list2.add("2");
		list2.add("2");
		list2.add("5");
		list1.retainAll(list2);
		System.out.println(list1.toString());
	}
	
	
	public class Reader {
	    private String strNum;
	    private String strNumChFormat;
	    private String strNumTemp;
	    private int intNumLen;
	    private String strBegin;
	    public Reader(String strNum) {
	        this.strNum = strNum;
	    }

	    public boolean check(String strNum) {
	        boolean valid = false;

	        if (strNum.substring(0,1).equals("0")){
	            this.strNum = strNum.substring(1);
	        }
	        try {
	            new Double(strNum);
	            valid = true;
	        } catch (NumberFormatException ex) {
	            System.out.println("Bad number format!");
	        }

	        return valid;
	    }

	    public void init() {
	        strNumChFormat = "";
	        intNumLen = strNum.length();
	        strNumTemp = strNum;
	        strNumTemp = strNumTemp.replace('1', '一');
	        strNumTemp = strNumTemp.replace('2', '二');
	        strNumTemp = strNumTemp.replace('3', '三');
	        strNumTemp = strNumTemp.replace('4', '四');
	        strNumTemp = strNumTemp.replace('5', '五');
	        strNumTemp = strNumTemp.replace('6', '六');
	        strNumTemp = strNumTemp.replace('7', '七');
	        strNumTemp = strNumTemp.replace('8', '八');
	        strNumTemp = strNumTemp.replace('9', '九');
	        strNumTemp = strNumTemp.replace('0', '零');
	        strNumTemp = strNumTemp.replace('.', '点');
	        strBegin = strNumTemp.substring(0, 1);
	    }

	    public String readNum() {
	        if (check(strNum)) {
	            init();
	            try {
	                for (int i = 1, j = 1, k = 1; i < intNumLen; i++) {
	                    if (strNumTemp.charAt(intNumLen - 1) == '零' && i == 1) {
	                        strNumChFormat = "位";
	                    } else if (strNumTemp.charAt(intNumLen - i) == '零' && j == 1) {
	                        strNumChFormat = "位" + strNumChFormat;
	                    } else if (strNumTemp.charAt(intNumLen - i) == '点') {
	                        j = 1;
	                        k = 1;
	                        strNumChFormat = strNumTemp.charAt(intNumLen - i) + strNumChFormat;
	                        continue;
	                    } else {
	                        strNumChFormat = strNumTemp.charAt(intNumLen - i) + strNumChFormat;
	                    }
	                    
	                    if (strNumTemp.charAt(intNumLen - i - 1) != '位' &&
	                        strNumTemp.charAt(intNumLen - i - 1) != '零') {
	                        if (j == 1 && i < intNumLen) {
	                            strNumChFormat = '拾' + strNumChFormat;
	                        } else if (j == 2 && i < intNumLen) {
	                            strNumChFormat = '百' + strNumChFormat;
	                        } else if (j == 3 && i < intNumLen) {
	                            strNumChFormat = '千' + strNumChFormat;
	                        }
	                    }

	                    if (j == 4 && i < intNumLen) {
	                        j = 0;
	                    }
	                    
	                    if (k == 4 && i < intNumLen) {
	                        strNumChFormat = '万' + strNumChFormat;
	                    } else if (k == 8 && i < intNumLen) {
	                        k = 0;
	                        strNumChFormat = '亿' + strNumChFormat;
	                    }
	                    j++;
	                    k++;
	                }
	                
	                while (strNumChFormat.indexOf("位") != -1) {
	                    strNumChFormat = strNumChFormat.replaceAll("位", " ");
	                }
	                
	                if (strNumChFormat.substring(0, 2) == "一拾") {
	                    strNumChFormat = strNumChFormat.substring(1, strNumChFormat.length());
	                }
	                
	                if (strNumChFormat.indexOf("点") >= 0) {
	                    String rebegin = strNumChFormat.substring(0,
	                    strNumChFormat.indexOf("点"));
	                    String relast = strNumChFormat.substring(strNumChFormat.indexOf("点"),
	                    strNumChFormat.length());
	                    
	                    for (int i = 1; i <= relast.length(); i++) {
	                        relast = relast.replaceAll("拾", "");
	                        relast = relast.replaceAll("百", "");
	                        relast = relast.replaceAll("千", "");
	                        relast = relast.replaceAll("万", "");
	                        relast = relast.replaceAll("亿", "");
	                    }
	                    strNumChFormat = rebegin + relast;
	                }
	            } catch (ArrayIndexOutOfBoundsException ex) {
	                ex.printStackTrace();
	            }
	            
	            int off = strNumChFormat.indexOf("点");
	            strNumChFormat = strBegin + strNumChFormat.substring(0);
	        } else {
	            strNumChFormat = "";
	        }
	        
	        return strNumChFormat;
	    }
	    @Test
	    public void main(String args[]) {
	        try {
	            String number = args[0].toString();
	            System.out.println("The number is: " + number);
	            Reader reader = new Reader(number);
	            System.out.println("Output String: " + reader.readNum());
	        } catch (Exception ex) {
	            System.out.println("Please input like that: javac Reader <number>");
	        }
	    }
	}
}
