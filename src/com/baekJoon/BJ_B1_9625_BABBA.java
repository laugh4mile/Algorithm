package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_B1_9625_BABBA {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int K = Integer.parseInt(input.readLine());
		int AB [][] = new int[46][2];
		AB[0][0] = 1;
		AB[0][1] = 0;
		AB[1][0] = 0;
		AB[1][1] = 1;
		
		for(int i=2; i<=45; i++) {
			AB[i][0] = AB[i-1][0] + AB[i-2][0];
			AB[i][1] = AB[i-1][1] + AB[i-2][1];
		}
		System.out.println(AB[K][0]+" "+AB[K][1]);
		
	}

	static String src =
			"10";
}
