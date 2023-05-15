package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_18429_근손실 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K,result[],seq[],ans;
	static boolean isVisited[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		result = new int[N];
		seq = new int[N];
		isVisited = new boolean[N];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			seq[n] = Integer.parseInt(tokens.nextToken()); 
		}
//		System.out.println(Arrays.toString(seq));
		per(0);
		System.out.println(ans);
	}
	private static void per(int cnt) {
		if(cnt == N) {
			int compare = 0;
			for(int i=0; i<result.length; i++) {
				compare += result[i];
				if(compare < K*(i+1)) {
					return;
				}
			}
			ans++;
//			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i=0; i<N; i++) {
			if(isVisited[i]) continue;
			
			result[cnt] = seq[i];
			isVisited[i] = true;
			per(cnt+1);
			isVisited[i] = false;
		}
	}
	static String src = 
			"3 4\r\n" + 
			"3 7 5";

}
