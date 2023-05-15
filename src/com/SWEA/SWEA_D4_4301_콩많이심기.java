package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author yhs
 * @date 2020. 8. 6
 * @see https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
 * @mem 32,840 kb
 * @time 192 ms
 * @caution #그리디 하지만 완점탐색으로풀었다ㅜㅜ
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
public class SWEA_D4_4301_콩많이심기 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,M, arr[][];
	static boolean isVisited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			arr = new int[M][N];
			isVisited = new boolean[M][N];
			
			
			int cnt = M*N;
			for(int r=0; r<M; r++) {
				for(int c=0; c<N; c++) {
					if(isIn(r-2, c) && arr[r-2][c] == 0 && !isVisited[r][c]) {
						arr[r-2][c] = -1;
						cnt--;
						isVisited[r-2][c] = true;
					}
					
					if(isIn(r+2, c) && arr[r+2][c] == 0 && !isVisited[r][c] ) {
						arr[r+2][c] = -1;
						cnt--;
						isVisited[r+2][c] = true;
					}
					
					if(isIn(r, c-2) && arr[r][c-2] == 0 && !isVisited[r][c]) {
						arr[r][c-2] = -1;
						cnt--;
						isVisited[r][c-2] = true;
					}
					
					if(isIn(r, c+2) && arr[r][c+2] == 0 && !isVisited[r][c]) {
						arr[r][c+2] = -1;
						cnt--;
						isVisited[r][c+2] = true;
					}
				}
			}
			System.out.printf("#%d %d\n",t,cnt);
			
		}
		
//		for(int []x : arr) {
//			System.out.println(Arrays.toString(x));
//		}
		
		
		
	}
	static boolean isIn(int r, int c) {
		return (r>=0 && r<M && c>=0 && c<N);
	}
	static String src ="2\r\n" + 
			"3 2\r\n" +
			"4 4\r\n";
}