package com.codingtest.bro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class q1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src)); // 입력
		String word = input.readLine(); // 입력 String에 담음
		StringBuilder sb = new StringBuilder(); // String으로 특정 인덱스 문자 바꾸기 어려워서 StringBuilder 생성  
		sb.append(word); // StringBuilder에 담음
		int size = word.length(); // 문자열 길이
		
		char pre ; // 이전
		char cur ; // 현재
		char next ; // 다음
		int cnt = 1; // 연속되는 횟수. i가 0이 아니라 1 부터 시작하므로 1로 초기화 
		int answer = 0; // 문자가 바뀌는 횟수
		for(int i=1; i<size-1; i++) { // 0~size가 아니라 1~size-1 까지. '이전'과 '다음'을 고려하기 위함임
			System.out.println(cnt);
			pre = sb.charAt(i-1);
			cur = sb.charAt(i);
			next = sb.charAt(i+1);
			if(cur == pre) {
				cnt++; // 현재 문자와 이전 문자가 같을 경우 연속 횟수 cnt 증가
			}else { // 달라질 경우 연속횟수 1로 다시 초기화
				cnt = 1;
			}
			if(cnt>=3) { // 3개가 연속되는 경우
				if(next == cur) { // 다음문자와 현재문자가 같을 경우
					if(cur == 'a') { // 현재 문자를 바꿔줌
						sb.setCharAt(i, 'b');
					}else {
						sb.setCharAt(i, 'a');
					}
				}else { // 다를경우
					if(cur == 'a') { // 이전 문자를 바꿔줌
						sb.setCharAt(i-1, 'b');
					}else {
						sb.setCharAt(i-1, 'a');
					}
					cnt = 1; // 문자가 달라졌으므로 다시 연속되는 숫자를 1로 초기화
				}
				answer++; // 문자를 바꾼 횟수 1 증가
			}
			if(i == size-2 && cnt == 2) { // for문을 다 돌았을때 cnt가 2이면 마지막 문자가 같은지 확인해야 한다.
				if(cur == next) {
					answer++;
					if(cur == 'a') {
						sb.setCharAt(size-1, 'b');
					}else {
						sb.setCharAt(size-1, 'a');
					}
				}
			}
		}
		System.out.println(sb);
		System.out.println(answer);
	}

	static String src =
			"aabbbbbbbbbababbbbaabaaabbb";
//			"baaaaaa";
}	
