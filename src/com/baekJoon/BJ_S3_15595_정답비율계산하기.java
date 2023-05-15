package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S3_15595_정답비율계산하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Boolean> map2 = new HashMap<>();
		int numerator = 0; // 분자
		int denominator = 0; // 분모
		
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			tokens.nextToken();
			String userId = tokens.nextToken();
			int result = Integer.parseInt(tokens.nextToken());
			tokens.nextToken();
			tokens.nextToken();
			tokens.nextToken();
			tokens.nextToken();
			
			
			
			if(!userId.equals("megalusion")) {
				if(map2.get(userId) == null) { // 처음 들어온 아이디다?
					if(result == 4) { // 정답일경우
						map2.put(userId, true);
						map1.put(userId, 1);
						numerator++;
					}else { // 오답일 경우
						map2.put(userId, false);
						map1.put(userId, 1);
						
					}
				}else { // 처음 들어온 아이디가 아닐경우? 
					if(!map2.get(userId)){ // 이미 맞은적이 있는지 확인
						if(result == 4) { // 정답일경우
							map2.put(userId, true);
//							map1.put(userId, map1.get(userId)+1);
							numerator++;
							denominator += map1.get(userId);
						}else { // 오답일 경우
							map2.put(userId, false);
							map1.put(userId, map1.get(userId)+1);
						}
					}
				}
			}
		}
//		System.out.println(numerator+" : " + denominator);
//		System.out.println(map1);
//		System.out.println(map2);
		denominator += numerator;
		
		if(numerator==0) {
			System.out.println(0);
		}else {
			System.out.println(((double)numerator/denominator) *100);
		}
	}


	static String src =
			"4\r\n" + 
			"7960654 megalusion 4 90100 868 88 1674\r\n" + 
			"7960868 dogeon01 11 0 0 88 124\r\n" + 
			"7963152 appa 4 55928 284 49 2070\r\n" + 
			"7964434 koosaga 4 31924 124 84 3403";
}
