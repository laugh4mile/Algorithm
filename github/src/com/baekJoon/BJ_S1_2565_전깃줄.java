package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S1_2565_전깃줄 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int arr[][] = new int[N][2];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			arr[i][0] = from;
			arr[i][1] = to;
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		List<Integer> list = new ArrayList<>();
		list.add(0);
		for(int i=0; i<N; i++) {
			if(list.get(list.size()-1) < arr[i][1]) {
				list.add(arr[i][1]);
			}else {
				int start = 0;
				int end = list.size()-1;
				int mid = 0;
				
				while(end - start > 0) {
					mid = (end + start) / 2;
					if(list.get(mid) < arr[i][1]) {
						start = mid + 1;
					}else {
						end = mid;
					}
				}
				list.set(end, arr[i][1]);
			}
		}
		System.out.println(N-(list.size()-1));
	}

	static String src =
			"8\r\n" + 
			"1 8\r\n" + 
			"3 9\r\n" + 
			"2 2\r\n" + 
			"4 1\r\n" + 
			"6 4\r\n" + 
			"10 10\r\n" + 
			"9 7\r\n" + 
			"7 6";
}
