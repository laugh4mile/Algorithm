package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S5_2477_참외밭 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int K, arr[][], num[];
	static List<Integer> list1 = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		K= Integer.parseInt(input.readLine());
		arr = new int[6][2];
		num = new int[4];
		for(int i=0; i<6; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}	
			num[arr[i][0]-1]++;
		}
		for(int x[] : arr) {
			System.out.println(Arrays.toString(x));
		}
//		System.out.println(Arrays.toString(num));
		
	}
	static String src ="7\r\n" + 
			"4 50\r\n" + 
			"2 160\r\n" + 
			"3 30\r\n" + 
			"1 60\r\n" + 
			"3 20\r\n" + 
			"1 100";
}