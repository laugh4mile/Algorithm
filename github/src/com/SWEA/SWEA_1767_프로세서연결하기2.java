package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,map[][],sumcore,sumline, 
		maxcore=Integer.MIN_VALUE, minline=Integer.MAX_VALUE;
	static boolean isVisited[][];
	static List<Node> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			list = new ArrayList<>();
			N = Integer.parseInt(input.readLine());
			map = new int[N][N];
			isVisited = new boolean [N][N];
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					if(map[r][c] == 1) {
						isVisited[r][c] = true;
						if(r!=0 && c!=0 && r!=N-1 && c!=N-1) {
							list.add(new Node(r, c));
						}
					}
				}	
			}
//			System.out.println(list);
//			
//			for(int x[] : map) {
//				System.out.println(Arrays.toString(x));
//			}
			
			dfs(0);
//			System.out.println(maxcore);
//			System.out.println(minline);
			System.out.println("#"+t+" "+minline);
			maxcore = Integer.MIN_VALUE;
			minline = Integer.MAX_VALUE;
			sumcore = 0;
			sumline = 0;
			
		}
	}
	
	private static void dfs(int index) {
		if(index == list.size()) {
			if (maxcore < sumcore) {
				maxcore = sumcore;
			}
			
			if(minline > sumline) {
				minline = sumline;
//				for(int i=0; i<N; i++) {
//					for(int j=0; j<N; j++) {
//						if(isVisited[i][j] == true) {
//							System.out.print(1+" ");
//						}else {
//							System.out.print(0+" ");
//						}
//					}	
//					System.out.println();
//				}
//				System.out.println();
			}
			return;
		}
		Node front = list.get(index);

		for(int d=0; d<4; d++) {
			dfs2(front.r, front.c, d, index);
//			
		}
	}
	
	static void dfs2(int r, int c, int dir, int index){
		if(r==0 || c==0 || r==N-1 || c==N-1) {
			sumcore++;
			dfs(index+1);
			sumcore--;
		}

		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		if(isIn(nr, nc) && !isVisited[nr][nc]) {
			isVisited[nr][nc] = true;
			sumline++;
			dfs2(nr, nc, dir, index);
			sumline--;
			isVisited[nr][nc] = false;
		}
	}

	static class Node{
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
	}
	
	static int dr[] = {-1,1,0,0}; // 상하 좌우
	static int dc[] = {0,0,-1,1};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	
	static String src =
			"5\r\n" + 
			"7\r\n" + 
			"0 0 1 0 0 0 0\r\n" + 
			"0 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"1 1 0 1 0 0 0\r\n" + 
			"0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"9\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 0 0 0 0 0 1\r\n" + 
			"1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 1 0 0\r\n" + 
			"0 0 0 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 1\r\n" + 
			"11\r\n" + 
			"0 0 1 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 1\r\n" + 
			"0 0 0 1 0 0 0 0 1 0 0\r\n" + 
			"0 1 0 1 1 0 0 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"12\r\n" + 
			"0 0 0 0 0 1 1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 1 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 0 0 1 0\r\n" + 
			"0 0 0 0 1 0 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 1 1 0 0 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 1\r\n" + 
			"12\r\n" + 
			"0 0 0 0 0 0 0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 1 0 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 0 0 0 0 1 0 0 1 0 0\r\n" + 
			"0 1 0 0 1 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 0 0 0 0 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0";
}