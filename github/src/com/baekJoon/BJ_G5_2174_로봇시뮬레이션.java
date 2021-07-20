package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_2174_로봇시뮬레이션 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int A,B,N,M,map[][];
	static List<Robot> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		A = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		map = new int[B][A];
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		list.add(new Robot(0, 0, 0)); // 허허..
		for(int n=1; n<=N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int c = Integer.parseInt(tokens.nextToken()) - 1;
			int r = B - Integer.parseInt(tokens.nextToken()) ;
			int d = 0;
			switch (tokens.nextToken().charAt(0)) {
			case 'N': // 상
				d = 0;
				break;
			case 'W': // 좌
				d = 1;
				break;
			case 'S': // 하
				d = 2;
				break;
			case 'E': // 우
				d = 3;
				break;
			}
			list.add(new Robot(r, c, d));
			map[r][c] = n;
		}
		boolean isOver = false;
		outer : for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int no = Integer.parseInt(tokens.nextToken());
			char cmd = tokens.nextToken().charAt(0);
			int repeat = Integer.parseInt(tokens.nextToken());
			
			if(cmd == 'L') {
				repeat = repeat % 4;
				int nd = list.get(no).d;
				for(int i=0; i<repeat; i++) {
					nd = (nd+1) % 4;
				}
				list.get(no).d = nd;
			}else if(cmd == 'R') {
				repeat = repeat % 4;
				int nd = list.get(no).d;
				for(int i=0; i<repeat; i++) {
					nd = (nd+3) % 4;
				}
				list.get(no).d = nd;
			}else {
				int nr = list.get(no).r;
				int nc = list.get(no).c;
				int d = list.get(no).d;
				for(int i=0; i<repeat; i++) {
					nr = nr + dr[d];
					nc = nc + dc[d];
					if(!isIn(nr, nc)) { // 장외
						System.out.println("Robot "+no+" crashes into the wall");
						isOver = true;
						break outer;
					}
					if(map[nr][nc] != 0) { // 다른 로봇과 부딪침
						System.out.println("Robot "+no+" crashes into robot "+map[nr][nc]);
						isOver = true;
						break outer;
					}
				}
				// 별다른 이상이 없다면 list와 map을 초기화 해주자
				map[list.get(no).r][list.get(no).c] = 0;
				map[nr][nc] = no;
				list.get(no).r = nr;
				list.get(no).c = nc;
			}
		}
		if(!isOver) {
			System.out.println("OK");
		}
	}
	
	static int dr[] = {-1,0,1,0}; // 상 좌 하 우
	static int dc[] = {0,-1,0,1};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<B && c<A);
	}
	
	static class Robot{
		int r;
		int c;
		int d;
		public Robot(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Robot [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
	}
	static String src =
			"5 4\r\n"
			+ "2 2\r\n"
			+ "1 1 E\r\n"
			+ "5 4 W\r\n"
			+ "1 F 7\r\n"
			+ "2 F 7";
}
