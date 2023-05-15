package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_3987_보이저1호2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M, PR,PC, max = Integer.MIN_VALUE;
	static char map[][], answer;
	static boolean isVisited[][][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new char[502][502];
		isVisited = new boolean[502][502][4];
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
		tokens = new StringTokenizer(input.readLine());
		PR = Integer.parseInt(tokens.nextToken())-1;
		PC = Integer.parseInt(tokens.nextToken())-1;
		
		outer : for(int dir=0; dir<4; dir++) {
			int cnt = 0;
			isVisited = new boolean[N][M][4];
			int nr = PR;
			int nc = PC;
			int curDir = dir;
			while(true) {
				cnt++;
				if(!isVisited[nr][nc][curDir]) {
					isVisited[nr][nc][curDir] = true;
				}else {
					answer = d[dir];
					max = Integer.MAX_VALUE;
					break outer;
				}
				nr += dr[curDir];
				nc += dc[curDir];
				if(!isIn(nr, nc) || map[nr][nc] == 'C') {
					if(max < cnt) {
						answer = d[dir]; 
						max = cnt;
					}
					break;
				}
				if(map[nr][nc] == '/') {
					curDir = curDir ^ 1;
				}else if(map[nr][nc] == '\\') {
					curDir = 3-curDir;
				}
			}
		}
		System.out.println(answer);
		if(max == Integer.MAX_VALUE) {
			System.out.println("Voyger");
		}else {
			System.out.println(max);
		}
	}
	static char d[] = {'U', 'R', 'D', 'L'};
	static int dr[] = {-1,0,1,0}; // 상, 우, 하, 좌
	static int dc[] = {0,1,0,-1};
	static boolean isIn(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<M);
	}
	
	static String src =
			"5 7\r\n"
			+ "/.....\\\r\n"
			+ "../..\\.\r\n"
			+ "\\...../\r\n"
			+ "/.....\\\r\n"
			+ "\\.\\.../\r\n"
			+ "3 3";
}
