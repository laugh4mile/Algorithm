package com.codingtest.woowa;

public class Q1 {
	class Solution {
	    public int solution(String[] grades, int[] weights, int threshold) {
	        int answer = -1234567890;
	        int sum = 0;
	        for(int i=0; i<grades.length; i++){
	            if(grades[i].equals("A+")){
	                sum += 10 * weights[i];
	            }
	            if(grades[i].equals("A0")){
	                sum += 9 * weights[i];
	            }
	            if(grades[i].equals("B+")){
	                sum += 8 * weights[i];
	            }
	            if(grades[i].equals("B0")){
	                sum += 7 * weights[i];
	            }
	            if(grades[i].equals("C+")){
	                sum += 6 * weights[i];
	            }
	            if(grades[i].equals("C0")){
	                sum += 5 * weights[i];
	            }
	            if(grades[i].equals("D+")){
	                sum += 4 * weights[i];
	            }
	            if(grades[i].equals("D0")){
	                sum += 3 * weights[i];
	            }
	            if(grades[i].equals("F")){
	                sum += 0 * weights[i];
	            }
	        }
	        answer = sum - threshold;
	        return answer;
	    }
	}
}
