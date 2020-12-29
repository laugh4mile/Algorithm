package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G3_8982_수족관1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, map[][], K, maxR, maxC;
	static Node[] list, hole;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		list = new Node[N];
		for(int n=0; n<N; n++) {
			list[n] = new Node(0, 0);
			tokens = new StringTokenizer(input.readLine());
			list[n].c = Integer.parseInt(tokens.nextToken());
			list[n].r = Integer.parseInt(tokens.nextToken());
			if(maxR < list[n].r) {
				maxR = list[n].r;
			}
			if(maxC < list[n].c) {
				maxC = list[n].c;
			}
		}
		map = new int[maxR][maxC];
		K = Integer.parseInt(input.readLine());
		hole = new Node[K];
		for(int k=0; k<K; k++) {
			hole[k] = new Node(0, 0);
			tokens = new StringTokenizer(input.readLine());
			hole[k].c = Integer.parseInt(tokens.nextToken());
			hole[k].r = Integer.parseInt(tokens.nextToken());
		} // 입력 끝.
		
//		for(int []x : map) {
//			System.out.println(Arrays.toString(x));
//		}
//		System.out.println();
		fillMap();
		emptyMap();
		System.out.println(countWater());
	}
	
	private static int countWater() {
		int sum = 0;
		for(int r=0; r<maxR; r++) {
			for(int c=0; c<maxC; c++) {
				if(map[r][c] == 1) {
					sum++;
				}
			}	
		}
		return sum;
	}

	private static void emptyMap() {
		for(int i=0; i<K; i++) {
			int curR = hole[i].r;
			if(curR != 0) { // 구멍이 맨위에 뚫린게 아니라면
				// 오른쪽 물뺴기
				for(int c=hole[i].c; c<maxC; c++) {
					if(map[curR-1][c] != 0) {
						for(int r=0; r<curR; r++) {
							map[r][c] = 2;
						}
					}else {
						for(int r=0; r<maxR; r++) {
							if(map[r][c]==0) {
								curR = r;
								break;
							}
						}
					}
				}
				// 왼쪽 물빼기 
				curR = hole[i].r;
				for(int c=hole[i].c; c>=0; c--) {
					if(map[curR-1][c] != 0) {
						for(int r=0; r<curR; r++) {
							map[r][c] = 2;
						}
					}else {
						for(int r=0; r<maxR; r++) {
							if(map[r][c]==0) {
								curR = r;
								break;
							}
						}
					}
				}
			}
		}
	}
	
	private static void fillMap() {
		for(int i=1; i<N-2; i++) {
			for(int c=list[i].c; c<list[i+1].c; c++) {
				for(int r=0; r<list[i].r; r++){
					map[r][c] = 1;
				}
			}
		}
	}
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
	}
	static String src =
			"14\r\n" + 
			"0 0\r\n" + 
			"0 5\r\n" + 
			"1 5\r\n" + 
			"1 3\r\n" + 
			"2 3\r\n" + 
			"2 4\r\n" + 
			"3 4\r\n" + 
			"3 2\r\n" + 
			"5 2\r\n" + 
			"5 4\r\n" + 
			"6 4\r\n" + 
			"6 3\r\n" + 
			"8 3\r\n" + 
			"8 0\r\n" + 
			"2\r\n" + 
			"1 3 2 3\r\n" + 
			"3 2 5 2";
}
