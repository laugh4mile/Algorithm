package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BJ_S4_2217_로프 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N; 
	static Integer rope[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		rope = new Integer[N];
		for(int i=0; i<N; i++) {
			rope[i] = Integer.parseInt(input.readLine());
		}
		
		Arrays.sort(rope, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
//		System.out.println(Arrays.toString(rope));
		int max =0;
		int cnt =0;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			rope[i] = rope[i] * (i+1);
		}
		Arrays.sort(rope);
		System.out.println(rope[N-1]);
		
	}
	static String src = "2\r\n" + 
			"10\r\n" + 
			"15";

}
