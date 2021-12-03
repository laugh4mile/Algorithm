package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2573_빙산_2 {
	static BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
	static StringTokenizer tokens;
	static int N,M,map[][], temp[][], cnt;
	static boolean isVisited[][];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		isVisited = new boolean[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		int answer = 0;
		while(true){
			answer++;
			temp = getTemp(map, temp);
			map = meltMap(map, temp);

			if(checkMapIsEmpty()){
				System.out.println(0);
				return;
			}

			resetArr();
			cnt = 0;
			for(int r=0; r<N; r++){
				for(int c=0; c<M; c++){
					if(map[r][c] != 0 && !isVisited[r][c]){
						cnt++;
						if(cnt > 1){
							System.out.println(answer);
							return;
						}
						bfs(r,c);
					}
				}
			}
		}
	}

	private static boolean checkMapIsEmpty() {
		for(int r=0; r<N; r++){
			for(int c=0; c<M; c++){
				if(map[r][c] != 0){
					return false;
				}
			}
		}
		return true;
	}

	private static void resetArr() {
		for(int r=0; r<N; r++){
			Arrays.fill(isVisited[r], false);
			Arrays.fill(temp[r], 0);
		}
	}

	private static int[][] meltMap(int[][] map, int[][] temp) {
		for(int r=0; r<N; r++){
			for(int c=0; c<M; c++){
				if(map[r][c] != 0){
					map[r][c] = Math.max(map[r][c] - temp[r][c], 0);
				}
			}
		}
		return map;
	}

	private static int[][] getTemp(int [][]map, int [][]temp) {
		for(int r=0; r<N; r++){
			for(int c=0; c<M; c++){
				if(map[r][c] > 0){
					for(int d=0; d<4; d++){
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(isIn(nr,nc) && map[nr][nc] == 0){
							temp[r][c]++;
						}
					}
				}
			}
		}
		return temp;
	}

	private static void bfs(int r, int c) {

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r,c));
		isVisited[r][c] = true;
		while (!queue.isEmpty()){
			Node front = queue.poll();

			for(int d=0; d<4; d++){
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];

				if(isIn(nr,nc) && !isVisited[nr][nc] && map[nr][nc] > 0){
					isVisited[nr][nc] = true;
					queue.offer(new Node(nr,nc));
				}
			}

		}
	}

	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node{" +
					"r=" + r +
					", c=" + c +
					'}';
		}
	}

	static boolean isIn(int r, int c){
		return (r>=0 && c>=0 && r<N && c<M);
	}

	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};

	static String src ="5 7\r\n" +
			"0 0 0 0 0 0 0\r\n" + 
			"0 2 4 5 3 0 0\r\n" + 
			"0 3 0 2 5 2 0\r\n" + 
			"0 7 6 2 4 0 0\r\n" + 
			"0 0 0 0 0 0 0";
}