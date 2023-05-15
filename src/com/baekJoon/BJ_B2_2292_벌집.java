package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B2_2292_벌집 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		int cnt=0, hap=1;
		
		if(N == 1) {
			System.out.println(1);
		}else {
			while(N>hap) {
				hap += 6*cnt;
				cnt++;
			}	
			System.out.println(cnt);
		}
	}
	static String src = 
			"13";

}
