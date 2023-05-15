package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_S1_9519_졸려 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int X;
	static String word;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		X = Integer.parseInt(input.readLine());
		int temp = X;
		word = input.readLine();
		int N = word.length();
		String tempString = word;
		String head, tail;
		Map<String, Integer> map = new HashMap<>();
		int cnt = 0;
		while(temp>0) {
			head = "";
			tail = "";
			if(N%2 == 0) { // 짝
				for(int i=N-1; i>=0; i-=2) {
					tail += tempString.charAt(i);
				}
				for(int i=0; i<N; i+=2) {
					head += tempString.charAt(i);
				}
			}else { // 홀
				for(int i=N-2; i>=0; i-=2) {
					tail += tempString.charAt(i);
				}
				for(int i=0; i<N; i+=2) {
					head += tempString.charAt(i);
				}
			}
			tempString = head+tail;
			if(map.get(tempString) == null) {
				map.put(tempString, cnt++);
			}else {
				break;
			}
			temp--;
		}
		if(temp>0) { // 주기를 발견할 경우
			temp = X % cnt;
			tempString = word;
			while(temp>0) {
				head = "";
				tail = "";
				if(N%2 == 0) { // 짝
					for(int i=N-1; i>=0; i-=2) {
						tail += tempString.charAt(i);
					}
					for(int i=0; i<N; i+=2) {
						head += tempString.charAt(i);
					}
				}else { // 홀
					for(int i=N-2; i>=0; i-=2) {
						tail += tempString.charAt(i);
					}
					for(int i=0; i<N; i+=2) {
						head += tempString.charAt(i);
					}
				}
				tempString = head+tail;
				temp--;
			}
			System.out.println(tempString);
		}else {
			System.out.println(tempString);
		}
	}

	static String src =

			"11\r\n" + 
			"srama";
}
