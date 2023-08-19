package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_1713_후보추천하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int recommend = Integer.parseInt(input.readLine());
		int vote[] = new int [recommend];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<recommend; i++) {
			vote[i] = Integer.parseInt(tokens.nextToken());
		}
		solution(N, recommend, vote);
	}

	private static void solution(int N, int recommend, int vote[]) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=0; i<recommend; i++) {
			Node cur = new Node(i, vote[i], 1);
			Queue<Node> queue = new LinkedList<>();
			boolean flag = false;
			while(!pq.isEmpty()) {
				Node front = pq.poll();
				if(front.student == cur.student) {
					queue.offer(new Node(front.no, front.student, front.count+1));
					flag = true;
				}else {
					queue.offer(new Node(front.no, front.student, front.count));
				}
			}
			while(!queue.isEmpty()) {
				pq.offer(queue.poll());
			}
			if(!flag) {
				if(pq.size()>=N) { // 시발
					pq.poll();
				}
				pq.offer(cur);
			}
		}
		int answer[] = new int[pq.size()];
		int cnt = 0;
		while(!pq.isEmpty()) {
			answer[cnt++] = pq.poll().student;
		}
		Arrays.sort(answer);
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	
	static class Node implements Comparable<Node>{
		int no;
		int student;
		int count;
		
		public Node(int no, int student, int count) {
			super();
			this.no = no;
			this.student = student;
			this.count = count;
		}
		@Override
		public int compareTo(Node o) {
			if(this.count == o.count) {
				return Integer.compare(this.no, o.no);
			}
			return Integer.compare(this.count, o.count);
		}
		@Override
		public String toString() {
			return "Node [no=" + no + ", student=" + student + ", count=" + count + "]";
		}
		
	}

	static String src =
			"2\r\n"
			+ "11\r\n"
			+ "1 2 2 2 3 3 1 1 1 3 3";
}
