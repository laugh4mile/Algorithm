package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_1963_소수경로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int T, A, B;
	static boolean prime[], isVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		prime = new boolean[10000];
		isVisited = new boolean[10000];
		Arrays.fill(prime, true);
		makePrime();
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			A = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());
			
			bfs(A);
			Arrays.fill(isVisited, false);
		}
		output.close();
	}

	private static void bfs(int num1) throws IOException {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(num1, 0));
		isVisited[num1] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			if(front.num == B) {
				output.append(front.cnt + "\n");
				return;
			}
			
			for(int i=0; i<4; i++) {
				StringBuilder temp = new StringBuilder();
				temp.append(front.num);
				for(int j=0; j<10; j++) {
					temp.setCharAt(i, (char) (j + '0'));
					int tmp = Integer.parseInt(temp.toString());
					if(prime[tmp] && !isVisited[tmp] && tmp>=1000 && tmp<10000) {
						queue.offer(new Node(tmp, front.cnt+1));
						isVisited[tmp] = true;
					}
				}
			}
		}
		output.append("Impossible\n");
		return;
	}
	
	static class Node{
		int num;
		int cnt;
		public Node(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}

	private static void makePrime() {
		for(int i=2; i*i<10000; i++) {
			for(int j=i+i; j<10000; j+=i) {
				prime[j] = false;
			}	
		}
	}

	static String src =
			"3\r\n" + 
			"1033 8179\r\n" + 
			"1373 8017\r\n" + 
			"1033 1033";
}
