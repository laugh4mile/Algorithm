package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import com.baekJoon.BJ_G2_3109_빵집.Node;

public class BJ_G4_1987_알파벳 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, result[][], cnt, rcnt;
	static char map[][];
	static boolean isVisited[][], al[] = new boolean[26];
	static List<Character> cl = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		isVisited = new boolean[R][C];
		result = new int[R][C];

		for (int r = 0; r < R; r++) {
			String line = input.readLine();
			map[r] = line.toCharArray();
		}

//		for (char[] c : map) {
//			System.out.println(Arrays.toString(c));
//		}

		dfs(0, 0, 1);


		System.out.println(rcnt);
	}

	private static void dfs(int r, int c, int cnt) {

		al[map[r][c] - 'A'] = true;
		if (cnt > rcnt) {
			rcnt = cnt;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];

			if (isIn(nr,nc) && !al[map[nr][nc] - 'A']) {
				dfs(nr, nc, cnt+1);
				al[map[nr][nc] - 'A'] = false;
			}
		}

	}

	static boolean isIn(int r, int c) {
		return (r >= 0 && c >= 0 && r < R && c < C);
	}

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static String src = "2 4\r\n" + 
			"CAAB\r\n" + 
			"ADCB";
}
