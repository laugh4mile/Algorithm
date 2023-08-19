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

public class BJ_G5_9019_DSLR2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int T, A, B;
	static String result;
	static boolean isVisited[] = new boolean [10000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			A = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());
			Arrays.fill(isVisited, false);
			bfs(A,B);
		}
		output.close();
	}
	
	private static void bfs(int cur, int end) throws IOException {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(cur, ""));
		isVisited[cur] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(front.num == end) {
				output.append(front.str+"\n");
				break;
			}
			int nnum = (front.num * 2) % 10000;
			if(!isVisited[nnum]) {
				isVisited[nnum] = true;
				queue.offer(new Node(nnum, front.str+"D"));
			}
			nnum = front.num-1;
			if(nnum == -1) {
				nnum = 9999;
			}
			if(!isVisited[nnum]) {
				isVisited[nnum] = true;
				queue.offer(new Node(nnum, front.str+"S"));
			}
			
			int d1 = (front.num/1000)%10;
			int d2 = (front.num/100)%10;
			int d3 = (front.num/10)%10;
			int d4 = front.num%10;
			nnum = ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
			if(!isVisited[nnum]) {
				isVisited[nnum] = true;
				queue.offer(new Node(nnum, front.str+"L"));
			}
			nnum = ((d4 * 10 + d1) * 10 + d2) * 10 + d3;
			if(!isVisited[nnum]) {
				isVisited[nnum] = true;
				queue.offer(new Node(nnum, front.str+"R"));
			}
		}
		
	}
	
	static class Node{
		int num;
		String str;
		public Node(int num, String str) {
			super();
			this.num = num;
			this.str = str;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", str=" + str + "]";
		}
	}

	static String src =
			"3\r\n" + 
			"1234 3412\r\n" + 
			"1000 1\r\n" + 
			"1 16";
}