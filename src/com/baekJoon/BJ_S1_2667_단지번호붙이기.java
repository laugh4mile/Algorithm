package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class BJ_S1_2667_단지번호붙이기 {
	static int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
	static BufferedReader input =  new BufferedReader(new InputStreamReader(System.in));
	static int N,map[][];
	static boolean[][] isVisited;
	static int cnt=2, num;
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		result = new int[N*N];
		isVisited = new boolean[N][N];
		String[] sp;
		
		for(int i=0; i<N; i++) {
			String line = input.readLine();
			sp = line.split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(sp[j]);
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					map[i][j] = cnt;
					num=0;
					bfs(i,j);
					result[cnt] = num;
					cnt++;
				}
				
			}
		}
//		for(int i=0; i<N; i++) { //출력
//			for(int j=0; j<N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(cnt-2);
		Arrays.sort(result,2,cnt+1);
		for(int i=3; i<=cnt; i++) {
			System.out.printf("%d\n",result[i]+1);
		}
	}
	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			for (int i = 0; i < 4; i++) {
                int nextR = front.r + dir[i][0];
                int nextC = front.c + dir[i][1];

                if(!isIn(nextR, nextC)) continue;
                if (map[nextR][nextC] != 1) continue;
                if(!isVisited[nextR][nextC]) {
                	map[nextR][nextC] = map[r][c];
                	num++;
                    queue.add(new Node(nextR, nextC));
                    isVisited[nextR][nextC] = true;
                }
			}
		}
	}
	static boolean isIn(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<N); 
	}
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		
	}
	static String src = "7\r\n" + 
			"0110100\r\n" + 
			"0110101\r\n" + 
			"1110101\r\n" + 
			"0000111\r\n" + 
			"0100000\r\n" + 
			"0111110\r\n" + 
			"0111000";
//			"1010101\r\n" + 
//			"0100010\r\n" + 
//			"1110101\r\n" + 
//			"0000111\r\n" + 
//			"0100000\r\n" + 
//			"0111110\r\n" + 
//			"0111000";

}
