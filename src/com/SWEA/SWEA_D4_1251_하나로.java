package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_D4_1251_하나로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N;
	static double E;
	static List<Node> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(input.readLine());
			int x[] = new int[N];
			int y[] = new int[N];
			tokens = new StringTokenizer(input.readLine());
			for(int n=0; n<N; n++) {
				x[n] = Integer.parseInt(tokens.nextToken());
			}
			tokens = new StringTokenizer(input.readLine());
			for(int n=0; n<N; n++) {
				y[n] = Integer.parseInt(tokens.nextToken());
			}
			E = Double.parseDouble(input.readLine());
			for(int i=0; i<N; i++) {
				long x1 = x[i];
				long y1 = y[i];
				for(int j=i; j<N; j++) {
					if(i == j) continue;
					long x2 = x[j];
					long y2 = y[j];
					double d = (Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2))*E;
					list.add(new Node(i, j, d));
				}
			}
			Collections.sort(list);
			System.out.println(list.toString());
			int[] p = new int[N+1];
			for(int i = 1; i<=N; i++) { // make
				p[i] = i;
			}
			
			double sum = 0;
			
			for(int i=0; i<list.size(); i++) {
				if(!find(p,list.get(i).x, list.get(i).y)) { // 부모가 다르다면?
					sum+= list.get(i).w;
					union(p, list.get(i).x, list.get(i).y);
				}
			}
			System.out.println("#" + t + " " + Math.round(sum));
		}
		
	}
	public static boolean find(int[] p , int x, int y) { 
		return findSet(p, x) == findSet(p, y); 
	}

	static int findSet(int [] p, int x) {
		if(x == p[x]) {
			return x;
		}
		return p[x] = findSet(p, p[x]);
	}
	
	static void union(int[] p, int x, int y) {
		x = findSet(p, x);
		y = findSet(p, y);
		if(x > y) {
			p[y] = x;
		}else {
			p[x] = y;
		}
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		double w;
		public Node(int x, int y, double w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return Double.compare(w, o.w);
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", w=" + w + "]";
		}
		
	}
	static String src = 
			"4\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"0 100\r\n" + 
			"1.0\r\n" + 
			"4\r\n" + 
			"0 0 400 400\r\n" + 
			"0 100 0 100\r\n" + 
			"1.0\r\n" + 
			"6\r\n" + 
			"0 0 400 400 1000 2000\r\n" + 
			"0 100 0 100 600 2000\r\n" + 
			"0.3\r\n" + 
			"9\r\n" + 
			"567 5 45674 24 797 29 0 0 0\r\n" + 
			"345352 5464 145346 54764 5875 0 3453 4545 123\r\n" + 
			"0.0005";
}