package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_16198_에너지모으기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, max = Integer.MIN_VALUE;
//	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		List<Integer> list = new ArrayList<>();
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			list.add(Integer.parseInt(tokens.nextToken()));
		}
		dfs(list,0);
		System.out.println(max);
	}

	private static void dfs(List<Integer> list, int sum) {
		if(list.size()<=2) {
			if(max < sum) {
				max = sum;
			}
			return;
		}
		
		for(int i=1; i<list.size()-1; i++) {
			int temp = list.get(i);
			int num = list.get(i-1) * list.get(i+1);
			list.remove(i);
			dfs(list, sum + num);
			list.add(i, temp);
		}
	}

	static String src =
			"7\r\n" + 
			"2 2 7 6 90 5 9";
}