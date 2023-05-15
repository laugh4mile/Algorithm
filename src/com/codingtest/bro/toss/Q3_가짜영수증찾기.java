package com.codingtest.bro.toss;

import java.io.IOException;

public class Q3_가짜영수증찾기 {
	static String amountText = "0"; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		if(solution(amountText)) {
			System.out.println("참");
		}else {
			System.out.println("거짓");
		}
	}
	private static boolean solution(String amountText) {
		boolean answer = true;
		int size = amountText.length();
		boolean hasComma = false;
		// 양끝이 숫자가 아니면 false
		if(!Character.isDigit(amountText.charAt(0))) return false;
		if(!Character.isDigit(amountText.charAt(size-1))) return false;
		// 맨 왼쪽이 0이면 false
		if(size>1 && amountText.charAt(0) == '0') return false;
		for(int i=0; i<size; i++) {
			char cur = amountText.charAt(i);
			if(!Character.isDigit(cur)) { // 숫자가 아닐경우
				if(cur != ',') { // 콤마도 아닐경우
					return false;
				}else {
					hasComma = true;
				}
			}
		}
		// 여기 까지 통과하면 문자열은 숫자 또는 콤마만 가진 상태이다.
		if(!hasComma) return true;
		
		int cnt = 0;
		for(int i=size-1; i>=0; i--) {
			char cur = amountText.charAt(i);
			if(cnt%4 == 3 && amountText.charAt(i)!=',') {
				return false;
			}
			cnt++;
		}
		return answer;
	}

}
