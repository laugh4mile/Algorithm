package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_S3_17413_단어뒤집기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		String str = input.readLine();
		int n = str.length();
		
		char arr[] = new char[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = str.charAt(i);
		}
		System.out.println(Arrays.toString(arr));
		int start = 0, end = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] == '<' && i>0) {
				start = i;
				for(int j=i; j<n; j++) {
					if(arr[j] == '>') {
						end = j;
						i = j;
						break;
					}
				}
			}
		}
	}
	static String src = 
			"<ab cd>ef gh<ij kl>";
}
