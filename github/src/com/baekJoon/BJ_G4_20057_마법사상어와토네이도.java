package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_20057_마법사상어와토네이도 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, map[][], outSand;
	static Tornado tor;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		tor = new Tornado(N/2, N/2, 0);
		for(int i=1; i<N; i++) { 
			for(int t=0; t<i; t++) {
				move();
			}
			tor.d = (tor.d+1)%4; // 왼쪽으로 돌때 방향공식
			for(int t=0; t<i; t++) {
				move();
			}
			tor.d = (tor.d+1)%4;
			if(i == N-1) {
//				System.out.println("?????");
				for(int t=0; t<N; t++) {
					move();
				}
			}
		}
		System.out.println(outSand);
	}
	
	private static void move() {
//		System.out.println(tor);
		int tr = tor.r + dr[tor.d];
		int tc = tor.c + dc[tor.d];
		if(!isIn(tr, tc)) return; // 마지막 0,0 일때 끝내기
		tor.r = tr; // 토네이도 이동
		tor.c = tc;
		int nr = 0, nc = 0, sand = 0, sum = 0;
		
		int totalSand = map[tr][tc]; // y의 모든 모래
		if(totalSand == 0) return;
		map[tr][tc] = 0; // 모래 다뺌 ㅜㅜ
		// 앞앞 : 5%
		nr = tr + 2 * dr[tor.d];
		nc = tc + 2 * dc[tor.d];
		sand = totalSand *5/100;
		sum += sand;
		if(isIn(nr, nc)) {
			map[nr][nc] += sand;
		}else {
			outSand += sand;
		}
		// 오른쪽 : 7%
		nr = tr + dr[(tor.d+3) % 4];
		nc = tc + dc[(tor.d+3) % 4];
		sand = totalSand *7/100;
		sum += sand;
		if(isIn(nr, nc)) {
			map[nr][nc] += sand;
		}else {
			outSand += sand;
		}
		// 오른쪽오른쪽 : 2%
		nr = tr + 2 * dr[(tor.d+3) % 4];
		nc = tc + 2 * dc[(tor.d+3) % 4];
		sand = totalSand *2/100;
		sum += sand;
		if(isIn(nr, nc)) {
			map[nr][nc] += sand;
		}else {
			outSand += sand;
		}
		// 왼쪽 : 7%
		nr = tr + dr[(tor.d+1) % 4];
		nc = tc + dc[(tor.d+1) % 4];
		sand = totalSand *7/100;
		sum += sand;
		if(isIn(nr, nc)) {
			map[nr][nc] += sand;
		}else {
			outSand += sand;
		}
		// 왼쪽왼쪽 : 2%
		nr = tr + 2 * dr[(tor.d+1) % 4];
		nc = tc + 2 * dc[(tor.d+1) % 4];
		sand = totalSand *2/100;
		sum += sand;
		if(isIn(nr, nc)) {
			map[nr][nc] += sand;
		}else {
			outSand += sand;
		}
		// 앞 오른쪽 : 10%
		nr = tr + dr[tor.d] + dr[(tor.d+3) % 4];
		nc = tc + dc[tor.d] + dc[(tor.d+3) % 4];
		
		sand = totalSand *10/100;
		sum += sand;
		if(isIn(nr, nc)) {
			map[nr][nc] += sand;
		}else {
			outSand += sand;
		}
		// 앞 왼쪽 : 10%
		nr = tr + dr[tor.d] + dr[(tor.d+1) % 4];
		nc = tc + dc[tor.d] + dc[(tor.d+1) % 4];
		
		sand = totalSand *10/100;
		sum += sand;
		if(isIn(nr, nc)) {
			map[nr][nc] += sand;
		}else {
			outSand += sand;
		}
		// 뒤 오른쪽 : 1%
		nr = tr + dr[(tor.d+3)%4] + dr[(tor.d+2) % 4];
		nc = tc + dc[(tor.d+3)%4] + dc[(tor.d+2) % 4];
		
		sand = totalSand *1/100;
		sum += sand;
		if(isIn(nr, nc)) {
			map[nr][nc] += sand;
		}else {
			outSand += sand;
		}
		// 뒤 왼쪽 : 1%
		nr = tr + dr[(tor.d+2) % 4] + dr[(tor.d+1)%4];
		nc = tc + dc[(tor.d+2) % 4] + dc[(tor.d+1)%4];
		
		sand = totalSand *1/100;
		sum += sand;
		if(isIn(nr, nc)) {
			map[nr][nc] += sand;
		}else {
			outSand += sand;
		}
		// 앞 : 다 퍼주고 남은 sand
		nr = tr + dr[tor.d];
		nc = tc + dc[tor.d];
		if(isIn(nr, nc)) {
			map[nr][nc] += totalSand - sum;
		}else {
			outSand += totalSand - sum;
		}
		
//		for(int x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
//		System.out.println();
	}

	static class Tornado{
		int r;
		int c;
		int d;
		public Tornado(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Tornado [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
	}
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	
	static int dr[] = {0,1,0,-1}; // 0 1 2 3 : 좌 하 우 상 (+1%4) 
	static int dc[] = {-1,0,1,0};

	static String src =
			"9\r\n"
			+ "193 483 223 482 858 274 847 283 748\r\n"
			+ "484 273 585 868 271 444 584 293 858\r\n"
			+ "828 384 382 818 347 858 293 999 727\r\n"
			+ "818 384 727 373 636 141 234 589 991\r\n"
			+ "913 564 555 827 0 999 123 123 123\r\n"
			+ "321 321 321 983 982 981 983 980 990\r\n"
			+ "908 105 270 173 147 148 850 992 113\r\n"
			+ "943 923 982 981 223 131 222 913 562\r\n"
			+ "752 572 719 590 551 179 141 137 731";
}
