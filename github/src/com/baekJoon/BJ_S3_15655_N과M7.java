package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_S3_15655_N과M7 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int N,M,num[],result[];
	static boolean isSelected[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		num = new int[N];
		isSelected = new boolean[N];
		result = new int[M];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(num);
		
//		combi(0,0);
		per(0);
		bw.close();
	}
	
	private static void per(int cnt) throws IOException {
		if(cnt == M) {
			
			for(int i=0; i<result.length-1; i++) {
				if(result[i]>result[i+1]) return;
			}
			for(int i=0; i<M; i++) {
//				System.out.print(result[i]+" ");
				bw.write(result[i] + " ");
			}
			bw.write("\n");
//			System.out.println();
			return;
		}
		int temp = 0;
		for(int i=0; i<N; i++) {
//			if(isSelected[i] ) continue; //|| temp == num[i]
			if(temp == num[i]) continue;
			temp = num[i];
			
			result[cnt] = num[i];
			
			isSelected[i] = true;
			per(cnt+1);
			isSelected[i] = false;
		}
	}

//	private static void combi(int cnt, int start) throws IOException {
//		if(cnt == M) {
//			for(int i=0; i<result.length-1; i++) {
//				if(result[i]>result[i+1]) {
////					flag = true;
//					return;
//				}
//			}
////			if(!flag) {
//				for(int i=0; i<M; i++) {
////				System.out.print(result[i]+" ");
//					bw.write(result[i] + " ");
//				}
//				bw.write("\n");
////			}
////			System.out.println();
//			return;
//		}
//		for(int i=start; i<N; i++) {
//			result[cnt] = num[i];
//			combi(cnt+1, i+1);
//		}
//	}
	
	static String src = 
			"4 2\r\n" + 
			"9 7 9 1";
}
