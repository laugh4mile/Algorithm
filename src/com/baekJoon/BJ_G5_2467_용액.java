package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_G5_2467_용액 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int min=Integer.MAX_VALUE, answer1, answer2;
	static Integer arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new Integer[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
		});
		
		for(int i=0; i<N-1; i++) {
			if(Math.abs(arr[i]+arr[i+1]) < min) {
				min = Math.abs(arr[i]+arr[i+1]);
				answer1 = arr[i];
				answer2 = arr[i+1];
			}
		}
		if(answer1<answer2) {
			System.out.println(answer1+" "+answer2);
		}else {
			System.out.println(answer2+" "+answer1);
		}
	}

	static String src =
			"5\r\n" + 
			"-99 -2 -1 4 98";
}
