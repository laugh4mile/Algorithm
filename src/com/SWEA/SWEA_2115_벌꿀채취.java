package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,M,C,map[][],result[], burtong1[], burtong2[], max=Integer.MIN_VALUE, max2=Integer.MIN_VALUE, answer;
	static boolean isSelected[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			
			map = new int[N][N];
			result = new int[2];
			burtong1 = new int[M];
			burtong2 = new int[M];
			isSelected = new boolean[M];
			
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
//			for(int x[] : map) {
//				System.out.println(Arrays.toString(x));
//			}
			combi(0,0);
//			System.out.println();
//			System.out.println("#"+t+" " + (max+max2));
			System.out.println("#"+t+" " + answer);
			answer = 0;
			max = Integer.MIN_VALUE;
			max2 = Integer.MIN_VALUE;
			
		}
	}
	private static void combi(int cnt, int start) {
		if(cnt == 2) {
			checkPosition();
			
			return;
		}
		for(int i=start; i<N*N; i++) {
			result[cnt] = i;
			combi(cnt+1, i+1);
		}
	}

	private static void checkPosition() {
		// 첫번째 일꾼이 처음선택한 벌통의 위치
		int r1 = result[0]/N;
		int c1 = result[0]%N;
		// 2번째 일꾼이 처음선택한 벌통의 위치
		int r2 = result[1]/N;
		int c2 = result[1]%N;
		
//		System.out.println("r1 , c1 : " + r1 +", " +c1);
//		System.out.println("r2 , c2 : " + r2 +", " +c2);
		
		if(!isIn(r1, c1+M-1)) { // 짤리면 리턴
			return;
		}
		if(!isIn(r2, c2+M-1)) { // 짤리면 리턴
			return;
		}
		if(r1==r2 && c2 <= c1+M-1) { // 같은 라인일때 벌통이 겹치면 리턴
			return;
		}
		for(int i=0; i<M; i++) {
			burtong1[i] = map[r1][c1+i];
			burtong2[i] = map[r2][c2+i];
		}
//		System.out.println();
		max = max2 = 0;
		
		subset(0,burtong1,1);
		subset(0,burtong2,2);
		answer = Math.max(answer, max+max2);
//		System.out.println(Arrays.toString(burtong1) + " " + max);
//		System.out.println(Arrays.toString(burtong2) + " " + max2);
//		System.out.println(max+max2);
	}

	private static void subset(int cnt, int[] burtong, int num) {
		if(cnt == M) {
			int sum1 = 0, answer1 = 0;
			for(int i=0; i<M; i++) {
				if(isSelected[i]) {
//					System.out.print(burtong1[i]+" ");
					sum1 += burtong[i];
					answer1 += Math.pow(burtong[i], 2);
				}
			}
			if(sum1 > C) {
				return;
			}
			if (num == 1)
				   max = Math.max(max, answer1);
				else
				   max2 = Math.max(max2, answer1);
			return;
		}
		isSelected[cnt] = true;
		subset(cnt+1,burtong,num);
		isSelected[cnt] = false;
		subset(cnt+1,burtong,num);
	}
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	static String src =
			"10\r\n" + 
	
			"4 2 13\r\n" + 
			"6 1 9 7\r\n" + 
			"9 8 5 8\r\n" + 
			"3 4 5 3\r\n" + 
			"8 2 6 7\r\n" + 
			
			"3 3 10\r\n" + 
			"7 2 9\r\n" + 
			"6 6 6\r\n" + 
			"5 5 7\r\n" + 
			
			"4 1 10\r\n" + 
			"8 1 8 2\r\n" + 
			"4 6 1 6\r\n" + 
			"4 9 6 3\r\n" + 
			"7 4 1 3\r\n" + 
			
			"4 3 12\r\n" + 
			"8 8 6 5\r\n" + 
			"5 2 7 4\r\n" + 
			"8 5 1 7\r\n" + 
			"7 8 9 4\r\n" + 
			
			"5 2 11\r\n" + 
			"7 5 9 9 6\r\n" + 
			"7 3 7 9 3\r\n" + 
			"1 7 1 4 5\r\n" + 
			"1 7 9 2 6\r\n" + 
			"6 6 8 3 8\r\n" + 
			
			"6 3 20\r\n" + 
			"8 5 2 4 3 1\r\n" + 
			"4 3 6 1 1 8\r\n" + 
			"4 4 1 2 3 1\r\n" + 
			"1 7 4 9 6 1\r\n" + 
			"6 5 1 2 8 4\r\n" + 
			"3 1 4 5 1 3\r\n" + 
			
			"7 2 11\r\n" + 
			"2 8 2 5 2 8 6\r\n" + 
			"2 3 7 4 6 4 8\r\n" + 
			"3 7 8 3 9 4 4\r\n" + 
			"8 8 5 9 3 6 9\r\n" + 
			"9 7 6 2 4 1 3\r\n" + 
			"2 9 2 8 9 7 3\r\n" + 
			"2 1 7 2 7 8 3\r\n" + 
			
			
			"8 3 12\r\n" + 
			"9 1 6 7 5 4 6 7\r\n" + 
			"9 5 1 8 8 3 5 8\r\n" + 
			"5 2 6 8 6 9 2 1\r\n" + 
			"9 2 1 8 7 5 2 3\r\n" + 
			"6 5 5 1 4 5 7 2\r\n" + 
			"1 7 1 8 1 9 5 5\r\n" + 
			"6 2 2 9 2 5 1 4\r\n" + 
			"7 1 1 2 5 9 5 7\r\n" + 
			
			"9 4 20\r\n" + 
			"5 2 4 8 3 7 6 2 1\r\n" + 
			"7 9 8 5 8 2 6 3 6\r\n" + 
			"1 9 4 6 7 5 3 1 1\r\n" + 
			"4 4 7 6 2 2 8 1 7\r\n" + 
			"9 6 8 5 7 3 7 9 5\r\n" + 
			"7 3 1 4 1 1 8 5 3\r\n" + 
			"4 6 8 9 4 5 3 8 8\r\n" + 
			"1 3 4 2 4 1 1 3 6\r\n" + 
			"5 9 2 3 5 2 4 8 5\r\n" + 
			
			"10 5 30\r\n" + 
			"7 4 7 5 9 3 6 4 6 7\r\n" + 
			"8 9 8 4 5 7 8 9 2 9\r\n" + 
			"6 5 3 4 6 4 7 6 3 2\r\n" + 
			"4 7 4 3 4 7 3 3 4 3\r\n" + 
			"3 5 6 4 8 8 2 1 8 6\r\n" + 
			"3 7 9 7 1 7 6 2 8 9\r\n" + 
			"3 6 1 6 8 9 7 7 5 1\r\n" + 
			"4 3 5 6 2 1 2 6 3 6\r\n" + 
			"3 4 9 2 1 5 9 9 6 3\r\n" + 
			"9 9 7 3 7 5 5 5 8 4";
}
