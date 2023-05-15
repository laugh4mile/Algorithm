package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_B1_13301_타일장식물 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		long arr[] = new long[80];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2; i<80; i++) {
			arr[i] = arr[i-1]+arr[i-2];
		}
//		System.out.println(Arrays.toString(arr));
		if(N == 1) {
			System.out.println(4);
		}else {
			System.out.println(arr[N-1]*4 + arr[N-2]*2);
		}
	}

	static String src =
			"1";
}
