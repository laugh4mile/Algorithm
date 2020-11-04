package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_14002_가장긴증가하는부분수열4 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, arr[];
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		list.add(Integer.MIN_VALUE);
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			if(list.get(list.size()-1) < arr[i]) {
//				System.out.println("뭐야ㅕ 씨발");
				list.add(arr[i]);
			}else {
				int start = 0;
				int end = list.size()-1;
				int mid = 0;
				
				while(end - start > 0) {
					mid = (start+end)/2;
					if(list.get(mid) < arr[i]) {
						start = mid+1;
					}else {
						end = mid;
					}
				}
				list.set(end, arr[i]);
			}
		}
//		System.out.println(list);
		System.out.println(list.size()-1);
		for(int i=1; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	static String src = 
			"6\r\n" + 
			"1 3 5 7 2 3";
}
