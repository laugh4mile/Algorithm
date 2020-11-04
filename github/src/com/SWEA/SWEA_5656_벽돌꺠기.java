package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌꺠기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T, N, W, H, map[][], copy[][], result[], min = Integer.MAX_VALUE, temp[][];
	static boolean isSelected[], isVisited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input= new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			H = Integer.parseInt(tokens.nextToken());
			result = new int [N];
			isSelected = new boolean [W];
			
			map = new int[H][W];
			copy = new int[H][W];
			temp = new int[H][W];
			isVisited = new boolean[H][W];
			for(int r=0; r<H; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<W; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}	
			}
			
			copy = copyMap(map);
//			for(int []x : copy) {
//				System.out.println(Arrays.toString(x));
//			}
//			sort();
			
			permutation(0);
			
			for(int []x : temp) {
				System.out.println(Arrays.toString(x));
			}
			System.out.println(min);
			min = Integer.MAX_VALUE;
		}
	}
	private static int[][] copyMap(int[][] map) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}
	private static void permutation(int cnt) {
		if(cnt == N) {
//			System.out.println(Arrays.toString(result));
			brickGame(result);
			return;
		}
		for(int i=0; i<W; i++) {
			if(!isSelected[i])
				result[cnt] = i;
			
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

	private static void brickGame(int[] result) {
		copy = copyMap(map);
		for(int c=0; c<result.length; c++) {
			for(int r=0; r<H; r++) {
				if(copy[r][result[c]] == 1) {
					copy[r][result[c]] = 0;
					break;
				}else if(copy[r][result[c]] > 1) {
					bfs(r,result[c], copy);
					break;
				}
			}
			copy = sort(copy);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					isVisited[i][j] = false;
				}	
			}
		}
		getMin(copy);
		
	}

	private static void getMin(int[][] copy) {
		int count = 0;
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				if(copy[r][c] != 0) {
					count++;
				}
			}	
		}
		if(min > count) {
			min = count;
			temp = copyMap(copy);
		}
		count = 0;
	}
	private static void bfs(int r, int c, int[][] copy) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, copy[r][c]));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			for(int d=0; d<4; d++) {
				for(int t=0; t<front.range; t++) {
					int nr = front.r + dr[d] * t;
					int nc = front.c + dc[d] * t;
					
					if(isIn(nr, nc) && !isVisited[nr][nc]) {
						queue.offer(new Node(nr, nc, copy[nr][nc]));
						isVisited[nr][nc] = true;
						copy[nr][nc] = 0;
					}
				}
			}
		}
	}
	
	static class Node{
		int r;
		int c;
		int range;
		public Node(int r, int c, int range) {
			super();
			this.r = r;
			this.c = c;
			this.range = range;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", range=" + range + "]";
		}
		
	}

	private static int dr[] = {0,0,-1,1};
	private static int dc[] = {-1,1,0,0};

	private static boolean isIn (int r, int c) {
		return (r>=0 && c>0 && r<H && c<W);
	}
	
	private static int[][] sort(int[][] arr) { // 아래로 정렬
		Queue<Integer> queue;
		
		for(int w=0; w<W; w++) {
			queue = new LinkedList<>();
			for(int h=H-1; h>=0; h--) {
				if(arr[h][w] != 0) {
					queue.offer(arr[h][w]);
				}
			}
			for(int h=H-1; h>=0; h--) {
				if(!queue.isEmpty()) {
					arr[h][w] = queue.poll();
				}else {
					arr[h][w] = 0;
				}
			}
		}
		return arr;
	}

	static String src =
			"5\r\n" + 
			"3 10 10\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 1 0 1 0 0 0 0 0\r\n" + 
			"1 0 3 0 1 1 0 0 0 1\r\n" + 
			"1 1 1 0 1 2 0 0 0 9\r\n" + 
			"1 1 4 0 1 1 0 0 1 1\r\n" + 
			"1 1 4 1 1 1 2 1 1 1\r\n" + 
			"1 1 5 1 1 1 1 2 1 1\r\n" + 
			"1 1 6 1 1 1 1 1 2 1\r\n" + 
			"1 1 1 1 1 1 1 1 1 5\r\n" + 
			"1 1 7 1 1 1 1 1 1 1\r\n" + 
			"2 9 10\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 1 0 0 0 0\r\n" + 
			"1 1 0 1 1 1 0 1 0\r\n" + 
			"1 1 0 1 1 1 0 1 0\r\n" + 
			"1 1 1 1 1 1 1 1 0\r\n" + 
			"1 1 3 1 6 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 1 1 1\r\n" + 
			"3 6 7\r\n" + 
			"1 1 0 0 0 0\r\n" + 
			"1 1 0 0 1 0\r\n" + 
			"1 1 0 0 4 0\r\n" + 
			"4 1 0 0 1 0\r\n" + 
			"1 5 1 0 1 6\r\n" + 
			"1 2 8 1 1 6\r\n" + 
			"1 1 1 9 2 1\r\n" + 
			"4 4 15\r\n" + 
			"0 0 0 0 \r\n" + 
			"0 0 0 0 \r\n" + 
			"0 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 5 0 \r\n" + 
			"1 1 1 0 \r\n" + 
			"1 1 1 9 \r\n" + 
			"1 1 1 1 \r\n" + 
			"1 6 1 2 \r\n" + 
			"1 1 1 5 \r\n" + 
			"1 1 1 1 \r\n" + 
			"2 1 1 2 \r\n" + 
			"4 12 15\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9";
}
