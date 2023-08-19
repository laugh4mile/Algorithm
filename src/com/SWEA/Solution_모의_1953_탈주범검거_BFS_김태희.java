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
public class Solution_모의_1953_탈주범검거_BFS_김태희 {

	static int  N,M,R,C,L,map[][];
	static boolean visited[][];
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
			visited = new boolean[N][M];
			
			for(int i=0; i<N; ++i) {
				st = new StringTokenizer(in.readLine().trim());
				for(int j=0; j<M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+t+" "+bfs());
		}
	}
	private static int bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {R,C});
		visited[R][C] = true;
		int result=1, cnt=1,size=0,current[],r,c,nr,nc, dir;// 맨홀에 처음 있는 시간도 1로 처리해야하므로 cnt=1, 경우의수 result=1
		String info = null;
		
		while(cnt++<L) {
			size = queue.size();
			while(size-->0) {
				current = queue.poll();
				r = current[0];
				c = current[1];
				info = type[map[r][c]];
				
				for(int d=0; d<info.length(); ++d) {
					dir = info.charAt(d) - '0';
					nr = r + dr[dir];
					nc = c + dr[dir];
					
					if(nr>=0 && nr<N && nc>=0 && nc<M 
							&& map[nr][nc] != 0 // 터널이 있고
							&& type[map[nr][nc]].contains(Integer.toString(3-dir))	// 다음 칸이 현 방향과 연결될수 있는 터널일 경우만 
							&& !visited[nr][nc]) {
					
						queue.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
						result++;
					}
				}
			}
		}
		return result;
	}
}