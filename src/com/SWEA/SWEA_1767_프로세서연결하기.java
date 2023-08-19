package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {
	private static int n, core, answer, count; 
	private static int[][] map; 
	private static ArrayList<int[]> list; 
	private final static int[] dx = {0, 0, -1, 1};
	private final static int[] dy = {-1, 1, 0, 0}; 
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//		br = new BufferedReader(new StringReader(src));
		StringTokenizer st; int T = Integer.parseInt(br.readLine()); 
		for (int t = 1; t <= T; t++) { 
			n = Integer.parseInt(br.readLine()); 
			list = new ArrayList<>(); 
			map = new int[n][n]; 
			for (int i = 0; i < n; i++) { 
				st = new StringTokenizer(br.readLine()); 
				for (int j = 0; j < n; j++) { 
					map[i][j] = Byte.parseByte(st.nextToken()); 
					if (map[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) 
						list.add(new int[]{i, j}); 
					} 
				} core = 0; // 코어 수 
			answer = 144; // 전선 수 
			dfs(0, 0, 0); 
			System.out.println("#" + t + " " + answer); 
		} 
	} 
	private static void dfs(int depth, int c, int line) { 
		if (depth == list.size()) { 
			if (core < c) { 
				core = c; answer = line; 
			} else if (core == c) { 
				if (answer > line) answer = line; 
			} return; 
		} for (int i = 0; i < 4; i++) { 
			if (isConnect(list.get(depth), i)) { // 연결할 수 있는지 체크
				fill(list.get(depth), i, 2); 
				dfs(depth + 1, c + 1, line + count); // 코어 선택 후 연결 
				fill(list.get(depth), i, 0); 
			}
		} dfs(depth + 1, c, line); // 코어 선택 안함
	} 
	
	private static void fill(int[] index, int dir, int value) { 
		count = 0; int x = index[0] + dx[dir]; 
		int y = index[1] + dy[dir]; 
		while (x >= 0 && y >= 0 && x < n && y < n) { 
			map[x][y] = value; 
			count++; 
			x = x + dx[dir]; 
			y = y + dy[dir]; 
		} 
	} 
	
	private static boolean isConnect(int[] index, int dir) { 
		int x = index[0] + dx[dir]; 
		int y = index[1] + dy[dir]; 
		while (x >= 0 && y >= 0 && x < n && y < n) { 
			if (map[x][y] != 0) return false; 
			x = x + dx[dir]; 
			y = y + dy[dir]; 
		} 
		return true; 
	} 

	static String src = 
			"3\r\n" + 
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
			"0 0 0 0 0 0 0 0 0 0 0";
}