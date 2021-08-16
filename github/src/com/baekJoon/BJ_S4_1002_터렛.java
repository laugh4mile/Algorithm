package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_1002_터렛 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		double x1, y1, r1, x2, y2, r2, d1, d2, d3;
		int answer;
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			x1 = Integer.parseInt(tokens.nextToken());
			y1 = Integer.parseInt(tokens.nextToken());
			r1 = Integer.parseInt(tokens.nextToken());
			x2 = Integer.parseInt(tokens.nextToken());
			y2 = Integer.parseInt(tokens.nextToken());
			r2 = Integer.parseInt(tokens.nextToken());
			// 두 지점 사이의 거리
			d1 = Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
			// 반지름의 합
			d2 = r1+r2;
			// 반지름의 차
			d3 = Math.abs(r1-r2);
			
			if(d1 == d2) { // 외접 하는 경우
				answer = 1;
			}else if(d1 < d2) { // 내접하거나 2점이 겹칠 경우나 완전히 일치할 경우
				if(r1==r2 && x1==x2 && y1==y2) {
					answer = -1;
				}else if(d1 == d3) {
					answer = 1;
				}else if(d1 < d3){
					answer = 0;
				}else {
					answer = 2;
				}
			}else { // 안 겹치는 경우
				answer = 0;
			}
			System.out.println(answer);
		}
	}

	static String src =
			"3\r\n"
			+ "0 0 13 40 0 37\r\n"
			+ "0 0 3 0 7 4\r\n"
			+ "1 1 1 1 1 5";
}
