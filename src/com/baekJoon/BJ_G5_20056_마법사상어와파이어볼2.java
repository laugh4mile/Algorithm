package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_20056_마법사상어와파이어볼2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K,map[][];
	static List<FireBall> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken())-1; 
			int c = Integer.parseInt(tokens.nextToken())-1; 
			int m = Integer.parseInt(tokens.nextToken()); 
			int s = Integer.parseInt(tokens.nextToken()); 
			int d = Integer.parseInt(tokens.nextToken());
			list.add(new FireBall(r, c, m, s, d));
			map[r][c] = 1;
		}
		for(int x[] : map) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println(list);
		for(int k=0; k<K; k++) {
			move();
		}
		
		int answer = 0;
		for(int i=0; i<list.size(); i++) {
			answer += list.get(i).m;
		}
		System.out.println(answer);
		
	}
	private static void move() {
		for(int i=0; i<list.size(); i++) {
			FireBall front = list.get(i);
			int nr = front.r + dr[front.d] * front.s;
			int nc = front.c + dc[front.d] * front.s;
			if(nr > N-1) nr = nr%N;
			if(nr < 0) nr = N - (Math.abs(nr) % N);
			if(nc > N-1) nc = nc%N;
			if(nc < 0) nc = N - (Math.abs(nc) % N);
			map[front.r][front.c]--;
			map[nr][nc]++;
			list.get(i).r = nr;
			list.get(i).c = nc;
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] > 1) {
					combine(r,c,map[r][c]);
				}
			}
		}
		System.out.println();
		for(int x[] : map) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println(list);
	}
	private static void combine(int r, int c, int cnt) { //cnt 는 겹친 파이어볼의 개수
		map[r][c] = 4;
		int sumM = 0;
		int sumS = 0;
		int temp = -1;
		boolean flag = false; // 방향이 일관성 없는지 확인하는 변수
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).r == r && list.get(i).c == c) {
				sumM += list.get(i).m;
				sumS += list.get(i).s;
				if(!flag) {
					if(temp == -1) {
						temp = list.get(i).d % 2;
					}else if(temp != list.get(i).d%2) {
						flag = true;
					} 
				}
				list.remove(i);
				i--; // 리스트에서 하나 빠졌으니 i도 줄여 줘야함
			}
		}
		sumM = sumM / 5;
		sumS = sumS / cnt;
		if(sumM > 0) { // 질량이 0 이상이어야 함
			if(!flag) { // 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수인 경우
				// 방향은 0,2,4,6
				for(int d=0; d<7; d+=2) {
					list.add(new FireBall(r, c, sumM, sumS, d));
				} // 파이어볼의 방향이 제각각인 경우
			}else {
				// 방향은 1,3,5,7
				for(int d=1; d<8; d+=2) {
					list.add(new FireBall(r, c, sumM, sumS, d));
				}
			}
		}
	}
	static class FireBall{
		int r;
		int c;
		int m;
		int s;
		int d;
		public FireBall(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		@Override
		public String toString() {
			return "FireBall [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
	}
	static int dr[] = {-1,-1,0,1,1,1,0,-1}; // 8 방향. 순서 중요함.
	static int dc[] = {0,1,1,1,0,-1,-1,-1};
	static String src =
			"4 2 1\r\n"
			+ "1 1 5 2 6\r\n"
			+ "1 4 7 1 6";
}
