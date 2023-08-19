package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 12. 3
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 먼저 입력받은 타일들을 크기순으로 정렬
 * 맨처음 M*M의 타일을 가져와서 위의 제일큰놈 크기로 자름
 * 그러면 M * (M-s)
 * [입력사항]
 * [출력사항]
 */

public class SWEA_D5_1812_수정이의타일자르기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,M;
	static PriorityQueue<Tile> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			pq = new PriorityQueue<Tile>();
			int answer = 0;
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			int arr[] = new int[N];
			
			tokens = new StringTokenizer(input.readLine());
			for(int n=0; n<N; n++) {
				int side = Integer.parseInt(tokens.nextToken());
				arr[n] = (int) Math.pow(2, side);
			}
			
			Arrays.sort(arr);
			
			pq.offer(new Tile(M, M)); // 처음엔 무조건 타일 한장을 사야함
			answer++;
			
			for(int i=N-1; i>=0; i--) {
				Tile tile = pq.poll();
				if(tile.min >= arr[i] ) {
					pq.offer(new Tile(tile.min-arr[i], arr[i]));
					pq.offer(new Tile(tile.min, tile.max-arr[i]));
				}else {
					pq.offer(tile);
					pq.offer(new Tile(M-arr[i], arr[i]));
					pq.offer(new Tile(M, M-arr[i]));
					answer++;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
	
	static class Tile implements Comparable<Tile>{
		int min;
		int max;
		
		public Tile(int width, int height) {
			this.min = Math.min(width, height);
			this.max = Math.max(width, height);
		}
		@Override
		public int compareTo(Tile o) {
			return o.min - this.min;
		}
		
		@Override
		public String toString() {
			return "Tile [min=" + min + ", max=" + max + "]";
		}
		

	}

	static String src =
			"3\r\n" + 
	
			"500 452\r\n" + 
			"3 6 6 3 5 0 6 8 8 1 7 2 2 6 2 2 6 5 0 0 3 5 3 8 6 2 7 6 6 2 1 6 7 0 7 1 0 5 2 5 6 5 1 3 7 8 7 4 0 7 6 4 3 8 5 5 8 7 0 1 8 7 1 6 3 1 7 7 1 0 4 7 7 4 4 3 0 2 7 7 6 1 0 5 7 5 7 3 5 6 3 3 4 5 7 1 5 4 8 3 5 7 0 4 1 7 0 4 6 1 8 4 6 8 5 0 5 4 5 8 4 7 3 1 1 5 0 3 5 3 0 8 5 3 3 3 6 5 4 1 6 6 3 4 8 7 7 5 6 3 6 0 4 1 0 5 5 8 3 0 4 0 7 8 0 0 1 0 7 3 5 0 4 6 2 2 4 8 0 6 2 1 5 7 4 0 1 3 1 7 3 8 8 8 5 1 2 6 1 5 8 7 1 2 3 8 0 8 2 2 0 7 6 3 0 7 4 5 0 5 8 7 2 3 1 1 0 5 5 8 4 7 6 4 1 5 1 8 8 8 7 4 3 2 6 5 4 4 5 7 1 8 1 3 7 6 7 5 8 6 1 0 5 0 8 5 7 6 6 3 5 0 6 0 1 4 3 7 3 4 2 5 5 3 8 6 0 5 7 5 5 5 7 4 2 1 4 3 5 7 8 4 3 2 7 2 6 5 7 6 4 5 8 8 6 2 7 8 3 0 8 4 8 6 4 8 2 8 5 4 7 8 5 3 7 4 5 6 6 1 7 3 8 7 4 4 7 1 3 5 7 7 5 8 4 4 4 4 0 3 0 3 4 4 4 6 3 7 8 7 3 5 2 7 4 1 1 6 0 8 1 6 4 3 8 2 4 5 0 2 3 5 6 5 8 4 4 2 0 0 3 8 4 2 3 5 3 7 2 2 7 8 0 5 4 5 0 8 6 7 5 4 1 6 8 1 4 2 1 8 0 3 6 4 2 1 8 4 0 7 7 8 8 8 6 3 1 1 2 8 4 5 2 5 5 6 2 0 8 4 1 2 4 4 1 5 5 2 0 1 0 6 0 7 7 6 2 5 8 0 6 1 7 6 0 3 5 7 0 8 1 3 6 6 0 2 6 6 6 7\r\n" + 
			"500 256\r\n" + 
			"5 7 6 1 4 6 5 0 7 5 7 5 0 7 5 8 2 7 2 0 6 0 5 6 2 4 1 4 7 2 7 7 3 7 0 1 6 2 0 2 1 0 8 6 4 5 3 7 3 5 3 7 6 2 8 4 4 2 0 2 2 0 4 7 1 0 3 7 8 6 4 8 6 2 4 5 3 5 8 2 5 7 5 5 2 8 5 3 4 8 8 8 5 1 0 6 6 1 7 8 7 3 6 1 5 6 5 6 4 3 1 8 4 3 7 7 8 5 7 0 7 3 1 6 8 0 1 6 7 5 3 6 1 0 1 6 2 3 2 0 0 3 8 3 5 3 0 3 1 5 5 0 1 6 4 0 3 8 5 4 2 5 8 5 0 2 6 5 6 7 7 3 8 4 5 6 4 0 6 8 3 5 7 5 6 5 8 4 7 5 7 0 8 6 6 3 3 4 3 8 3 4 0 5 4 6 6 5 4 0 5 4 4 6 6 6 6 5 4 4 2 6 6 2 6 6 5 1 0 3 5 0 6 7 5 8 2 5 6 3 8 0 1 0 0 0 3 0 5 6 4 8 8 3 8 4 5 1 7 2 3 5 0 5 0 5 7 5 0 6 7 5 4 5 3 5 7 6 8 7 5 7 6 8 8 6 6 7 2 6 7 7 4 4 5 6 8 3 6 8 8 4 8 0 6 0 0 6 5 5 7 1 8 4 4 4 7 0 1 6 1 3 3 0 8 0 2 6 7 3 0 1 1 0 8 7 0 0 7 1 1 6 6 3 4 7 7 8 6 1 5 5 8 3 0 1 3 3 8 2 6 2 2 7 2 5 1 6 1 0 3 1 0 6 4 1 5 6 4 3 1 3 4 3 8 6 2 5 8 5 7 4 8 8 0 4 7 7 8 4 5 7 8 8 8 1 3 7 4 3 2 6 7 1 2 3 2 3 8 5 7 0 2 3 6 0 7 3 0 5 1 5 4 7 8 5 5 2 0 8 7 0 3 5 7 7 6 2 1 1 3 8 5 1 5 3 3 6 6 3 1 2 0 5 6 8 3 7 7 8 8 6 4 2 1 2 1 5 3 5 5 6 0 6 3 8 6 5 5 2 5 8 6 8 5 3 6 7 6 3\r\n" + 
			"500 223\r\n" + 
			"0 3 7 4 1 5 7 7 7 0 1 4 3 3 3 1 7 5 5 5 2 7 6 5 1 5 1 5 7 7 3 1 7 0 4 0 2 7 1 7 2 5 7 1 5 1 6 2 5 7 0 4 6 0 0 2 0 7 3 6 4 6 0 6 4 2 5 2 0 0 0 1 3 1 6 6 2 4 0 3 5 5 3 3 0 4 5 1 5 3 3 7 5 6 2 4 7 4 3 1 6 4 5 3 7 2 6 7 0 6 5 1 6 2 4 0 0 7 3 3 5 2 4 0 5 2 7 5 1 6 3 4 6 0 3 6 6 4 0 6 3 4 4 2 0 4 3 4 6 4 7 4 4 6 3 2 4 1 6 6 5 5 0 6 7 2 4 5 2 2 6 1 0 2 2 0 1 2 1 5 0 3 6 2 6 2 1 6 0 7 3 5 5 1 7 2 5 0 0 5 7 4 3 2 6 2 3 6 3 4 4 4 1 4 1 1 5 0 2 3 6 2 1 6 1 4 2 7 7 6 2 4 6 4 4 6 6 1 0 7 2 0 4 2 4 1 6 2 7 5 6 7 7 4 5 4 0 5 7 4 6 2 4 3 7 5 7 3 5 4 5 7 6 4 4 0 6 3 4 7 7 7 3 4 2 4 5 7 1 1 2 3 6 5 6 5 6 6 4 5 3 6 2 1 4 4 0 2 1 2 6 5 2 1 7 4 4 5 5 6 6 7 3 5 7 0 1 5 7 4 6 1 7 2 1 3 6 2 7 0 2 5 3 0 1 7 0 5 7 6 4 7 4 5 0 2 5 2 0 7 6 7 6 0 5 3 7 6 7 2 0 6 0 5 6 4 7 5 4 2 1 7 2 3 1 0 4 3 1 0 5 4 4 4 6 5 1 5 5 0 1 7 5 7 6 5 0 4 6 5 1 3 5 5 1 1 0 6 2 6 5 6 7 5 5 1 5 2 4 4 2 6 4 5 2 6 6 5 5 1 2 4 4 2 7 6 2 4 0 4 3 4 3 6 5 3 7 7 1 3 2 4 4 4 7 1 2 5 7 7 5 4 0 3 2 6 5 3 1 2 4 3 5 3 6 5 5 1 3 4 2 4 7 3 4 4 4 6 1 5\r\n"; 
			
}
