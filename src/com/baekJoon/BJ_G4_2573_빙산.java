package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author yhs
 * @date 2020. 8. 26
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 1. bfs로 주변의 바다 탐색
 * 2. 주변의 바다 영역의 수만큼 마이너스한 값을 저장
 * 3. 
 * [입력사항]
 * [출력사항]
 */
public class BJ_G4_2573_빙산 {
	static BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
	static StringTokenizer tokens;
	static int N,M,map[][],melt[][],year, totalIce, checkedIce;
	static boolean isVisited[][];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		melt = new int[N][M];
		isVisited = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(tokens.nextToken()); 
			}
		}
		for(int[] x : map) {
			System.out.println(Arrays.toString(x));
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					bfs(i,j);
				}
			}
		}
	}
	
	private static void bfs(int i, int j) {
		Queue<Integer> queue = new LinkedList<Integer>();
	}

	static String src ="5 7\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"0 2 4 5 3 0 0\r\n" + 
			"0 3 0 2 5 2 0\r\n" + 
			"0 7 6 2 4 0 0\r\n" + 
			"0 0 0 0 0 0 0";
}
