package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_1707_이분그래프 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static StringTokenizer tokens;
	static int T,V,E, team[];
	static boolean flag;
	static List<Integer> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			V = Integer.parseInt(tokens.nextToken());
			E = Integer.parseInt(tokens.nextToken());
			team = new int[V+1];
			list = new List[V+1];
			for(int i=1; i<V+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int e=0; e<E; e++) {
				tokens = new StringTokenizer(input.readLine());
				int start = Integer.parseInt(tokens.nextToken());
				int end = Integer.parseInt(tokens.nextToken());
				list[start].add(end);
				list[end].add(start);
			}
			flag = false;
			for(int i=1; i<=V; i++) {
				if(team[i] == 0) {
					bfs(i);
				}
			}
			if(flag) {
				output.append("NO\n");
			}else {
				output.append("YES\n");
			}
		}
		output.close();
	}

	private static void bfs(int index) throws IOException {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(index, 1));
		team[index] = 1;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			List<Integer> childs = list[front.num];
			for(int i=0; i<childs.size(); i++) {
				Integer child = childs.get(i);
				if(team[child] == 0) { // 아직 팀이 안정해져 있다?
					team[child] = front.team * -1; // front의 반대팀
					queue.offer(new Node(child, front.team*-1));
				}else { // 팀이 정해져 있다?
					if(team[child] != front.team*-1) { // front의 반대팀이 아니면 이분그래프가 아니다
						flag = true;
						return;
					}
				}
			}
		}
	}
	
	static class Node{
		int num;
		int team;
		public Node(int num, int team) {
			super();
			this.num = num;
			this.team = team;
		}
	}

	static String src =
			"2\r\n" + 
			"3 2\r\n" + 
			"1 3\r\n" + 
			"2 3\r\n" + 
			"4 4\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"3 4\r\n" + 
			"4 2";
}
