package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_16202_MST게임 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K, map[][], minEdge[];
	static boolean isVisited[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		minEdge = new int[N];
		isVisited = new boolean[N];
		for(int i=0 ; i<N; i++) {
			minEdge[i] = Integer.MAX_VALUE;
		}
		map = new int[N][N];
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			map[x-1][y-1] = i+1;
			map[y-1][x-1] = i+1;
		}
		prim();
//		for(int [] x : map) {
//			System.out.println(Arrays.toString(x));
//		}
		
	}
	private static void prim() {
		int minVertex=0, minCost=0, result=0;
		
		minEdge[0] = 0;
		
		for(int v = 0; v<N; v++) {
			minCost = Integer.MAX_VALUE;
			minVertex = 0;
			
			for(int i=0; i<N; i++) {
				if(!isVisited[i] && minEdge[i] < minCost) {
					minCost = minEdge[i];
					minVertex = i;
				}
			}
			if(minCost == Integer.MAX_VALUE) { // 간선이 모든 정점을 연결하지 못하는 케이스
				result = 0;
			}else {
				result += minCost;
			}
			isVisited[minVertex] = true;
			
			for(int i=0; i<N; i++) {
				if(!isVisited[i] && map[minVertex][i] !=0 && map[minVertex][i] < minEdge[i]) {
					minEdge[i] = map[minVertex][i];
				}
			}
		}
		System.out.println(result);
	}
	
	static String src = 
			"6 7 3\r\n" + 
			"2 4\r\n" + 
			"1 2\r\n" + 
			"4 6\r\n" + 
			"1 3\r\n" + 
			"2 3\r\n" + 
			"4 5\r\n" + 
			"5 6";
}
