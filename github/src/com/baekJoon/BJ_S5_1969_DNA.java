package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_1969_DNA {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M, cnt[];
	static char map[][],result[],ch[] = {'A','C','G','T'};
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		result = new char[M];
		map = new char[N][M];
		cnt = new int[4];
		for(int n=0; n<N; n++) {
			String line = input.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = line.charAt(m);
			}	
		}
		
		for(int m=0; m<M; m++) {
			int max = 0, index=0;
			Arrays.fill(cnt, 0);
			for(int n=0; n<N; n++) {
				switch (map[n][m]) {
				case 'A':
					cnt[0]++;
					break;
				case 'C':
					cnt[1]++;
					break;
				case 'G':
					cnt[2]++;
					break;
				case 'T':
					cnt[3]++;
					break;
				default:
					break;
				}
				
			}
			for(int i=0; i<4; i++) {
				if(cnt[i] > max) {
					max = cnt[i];
					index = i;
				}
			}
			result[m] = ch[index];
		}
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
		int ans =0;
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(map[n][m] != result[m]) {
					ans++;
				}
			}	
		}
		System.out.println(ans);
	}
	static String src = 
			"4 10\r\n" + 
			"ACGTACGTAC\r\n" + 
			"CCGTACGTAG\r\n" + 
			"GCGTACGTAT\r\n" + 
			"TCGTACGTAA";
}
