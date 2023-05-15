package com.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yhs
 * @date 2021. 4. 30
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 노드의 개수 n은 2 이상 20,000 이하입니다.
 * 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
 * vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
 * [입력사항]
 * 노드의 개수 n, 
 * 간선에 대한 정보가 담긴 2차원 배열 edge
 * [출력사항]
 */

public class L3_가장먼노드 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n = 6, depth=0;
	static int [][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
	static int distance[];
	static List<Integer> graph[];
	static boolean isVisited[];
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        isVisited = new boolean[n+1];
        distance = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<edge.length; i++) {
        	graph[edge[i][0]].add(edge[i][1]);
        	graph[edge[i][1]].add(edge[i][0]);
        }
//        for(List<Integer> x : graph) {
//        	System.out.println(x);
//        }
        
        bfs(1);
        
        Arrays.sort(distance);
//        System.out.println(Arrays.toString(distance));
        int max = distance[n];
        for(int i=0; i<= n; i++) {
        	if(distance[i] == max) {
        		answer++;
        	}
        }
        return answer;
    }
    
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			List<Integer> childs = graph[front];
			for(int i=0; i<childs.size(); i++) {
				Integer child = childs.get(i);
				if(!isVisited[child]) {
					queue.offer(child);
					isVisited[child] = true;
					distance[child] = distance[front]+1;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution(n, edge));
	}
}
