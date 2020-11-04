package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B2_13300_방배정 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K, students[][] = new int[6][2];
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int gender = Integer.parseInt(tokens.nextToken());
			int grade = Integer.parseInt(tokens.nextToken())-1;
			
			students[grade][gender]++;
		}
		int cnt = 0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<2; j++) {
				if (students[i][j] != 0) {
					if(students[i][j]%K == 0){
						cnt = cnt + students[i][j]/K;
					}else {
						cnt = cnt + students[i][j]/K +1 ;
					}
				}
			}	
		}
		System.out.println(cnt);
	}
	
	static String src = 
			"16 2\r\n" + 
			"1 1\r\n" + 
			"0 1\r\n" + 
			"1 1\r\n" + 
			"0 2\r\n" + 
			"1 2\r\n" + 
			"0 2\r\n" + 
			"0 3\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"1 3\r\n" + 
			"1 3\r\n" + 
			"0 6\r\n" + 
			"1 5\r\n" + 
			"0 5\r\n" + 
			"1 5\r\n" + 
			"1 6";
}
