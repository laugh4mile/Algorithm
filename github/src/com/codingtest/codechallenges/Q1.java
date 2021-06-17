package com.codingtest.codechallenges;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int solution(int[] a, int[] b) {
	        int answer = 1234567890;
	        answer = 0;
	        for(int i=0; i<a.length; i++){
	            answer += a[i] * b[i];
	        }
	        return answer;
	    }
	}
}
