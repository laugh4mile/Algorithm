package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_S3_17413_단어뒤집기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		String str = input.readLine();
		int size = str.length();
		
		StringBuffer sb = new StringBuffer();
		StringBuffer temp = new StringBuffer();
		for(int i=0; i<size; i++) {
			if(str.charAt(i) == '<') { // 꺽새가 나오면
				if(temp.length() != 0) {
					sb.append(temp.reverse()); // temp에 쌓은걸 뒤집어서 저장함
					temp.setLength(0); // <- 새로운 팁을 배웠다.
				}
				for(int j=i; j<size; j++) {
					sb.append(str.charAt(j));
					if(str.charAt(j) == '>') { // 꺽새가 닫힐때 까지 저장
						i = j;
						break;
					}
				}
			}else if(str.charAt(i) == ' '){ // 공백이 나오면
				if(temp.length() != 0) {
					sb.append(temp.reverse()); // temp에 쌓은걸 뒤집어서 저장함
					temp.setLength(0); // <- 새로운 팁을 배웠다.
				}
				sb.append(' '); // 공백을 넣는걸 잊지말자
			}else { // 이제 깡 문자가 나올 경우이다
				temp.append(str.charAt(i));
			}
		}
		if(temp.length() != 0) { // temp가 비어있지 않다면
			sb.append(temp.reverse());
		}
		System.out.println(sb);
	}
	static String src = 
			"<   space   >space space space<    spa   c e>";
}
