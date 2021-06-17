package com.codingtest.modusign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class S1 {
	static StringTokenizer tokens;
	static int [][] paths = {{1,2}, {2,3}, {3,4}, {8,7}, {7,6}};
	static String zz[];
	
	public static int[] solution(int [][] paths) {
		int zzz = zz.length;
		int answer[] = {};
		List<String> list = new ArrayList<>();
		bfs();
		String aa = "sdf asdf";
		tokens = new StringTokenizer(aa);
		while(tokens.hasMoreTokens()) {
			System.out.println(tokens.nextToken());
		}
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<map.size(); i++) {
			
		}
		Set<String> set = new HashSet<>();
		return answer;
	}
	
	
	
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		
	}



	public static void main(String[] args) {
		solution(paths);
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
}
