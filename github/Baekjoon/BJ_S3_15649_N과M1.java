package com.BackJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S3_15649_N과M1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int N,M,result[];
	static boolean isSelected[];
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		result = new int[M];
		isSelected = new boolean[N];
//		per(0);
//		bw.close();
		
		for(int i=0; i<N; i++) {
			for(int j=i; j<M; j++) {
				System.out.println(i+1 +" "+j);
			}
		}
		
	}
	private static void per(int cnt) throws IOException {
		if(cnt == M) {
			for(int i=0; i<result.length; i++) {
//				System.out.print(result[i] + " ");
				bw.write(result[i] +" ");
			}
			bw.write("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			result[cnt] = i+1;
			
			isSelected[i] = true;
			per(cnt+1);
			isSelected[i] = false;
		}
	}
	static String src = "4 2";
}
