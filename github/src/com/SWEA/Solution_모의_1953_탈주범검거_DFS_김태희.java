package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* @author taeheekim
*/
public class Solution_모의_1953_탈주범검거_DFS_김태희 {

	static int  N,M,R,C,L,map[][];
	static int visited[][];
	static String[] type = {
			null,
			"0312", //1: 상하좌우
			"03", //2:상하
			"12", //3:좌우
			"02", //4:상우
			"32", //5:하우
			"31", //6:하좌
			"01" //7:상좌
	};
	static int[] dr = {-1,0,0,1};// 상 0, 좌 1 , 우 2 ,하 3
	static int[] dc = {0,-1,1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		for(int t=1; t<=TC; ++t) {
			st = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(st.nextToken()); // 행크기
			M = Integer.parseInt(st.nextToken()); // 열크기
			R = Integer.parseInt(st.nextToken()); // 맨홀 행	
			C = Integer.parseInt(st.nextToken()); // 맨홀 열
			L = Integer.parseInt(st.nextToken()); // 시간
			map = new int[N][M];
			visited = new int[N][M]; // 방문했을때의 시간으로 관리
			
			for(int i=0; i<N; ++i) {
				st = new StringTokenizer(in.readLine().trim());
				for(int j=0; j<M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = Integer.MAX_VALUE;
				}
			}
			dfs(R,C,1);
			
			System.out.println("#"+t+" "+getCount());
		}
	}
	// 이미 지나간 곳을 더 짧은 시간에 중복해서 지나가는 방법도 있으므로 도착할때마다 방문시간은 바꾸되
	// 경우의 수는 방문할때마다 여기서  관리하면 안됨.
	private static void dfs(int r,int c,int time) {
		visited[r][c] = time;		
		if(time==L) return;
		
		String info = type[map[r][c]];
		int dir,nr,nc;
		for (int d = 0; d < info.length(); d++) {
			dir = info.charAt(d)-'0';
			nr = r + dr[dir];
			nc = c + dc[dir];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M 
					&& map[nr][nc] != 0
					&& type[map[nr][nc]].contains(Integer.toString(3-dir))
					&& visited[nr][nc]>time) {
				dfs(nr, nc, time+1);
			}
		}
	}
	
	static int getCount() {
		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(visited[r][c] != Integer.MAX_VALUE) ++count;
			}
		}
		return count;
	}
}