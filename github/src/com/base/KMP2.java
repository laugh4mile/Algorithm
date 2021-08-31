package com.base;

import java.util.Arrays;

public class KMP2 {
    static String target = "abcabdabcd";
    static String pattern = "abcd";
    public static void main(String[] args) {
//    	getPi();
        kmp();
    }
    
    static void kmp() {
        int patternSize = pattern.length();
        int targetSize= target.length();
        int[] pi = getPi();
        System.out.println(target);
        System.out.println(pattern);
        System.out.println(Arrays.toString(pi));
        int j = 0;
        for(int i=0; i<targetSize; i++) {
        	System.out.println(j+" , "+ i);
        	while(j>0 && target.charAt(i) != pattern.charAt(j)) {
        		j = pi[j-1];
        	}
        	if(target.charAt(i) == pattern.charAt(j)) {
        		if(j == patternSize -1) {
        			System.out.println(i-patternSize + 2);
        			j = pi[j];
        		}else {
        			j++;
        		}
        	}
        }
        
    }

    static int[] getPi() {
    	int size = pattern.length();
        int[] pi = new int[size]; // pi의 값은 해당 크기에서 접두사와 접미사가 겹치는 수이다.
        int j = 0;
        for(int i=1; i<size; i++) { // 모든 문자를 한개씩 검사함. pi[0]은 무조건 0이므로 i=1 부터 시작.
        	while(j>0 && pattern.charAt(i) != pattern.charAt(j)) { // j가 0 이상일 때, j번째 문자와 i번째 문자가 다르다면
        		j = pi[j-1]; // j 값을 pi[j-1]로 바꿈 
        		
        	}
        	if(pattern.charAt(i) == pattern.charAt(j)) {
        		pi[i] = ++j;
        	}
        }
//        System.out.println(Arrays.toString(pi));
        return pi;
    }
}












