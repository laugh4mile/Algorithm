package com.cordingtest.kakao.채용연계형인턴십;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프로그래밍4 {
//	static int n = 3;
//	static int start = 1;
//	static int end = 3;
//	static int[][] roads = {{1, 2, 2},{3, 2, 3}};
//	static int[] traps = {2};
	static int n = 4;
	static int start = 1;
	static int end = 4;
	static int[][] roads = {{1, 2, 1},{3, 2, 1},{2,4,1}};
	static int[] traps = {2,3};
	
	static boolean isVisited[][];
	static List<Node> graph[];
	static List<Node> graph2[];
	static int min = Integer.MAX_VALUE;
	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        graph = new List[n+1];
        graph2 = new List[n+1];
        isVisited = new boolean[n+1][2];
        for(int i=0; i<n+1; i++) {
        	graph[i] = new ArrayList<>();
        	graph2[i] = new ArrayList<>();
        }
        
        for(int i=0; i<roads.length; i++) {
        	graph[roads[i][0]].add(new Node(roads[i][1], roads[i][2]));
        	graph2[roads[i][1]].add(new Node(roads[i][0], roads[i][2]));
        }
        
//        answer = bfs(start,end, traps);
        dfs(start,end, traps, 0, 0);
        System.out.println(min);
        answer = min;
//        for(List<Node> x : graph) {
//        	System.out.println(x);
//        }
//        for(List<Node> x : graph2) {
//        	System.out.println(x);
//        }
        
        return answer;
    }
	
	private static void dfs(int node, int end, int[] traps, int dir, int sum) {
		System.out.println(node);
		if(min < sum) {
			return;
		}
		if(node == end) {
			if(min > sum) {
				min = sum;
			}
		}
		isVisited[node][dir] = true;
		for(int i=0; i<traps.length; i++) {
			if(traps[i] == node) {
				if(dir == 0) {
					dir = 1;
				}else {
					dir = 0;
				}
				break;
			}
		}
		if(dir == 0) { // 정방향
			List<Node> childs = graph[node];
			for(int i=0; i<childs.size(); i++) {
				Node child = childs.get(i);
				if(!isVisited[child.point][dir]) {
					dfs(child.point, end, traps, dir, sum+child.value);
				}
			}
		}else { // 역방향
			List<Node> childs = graph2[node];
			for(int i=0; i<childs.size(); i++) {
				Node child = childs.get(i);
				if(!isVisited[child.point][dir]) {
					dfs(child.point, end, traps, dir, sum+child.value);
				}
			}
		}
		
	}

	private static int bfs(int start, int end, int[] traps) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start][0] = true;
		boolean dir = false; // false : 정방향 , true : 역방향
		int sum = 0;
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			System.out.println(front);
			if(front == end) {
				if(min > sum) {
					min = sum;
				}
			}
			
			for(int i=0; i<traps.length; i++) {
				if(traps[i] == front) {
					dir = !dir;
					break;
				}
			}
			
			
			if(!dir) {
				List<Node> childs = graph[front];
				for(int i=0; i<childs.size(); i++) {
					Node child = childs.get(i);
					if(!isVisited[child.point][0]) {
						queue.offer(child.point);
						isVisited[child.point][0] = true;
						sum += child.value;
					}
				}
			}else {
				List<Node> childs = graph2[front];
				for(int i=0; i<childs.size(); i++) {
					Node child = childs.get(i);
					if(!isVisited[child.point][1]) {
						queue.offer(child.point);
						isVisited[child.point][1] = true;
						sum += child.value;
					}
				}
			}
		}
		return sum;
	}

	static class Node{
		int point;
		int value;
		public Node(int point, int value) {
			super();
			this.point = point;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Node [point=" + point + ", value=" + value + "]";
		}
	}
	
	public static void main(String[] args) {
		solution(n, start, end, roads, traps);
	}
}
