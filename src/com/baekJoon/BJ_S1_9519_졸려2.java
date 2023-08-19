package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BJ_S1_9519_졸려2 {
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
		StringBuilder head = new StringBuilder();
		StringBuilder tail = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		list.add(word);
		int cnt = 0;
		while(temp>0) {
			head.setLength(0);
			tail.setLength(0);
			if(N%2 == 0) { // 짝
				for(int i=N-1; i>=0; i-=2) {
					tail.append(tempString.charAt(i));
				}
				for(int i=0; i<N; i+=2) {
					head.append(tempString.charAt(i));
				}
			}else { // 홀
				for(int i=N-2; i>=0; i-=2) {
					tail.append(tempString.charAt(i));
				}
				for(int i=0; i<N; i+=2) {
					head.append(tempString.charAt(i));
				}
			}
			head.append(tail);
			tempString = head.toString();
			list.add(tempString);
			if(map.get(tempString) == null) {
				map.put(tempString, cnt++);
			}else {
				break;
			}
			temp--;
		}
		if(temp>0) { // 주기를 발견할 경우
			temp = X % cnt;
			System.out.println(list.get(temp));
		}else {
			System.out.println(tempString);
		}
	}

	static String src =

			"11\r\n" + 
			"srama";
}
