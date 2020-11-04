package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_17406_배열돌리기4 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K,map[][],copy[][],copy2[][],com[][],com2[][],result[],sum,rsum=Integer.MAX_VALUE, temp;
	static boolean isVisited[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		copy2 = new int[N][M];
		com = new int[K][3];
		com2 = new int[K][3];
		result = new int[K];
		isVisited = new boolean[K];
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(tokens.nextToken());
			}
		}
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<3; i++) {
				com[k][i] = Integer.parseInt(tokens.nextToken());
				com2[k][i] = com[k][i];
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j] = map[i][j];
				copy2[i][j] = map[i][j];
			}	
		}
		
		per(0);
		System.out.println(rsum);
	}
	private static void spin(int[][] map, int[][] com) {
		for(int i=0; i<com.length; i++) {
			int sr = com[i][0]-com[i][2]-1;
			int er = com[i][0]+com[i][2];
			int sc = com[i][1]-com[i][2]-1;
			int ec = com[i][1]+com[i][2];
			while(er - sr > 1) {
				for(int r=sr; r<er; r++) {
					for(int c=sc; c<ec; c++) {
						if(r == sr && c > sc) { // 위
							copy[r][c] = copy2[r][c-1];
						}else if(c==ec-1 && r>sr) {//오른쪽
							copy[r][c] = copy2[r-1][c];
						}else if(r==er-1 && c<ec-1) { // 아래
							copy[r][c] = copy2[r][c+1];
						}else if(c==sc && r<er-1) { // 왼쪽
							copy[r][c] = copy2[r+1][c];
						}
					}
				}	
				sr++;
				er--;
				sc++;
				ec--;
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					copy2[r][c] = copy[r][c];
				}	
			}
		}
	}
	
	private static void per(int cnt) {
		if(cnt == K) {
			for(int i=0; i<result.length; i++) {
				for(int j=0; j<3; j++) {
					com[i][j] = com2[result[i]][j];
				}
			}

			spin(map, com);
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					sum += copy[r][c];
				}
				if(rsum > sum) {
					rsum = sum;
				}
				sum = 0;
			}
			
			return;
		}
		for(int i=0; i<K; i++) {
			if(isVisited[i]) continue;
			
			result[cnt] = i;
			isVisited[i] = true;
			per(cnt+1);
			isVisited[i] = false;
		}
	}
	static String src = "5 6 2\r\n" + 
			"1 2 3 2 5 6\r\n" + 
			"3 8 7 2 1 3\r\n" + 
			"8 2 3 1 4 5\r\n" + 
			"3 4 5 1 1 1\r\n" + 
			"9 3 2 1 4 3\r\n" + 
			"3 4 2\r\n" + 
			"4 2 1";
}
