package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_10815_숫자카드 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int N,M, sangguen[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		sangguen = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			sangguen[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(sangguen);
		M = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		
		for(int m=0; m<M; m++) {
			if(search(Integer.parseInt(tokens.nextToken()))) {
				output.append(1+" ");
			}else {
				output.append(0+" ");
			}
		}
		output.close();
	}
	private static boolean search(int num) {
		int left = 0;
		int right = sangguen.length-1;
		int mid = (right+left)/2;
		
		while(left<=right) {
			if(sangguen[mid] == num) {
				return true;
			}
			else if(sangguen[mid]<num) {
				left = mid + 1;
 			}else {
 				right = mid - 1;
			}
			mid = (right+left)/2;
		}
		return false;
	}
	static String src =
			"5\r\n" + 
			"6 3 2 10 -10\r\n" + 
			"8\r\n" + 
			"10 9 -5 2 3 4 5 -10";
}
