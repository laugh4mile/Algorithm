package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_G1_1981_배열에서이동_학일 {

	static int n;
	static int[][] board;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception{
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		StringTokenizer st;

		int min = 200, max = 0;

		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				min = num < min ? num : min;
				max = num > max ? num : max;
			}
		}

		int l = 0, r = max-min;
		int ans = 0;
		loop1 : while (l <= r) {
			int gap = (l + r) / 2;
			for (int i = min; i+gap <= max; i++) {
				if (hasRoute(i, i+gap)) {
					r = gap - 1;
					ans = gap;
					continue loop1;
				}
			}
			l = gap + 1;
		}
		System.out.print(ans);
	}
	static boolean hasRoute(int min, int max) {

		if (min > board[0][0] || board[0][0] > max) return false;

		boolean[][] visit = new boolean[n][n];
		Queue<int[]> que = new LinkedList<>();

		que.add(new int[] {0, 0});
		visit[0][0] = true;

		while (!que.isEmpty()) {
			int[] now = que.poll();
			
			if (now[0] == n-1 && now[1] == n-1) return true;

			for (int i=0; i<4; i++) {

				int nr = now[0] + dr[i], nc = now[1] + dc[i];

				if (0 <= nr && nr < n && 0 <= nc && nc < n && !visit[nr][nc]) {
					if (min <= board[nr][nc] && board[nr][nc] <= max) {
						visit[nr][nc] = true;
						que.add(new int[] {nr, nc});
					}
				}
			}
		}
		
		return false;
	}
}