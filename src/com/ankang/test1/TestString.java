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
	        strNumTemp = strNumTemp.replace('1', 'һ');
	        strNumTemp = strNumTemp.replace('2', '��');
	        strNumTemp = strNumTemp.replace('3', '��');
	        strNumTemp = strNumTemp.replace('4', '��');
	        strNumTemp = strNumTemp.replace('5', '��');
	        strNumTemp = strNumTemp.replace('6', '��');
	        strNumTemp = strNumTemp.replace('7', '��');
	        strNumTemp = strNumTemp.replace('8', '��');
	        strNumTemp = strNumTemp.replace('9', '��');
	        strNumTemp = strNumTemp.replace('0', '��');
	        strNumTemp = strNumTemp.replace('.', '��');
	        strBegin = strNumTemp.substring(0, 1);
	    }

	    public String readNum() {
	        if (check(strNum)) {
	            init();
	            try {
	                for (int i = 1, j = 1, k = 1; i < intNumLen; i++) {
	                    if (strNumTemp.charAt(intNumLen - 1) == '��' && i == 1) {
	                        strNumChFormat = "λ";
	                    } else if (strNumTemp.charAt(intNumLen - i) == '��' && j == 1) {
	                        strNumChFormat = "λ" + strNumChFormat;
	                    } else if (strNumTemp.charAt(intNumLen - i) == '��') {
	                        j = 1;
	                        k = 1;
	                        strNumChFormat = strNumTemp.charAt(intNumLen - i) + strNumChFormat;
	                        continue;
	                    } else {
	                        strNumChFormat = strNumTemp.charAt(intNumLen - i) + strNumChFormat;
	                    }
	                    
	                    if (strNumTemp.charAt(intNumLen - i - 1) != 'λ' &&
	                        strNumTemp.charAt(intNumLen - i - 1) != '��') {
	                        if (j == 1 && i < intNumLen) {
	                            strNumChFormat = 'ʰ' + strNumChFormat;
	                        } else if (j == 2 && i < intNumLen) {
	                            strNumChFormat = '��' + strNumChFormat;
	                        } else if (j == 3 && i < intNumLen) {
	                            strNumChFormat = 'ǧ' + strNumChFormat;
	                        }
	                    }

	                    if (j == 4 && i < intNumLen) {
	                        j = 0;
	                    }
	                    
	                    if (k == 4 && i < intNumLen) {
	                        strNumChFormat = '��' + strNumChFormat;
	                    } else if (k == 8 && i < intNumLen) {
	                        k = 0;
	                        strNumChFormat = '��' + strNumChFormat;
	                    }
	                    j++;
	                    k++;
	                }
	                
	                while (strNumChFormat.indexOf("λ") != -1) {
	                    strNumChFormat = strNumChFormat.replaceAll("λ", " ");
	                }
	                
	                if (strNumChFormat.substring(0, 2) == "һʰ") {
	                    strNumChFormat = strNumChFormat.substring(1, strNumChFormat.length());
	                }
	                
	                if (strNumChFormat.indexOf("��") >= 0) {
	                    String rebegin = strNumChFormat.substring(0,
	                    strNumChFormat.indexOf("��"));
	                    String relast = strNumChFormat.substring(strNumChFormat.indexOf("��"),
	                    strNumChFormat.length());
	                    
	                    for (int i = 1; i <= relast.length(); i++) {
	                        relast = relast.replaceAll("ʰ", "");
	                        relast = relast.replaceAll("��", "");
	                        relast = relast.replaceAll("ǧ", "");
	                        relast = relast.replaceAll("��", "");
	                        relast = relast.replaceAll("��", "");
	                    }
	                    strNumChFormat = rebegin + relast;
	                }
	            } catch (ArrayIndexOutOfBoundsException ex) {
	                ex.printStackTrace();
	            }
	            
	            int off = strNumChFormat.indexOf("��");
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
