package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_G4_2239_스도쿠 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int[][] map;
	// 비어있는 곳들을 따로 관리해주자.
	static List<Point> blanks = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));

		map = new int[9][9];
		String line = null;
		for (int r = 0; r < 9; r++) {
			line = input.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = line.charAt(c) - '0';
				if (map[r][c] == 0) {
					blanks.add(new Point(r, c));
				}
			}
		}
		// 이제 blanks의 모든 요소들을 탐색하면서 숫자를 채워주면 땡!!!
		dfs(0);
	}

//  이제 blanks의 모든 요소들을 탐색하면서 숫자를 채워주면 땡!!!
	static void dfs(int idx) {
		// 기저 케이스: 모든 요소에 대한 탐색이 끝나면 그만
		if (idx == blanks.size()) {
			// 종료: 정답 출력
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					output.append(map[r][c]);
				}
				output.append("\n");
			}
			System.out.println(output);
			// 답이 여러 개 있다면 그 중 사전식으로 앞서는 것을 출력한다. 즉, 81자리의 수가 제일 작은 경우를 출력한다.
			System.exit(0);
		}

		// 재귀 케이스: 1~9까지 대입해가면서 다음 요소들 탐색
		// 1. idx에 해당하는 녀석을 가져온다.
		Point p = blanks.get(idx);
		// 2. 가능한 숫자들을 대입해본다...
		for (int v = 1; v < 10; v++) {
			// 3. 해당 숫자가 유망한가??? --> 유망하다면 가자..,
			if(canUse(p.r, p.c, v)) {
				// 유망하다면 써보기
				map[p.r][p.c]=v;
				dfs(idx+1);
				// 3-1 다시 안쓴척 해주기.
				map[p.r][p.c]=0;
			}
		}
	}

	/**
	 * (row, col) 지점에 v를 넣을 수 있는가?
	 * 
	 * @param row
	 * @param col
	 * @param v
	 * @return
	 */
	static boolean canUse(int row, int col, int v) {
		for (int r = 0; r < 9; r++) {
			if (map[r][col] == v) {
				return false;
			}
		}

		for (int c = 0; c < 9; c++) {
			if (map[row][c] == v) {
				return false;
			}
		}

		int sr = row / 3 * 3;
		int sc = col / 3 * 3;
		for(int r=sr ; r<sr+3; r++) {
			for(int c=sc; c<sc+3; c++) {
				if(map[r][c]==v) {
					return false;
				}
			}
		}
		return true;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}

	static String src = "103000509\r\n" +
			"002109400\r\n" +
			"000704000\r\n" +
			"300502006\r\n" +
			"060000050\r\n" +
			"700803004\r\n" +
			"000401000\r\n" +
			"009205800\r\n" +
			"804000107";
}
