package com.codingtest.naver;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
	static public String solution(String riddle) {
		int size = riddle.length();
		char letters[] = new char[size];
		StringBuffer result = new StringBuffer();
		if(size == 1) {
			letters[0] = 'a';
		}else {
			for(int i=0; i<size; i++) {
				letters[i] = riddle.charAt(i);
				if(letters[i] == '?') {
					if(i == 0) { // 오른쪽만 비교
						if(letters[i+1] == '?') {
							letters[i] = 'a';
						}else {
							letters[i] = (char) ((letters[i+1]+1)%26 + 'a');
						}
					}else if(i == size-1) { // 왼쪽만 비교
						if(letters[i-1] == '?') {
							letters[i] = 'a';
						}else {
							letters[i] = (char) ((letters[i-1]+1)%26 + 'a');
						}
					}else {
						letters[i] = (char) ((letters[i-1]+1)%26 + 'a');
						if(letters[i] == letters[i+1]) {
							letters[i] = (char) ((letters[i]+1)%26 + 'a');
						}
					}
				}
			}
		}
		for(int i=0; i<size; i++) {
			result.append(letters[i]);
		}
		return result.toString();
	}
	static boolean isIn(int i, int size) {
		return (i>=0 && i<size);
	}
	public static void main(String[] args) {
//		solution("rd?e?wg??");
		System.out.println(solution("asdf?asdf"));
        System.out.println(solution("rd?e?wg??"));
        System.out.println(solution("???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????"));
        System.out.println(solution("ab?ac?"));
        System.out.println(solution("?"));
        System.out.println(solution("??"));
	}
}
