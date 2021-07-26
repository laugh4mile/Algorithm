package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_15684_사다리조작 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C,M,ladder[][], answer = -1;
	static boolean isOver;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		ladder = new int[R][C];
		int cnt = 1;
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken())-1;
			ladder[r][c] = cnt;
			ladder[r][c+1] = cnt++;
		}
		for(int i=0; i<=3; i++) {
			combination(0, 0, i);
		}
		System.out.println(answer);
	}
	
	private static void combination(int start, int cnt, int end) {
		if(isOver) return;
		if(cnt == end) {
			if(isCorrect()) {
				answer = end;
				isOver = true;
			}
			return;
		}
		
		for(int i=start; i<R*(C-1); i++) {
			int r = i/(C-1);
			int c = i%(C-1);
			if(ladder[r][c] != 0 || ladder[r][c+1] != 0) {
				continue;
			}
			if(cnt==1 && ladder[r][c] != 0) {
				continue;
			}
			ladder[r][c] = ++M;
			ladder[r][c+1] = M;
			combination(i+1, cnt+1, end);
			ladder[r][c] = 0;
			ladder[r][c+1] = 0;
			M--;
		}
	}

	private static boolean isCorrect() {
		for(int i=0; i<C-1; i++) {
			boolean isVisited[] = new boolean[M+1];
			int r = 0;
			int c = i;
			
			while(true) {
				if(r == R) break;
				if(ladder[r][c] == 0) { // 0 인 경우
					r++;
				}else { // 0 이 아닌 경우 -> 사다리가 연결된 경우
					if(isVisited[ladder[r][c]]) { // 아래로 가는 경우
						r++;
					}
					else if(isIn(r, c+1) && !isVisited[ladder[r][c]] && ladder[r][c] == ladder[r][c+1]) { // 오른쪽으로 가는경우
						isVisited[ladder[r][c]] = true;
						c++;
					}else if(isIn(r, c-1) && !isVisited[ladder[r][c]] && ladder[r][c] == ladder[r][c-1]) { // 왼쪽으로 가는 경우
						isVisited[ladder[r][c]] = true;
						c--;
					}
				}
			}
			if(c != i) {
				return false;
			}
		}
		return true; // 다 돌았는데 이상이 없으면 전부다 자기 번호로 내려온다는 의미!
	}
	
	static boolean isIn(int r, int c) {
		return(r>=0 && c>=0 && r<R && c<C);
	}
	static String src = 
			"5 6 6\r\n"
			+ "1 1\r\n"
			+ "3 1\r\n"
			+ "5 2\r\n"
			+ "4 3\r\n"
			+ "2 3\r\n"
			+ "1 4";
}
