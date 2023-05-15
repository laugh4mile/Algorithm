package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_14719_빗물 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int H,W,map[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		H = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		map = new int[W];
		tokens = new StringTokenizer(input.readLine());
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		for(int i=0; i<W; i++) {
			map[i] = Integer.parseInt(tokens.nextToken());
			if(max < map[i]) {
				max = map[i];
				maxIndex = i;
			}
		}
		int sum = 0;
		// 왼쪽 끝에서 max 까지
		int start = map[0];
		for(int i=0; i<maxIndex; i++) {
			if(map[i] < start) {
				sum += start - map[i];
			}else {
				start = map[i];
			}
		}
		// 오른쪽 끝에서 정상까지
		start = map[W-1];
		for(int i=W-1; i>maxIndex; i--) {
			if(map[i] < start) {
				sum += start - map[i];
			}else {
				start = map[i];
			}
		}
		System.out.println(sum);
	}

	static String src =

			"4 3\r\n"
			+ "3 1 2";
}
