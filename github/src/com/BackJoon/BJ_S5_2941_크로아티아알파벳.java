package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_S5_2941_크로아티아알파벳 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static String ostr;
	static char arr[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		ostr = input.readLine();
//		System.out.println(ostr);
		int n = ostr.length();
		arr = new char [n];
		
		for(int i=0; i<n; i++) {
			arr[i] = ostr.charAt(i);
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] == '-' ) {
				arr[i] = 0;
			}
		}

		for(int i=0; i<n-2; i++) {
			if(arr[i] == 'd' && arr[i+1] == 'z' && arr[i+2] == '=') {
				arr[i] = 0;
				arr[i+1] = 0;
			}
		}
		
		for(int i=0; i<n-1; i++) {
			if(arr[i] == 'l' && arr[i+1] == 'j') {
				arr[i] = 0;
			}
			if(arr[i] == 'n' && arr[i+1] == 'j') {
				arr[i] = 0;
			}
			if(arr[i] == 'c' && arr[i+1] == '=') {
				arr[i] = 0;
			}
			if(arr[i] == 's' && arr[i+1] == '=') {
				arr[i] = 0;
			}
			if(arr[i] == 'z' && arr[i+1] == '=') {
				arr[i] = 0;
			}
		}
		
		for(int i=0; i<n; i++) {
			if(arr[i] != 0) {
				cnt++;
			}
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(cnt);

	}
	static String src = 
			"c=c=";
}
