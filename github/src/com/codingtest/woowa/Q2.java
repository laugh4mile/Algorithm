package com.codingtest.woowa;

import java.util.Arrays;

public class Q2 {
	public static void main(String[] args) {
		String s = "987987";
		String op = "-";
		
		long[] answer = {};
        
        int size = s.length();
        answer = new long[size-1];
        int index = 0;
        for(int i=1; i<size; i++){
        	String temp1 = "";
        	String temp2 = "";
        	temp1 = s.substring(0, i);
        	temp2 = s.substring(i,size);
        	
//        	System.out.println(temp1 + " " + temp2);
        	if(op.equals("+")) {
        		answer[index++] = Integer.parseInt(temp1) + Integer.parseInt(temp2); 
        	}
        	if(op.equals("-")) {
        		answer[index++] = Integer.parseInt(temp1) - Integer.parseInt(temp2);
        	}
        	if(op.equals("*")) {
        		answer[index++] = Integer.parseInt(temp1) * Integer.parseInt(temp2);
        	}
        }
        System.out.println(Arrays.toString(answer));
	}
}
