package com.codingtest.programmers.codechallenges2;

import java.io.IOException;

public class Q1 {
	static int[] absolutes = {4,7,12};
	static boolean[] signs= {true,false,true};
	
	public static int solution(int[] absolutes, boolean[] signs) {
	    int answer = 0;
	    for(int i=0; i<signs.length; i++){
	        if(signs[i]){
	            answer = answer + absolutes[i];
	        }else{
	            answer = answer - absolutes[i];
	        }
	    }
	    return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		solution(absolutes, signs);
	}
}
