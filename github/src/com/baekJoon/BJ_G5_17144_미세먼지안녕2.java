package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * @author yhs
 * @date 2020. 9. 2
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항] 확산하는 함수(BFS-4방탐색), 회전시키는 함수, 범위체크
 * [입력사항]
 * [출력사항]
 */

public class BJ_G5_17144_미세먼지안녕2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int R,C,T,map[][],cCnt, Spintemp[][];
	static StringTokenizer tokens;
	static boolean visited[][];
	static Node cleaner[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		Spintemp = new int[R][C];
		visited = new boolean[R][C];
		cleaner = new Node[2];
		for(int r=0; r<R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == -1) {
//					calmap[r][c] = -1;
					cleaner[cCnt++] = new Node(r, c);
				}
			}
		}
//		for(int []x: map) {
//			System.out.println(Arrays.toString(x));
//		}
//		System.out.println(Arrays.toString(cleaner));
		for(int t=0; t<T; t++) {
//			for(int r=0; r<R; r++) {
//				for(int c=0; c<C; c++) {
//					if(map[r][c] != 0 && map[r][c] != -1) { //확산 조건을 만족하면
////						spread(r,c);
//						spread();
//					}
//				}	
//			}
			spread();
//		System.out.println("확산후map");
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					Spintemp[r][c] = map[r][c];
				}	
			}
			map[cleaner[0].x][cleaner[0].y] = 0;
			map[cleaner[1].x][cleaner[1].y] = 0;
			spin();
		}
		
		int sum = 0;
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				sum += map[r][c];
			}	
		}
		System.out.println(sum);
	} 
	
	private static void spin() { 
		for(int r=0; r<=cleaner[0].x; r++) { 
			for(int c=0; c<C; c++) { 
				if(r>0 && c==0) { // 왼쪽 
					Spintemp[r][c] = map[r-1][c]; 
				}else if(c<C-1 && r==0) { // 위 // 잘됨
					Spintemp[r][c] = map[r][c+1];
				}else if(r<cleaner[0].x && c == C-1) { // 오른쪽 // 얘도 잘됨
					Spintemp[r][c] = map[r+1][c];
				}else if(c>0 && r == cleaner[0].x) { // 아래
					Spintemp[r][c] = map[r][c-1];
				}
			}
		}
		
		for(int r=cleaner[1].x; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(r == cleaner[1].x && c > 0) { // 위
					Spintemp[r][c] = map[r][c-1];
				}else if(c==C-1 && r>cleaner[1].x) {//오른쪽
					Spintemp[r][c] = map[r-1][c];
				}else if(r==R-1 && c<C-1) { // 아래
					Spintemp[r][c] = map[r][c+1];
				}else if(c==0 && r<R-1) { // 왼쪽
					Spintemp[r][c] = map[r+1][c];
				}
			}
		}
		Spintemp[cleaner[0].x][cleaner[0].y] = 0;
		Spintemp[cleaner[1].x][cleaner[1].y] = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				map[r][c] = Spintemp[r][c];
			}	
		}
	}

	private static void spread() {
		int[][] status = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int cnt = 0;
                if (map[r][c] >= 5) { 
                    for (int d = 0; d < 4; d++) {
                    	int nr = r + dx[d];
            			int nc = c + dy[d];
                        if (isIn(nr, nc) && map[nr][nc] != -1) {
                            status[nr][nc] += map[r][c] / 5;
                            cnt++;
                        }
                    }
                }
                status[r][c] += map[r][c] - map[r][c] / 5 * cnt;
            }
        }
        map = status;
	}
	
	private static void spread(int r, int c) {
		int cntSpread = 0;
		for(int d=0; d<4; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			
			if(isIn(nr, nc) && map[nr][nc] != -1) {
				visited[nr][nc] = true;
				map[nr][nc] += map[r][c]/5;
				cntSpread++;
			}
		}
		map[r][c] += map[r][c] - (map[r][c]/5)*cntSpread;
	}
	
	

	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<R && c<C);
	}
	
	static String src = 
		"7 8 50\r\n" + 
		"0 0 0 0 0 0 0 9\r\n" + 
		"0 0 0 0 3 0 0 8\r\n" + 
		"-1 0 5 0 0 0 22 0\r\n" + 
		"-1 8 0 0 0 0 0 0\r\n" + 
		"0 0 0 0 0 10 43 0\r\n" + 
		"0 0 5 0 15 0 0 0\r\n" + 
		"0 0 40 0 0 0 20 0";
}
