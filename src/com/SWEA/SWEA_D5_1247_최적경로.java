package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D5_1247_최적경로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N, result[],d,rd;
	static boolean isSelected[];
	static Node office, home, costomer[],seq[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			rd = Integer.MAX_VALUE;
			N = Integer.parseInt(input.readLine());
			costomer = new Node[N];
			result = new int[N]; 
			isSelected = new boolean[N];
			seq = new Node[N+2];
			tokens = new StringTokenizer(input.readLine());
			int ox = Integer.parseInt(tokens.nextToken());
			int oy = Integer.parseInt(tokens.nextToken());
			office = new Node(ox, oy);
			
			int hx = Integer.parseInt(tokens.nextToken());
			int hy = Integer.parseInt(tokens.nextToken());
			home = new Node(hx, hy);
			
			for(int n=0; n<N; n++) {
				int cx = Integer.parseInt(tokens.nextToken());
				int cy = Integer.parseInt(tokens.nextToken());
				costomer[n] = new Node(cx, cy);
			}
//			System.out.println(office);
//			System.out.println(home);
//			for(Node x: costomer) {
//				System.out.print(x+" ");
//			}
			seq[0] = new Node(ox, oy);
			seq[N+1] = new Node(hx, hy);
			per(0);
			System.out.printf("#%d %d\n",t+1,rd);
		}
	}
	

	private static void search(int[] result) {
		d = 0;
		for(int i=0; i<N; i++) {
			seq[i+1] = costomer[result[i]];
		}
//		System.out.println(Arrays.toString(seq));
		for(int i=0; i<seq.length-1; i++) {
			d += Math.abs(seq[i].x - seq[i+1].x) + Math.abs(seq[i].y - seq[i+1].y);
			if(d > rd) {
//				System.out.println(d + " " + rd);
				return;
			}
		}
		if(rd > d) {
			rd = d;
		}
	}
	
	private static void per(int cnt) {
		if(cnt == N) {
			search(result);
			return;
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			result[cnt] = i;
			isSelected[i] = true;
			per(cnt+1);
			isSelected[i] = false;
		}
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
	
	static String src = 
			"10\r\n" + 
			"5\r\n" + 
			"0 0 100 100 70 40 30 10 10 5 90 70 50 20\r\n" + 
			"6\r\n" + 
			"88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14\r\n" + 
			"7\r\n" + 
			"22 47 72 42 61 93 8 31 72 54 0 64 26 71 93 87 84 83\r\n" + 
			"8\r\n" + 
			"30 20 43 14 58 5 91 51 55 87 40 91 14 55 28 80 75 24 74 63\r\n" + 
			"9\r\n" + 
			"3 9 100 100 16 52 18 19 35 67 42 29 47 68 59 38 68 81 80 37 94 92\r\n" + 
			"10\r\n" + 
			"39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36\r\n" + 
			"10\r\n" + 
			"26 100 72 2 71 100 29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96\r\n" + 
			"10\r\n" + 
			"46 25 16 6 48 82 80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63\r\n" + 
			"10\r\n" + 
			"94 83 72 42 43 36 59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3\r\n" + 
			"10\r\n" + 
			"32 79 0 0 69 58 100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86\r\n" + 
			"";

}
