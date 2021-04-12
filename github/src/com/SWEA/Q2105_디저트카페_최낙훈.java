package com.SWEA;
import java.io.*;
import java.util.*;
//SW Expert <SW역량테스트> '디저트 카페'
public class Q2105_디저트카페_최낙훈 {
	static int N,answer;
	static int [][] map;
	static boolean [] visited;
	static int [] dx = {1,1,-1,-1};
	static int [] dy = {-1,1,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			answer = -1;
			map = new int[N][N];
			visited = new boolean[101];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int k=1;k<N;k++) {
						for(int m=1;m<N-k;m++) {
							isPossible(i,j,k,m);
						}
					}
				}
			}
			
			System.out.println("#"+t +" " + answer);
		}
	}
	
	public static boolean isPossible(int x, int y, int left, int right) {
		int count = 0;
		int nx = x;
		int ny = y;
		
		Arrays.fill(visited, false);
		
		for(int i=0;i<left;i++) {
			nx += dx[0];
			ny += dy[0];
			
			if(!isIn(nx,ny)) {
				return false;
			}
			if(visited[map[nx][ny]]) 
				return false;
			visited[map[nx][ny]] = true;
			count++;
		}
		for(int i=0;i<right;i++) {
			nx += dx[1];
			ny += dy[1];
			
			if(!isIn(nx,ny)) {
				return false;
			}
			if(visited[map[nx][ny]]) 
				return false;
			visited[map[nx][ny]] = true;
			count++;
		}
		for(int i=0;i<left;i++) {
			nx += dx[2];
			ny += dy[2];
			
			if(!isIn(nx,ny)) {
				return false;
			}
			if(visited[map[nx][ny]]) 
				return false;
			visited[map[nx][ny]] = true;
			count++;
		}
		for(int i=0;i<right;i++) {
			nx += dx[3];
			ny += dy[3];
			
			if(!isIn(nx,ny)) {
				return false;
			}
			if(visited[map[nx][ny]]) 
				return false;
			visited[map[nx][ny]] = true;
			count++;
		}
		answer = Math.max(answer, count);
		
		return true;
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
}