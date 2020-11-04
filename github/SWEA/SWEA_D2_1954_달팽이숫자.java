package com.SWEA;

import java.util.Scanner;

public class SWEA_D2_1954_달팽이숫자 {
	static int T;
	static int N;
	static int[][] snail; 
	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			
			snail = new int[N][N];
			int num = 1;
			int j = 0;
			int k = -1;
			int sq = 1;
			while(true) {
				for(int l=0; l<N; l++) {
					k = k+sq;
					snail[j][k] = num++; 
				}
				N--;
				if(N==0) {
					break;
				}
				for(int l=0; l<N; l++) {
					j = j+sq;
					snail[j][k] =num++;
				}
				sq = sq*(-1);
			}
			System.out.printf("#%d\n",i+1);
			for(int r =0; r<snail.length; r++) {
				for(int c =0; c<snail.length; c++) {
					System.out.printf("%d ",snail[r][c]);
				}
				System.out.println();
			}
		}
	}

}
