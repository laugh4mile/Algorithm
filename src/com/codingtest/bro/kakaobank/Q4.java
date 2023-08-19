package com.codingtest.bro.kakaobank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Q4 {
	static int[] T = {5,8,3,7,10,5,4};
	static int[][] R = {{1,2},{2,4},{1,4},{6,5},{3,5},{4,6}};
	static int k = 5;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer;
		answer = solution(T, R, k);
		System.out.println(answer);
	}

	static List<Integer> graph[];
	static int N; 
	static boolean isExecuted[];
	static int min = 0;
	private static int solution(int[] T, int[][] R, int k) {
		int answer = 0;
		N = T.length;
		graph = new List[N+1];
		isExecuted = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<R.length; i++) {
			graph[R[i][1]].add(R[i][0]);
		}
		dfs(k,T[k-1]);
		answer = min;
		return answer;
	}
	
	private static void dfs(int cur, int sum) {
		if(sum > min) {
			min = sum;
		}
		List<Integer> childs = graph[cur];
		for(int i=0; i<childs.size(); i++) {
			int child = childs.get(i);
			if(!isExecuted[child]) {
				isExecuted[child] = true;
				dfs(child, sum+T[child-1]);
				isExecuted[child] = false;
			}
		}
	}
}
