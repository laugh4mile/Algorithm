package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_B2_10870_피보나치수5 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int arr[] = new int[21];
		int n = Integer.parseInt(input.readLine());
		arr[0] = 0;
		arr[1] = 1;
		for(int i=2; i<21; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[n]);
	}

	static String src =
			"10";
}
