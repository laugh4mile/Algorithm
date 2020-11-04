package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_2961_도영이가만든맛있는음식 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N, AS=1, AB, cn, chai, temp, jaeryo[][];
	static boolean isSelected[];
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		jaeryo = new int[N][2];
		isSelected = new boolean[N];
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int S = Integer.parseInt(tokens.nextToken());
			int B = Integer.parseInt(tokens.nextToken());
			
			jaeryo[n][0] = S;
			jaeryo[n][1] = B;
		}
//		for(int []x : jaeryo) {
//			System.out.println(Arrays.toString(x));
//		}
		temp = Integer.MAX_VALUE;
		subSet(0);
		System.out.println(temp);
 	}
	private static void subSet(int cnt) {
		if(cnt == N) {
			
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					System.out.print(Arrays.toString(jaeryo[i]));
					AS *= jaeryo[i][0];
					AB += jaeryo[i][1];
				}
			}
			chai = Math.abs(AS-AB);
			cn++;
			System.out.println();
			if(cn<Math.pow(2, N)) {
				System.out.println(chai+" "+ temp);
				if(chai<temp) {
					temp = chai;
				}
				
			}

			System.out.println(temp);
			AS = 1;
			AB = 0;
			return;
		}
		
		isSelected[cnt] = true;
		subSet(cnt+1);
	
		isSelected[cnt] = false;
		subSet(cnt+1);
		
	}
	static String src = "5\r\n" + 
			"1 7\r\n" + 
			"2 6\r\n" + 
			"3 3\r\n" + 
			"3 8\r\n" + 
			"4 9";

}
