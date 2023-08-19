package com.codingtest.bro.cupang;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q33 {
	public static void main(String[] args) {
		int n = 1;
		String[] record = {
				"1 fracta",
				"1 sina",
				"1 hana",
				"1 robel",
				"1 abc",
				"1 sina",
				"1 lynn"};

		String answer[] = {};
		answer = solution(n, record);
		
	}
	private static String[] solution(int n, String[] record) {
		String answer[] = {};
		
		StringTokenizer tokens;
		Map<String, String> map[] = new Map[n+1];
		PriorityQueue<Node> queue[] = new PriorityQueue[n+1];
		
		for(int i=1; i<n+1; i++) {
			map[i] = new HashMap<>();
			queue[i] = new PriorityQueue<>();
		}
		
		int seq = 0;
		for(int i=0; i<record.length; i++) {
			tokens = new StringTokenizer(record[i]);
			int server = Integer.parseInt(tokens.nextToken());
			String nickName = tokens.nextToken();
			
			if(map[server].get(nickName) == null) {
				map[server].put(nickName, nickName);
				queue[server].offer(new Node(server, nickName, seq++));
				if(queue[server].size() > 5) {
					map[server].remove(queue[server].poll());
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<n+1; i++) {
			while(!queue[i].isEmpty()) {
				
			}
		}
		
		return answer;
	}
	static class Node implements Comparable<Node>{
		int server;
		String nickName;
		int seq;
		public Node(int server, String nickName, int seq) {
			super();
			this.server = server;
			this.nickName = nickName;
			this.seq = seq;
		}
		@Override
		public String toString() {
			return "Charactor [server=" + server + ", nickName=" + nickName + ", seq=" + seq + "]";
		}
		@Override
		public int compareTo(Node o) {
			if(this.server == o.server) {
				return Integer.compare(this.seq, o.seq);
			}
			return Integer.compare(this.server, o.server);
		}
		
	}
}
