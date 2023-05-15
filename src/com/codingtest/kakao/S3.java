package com.codingtest.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S3 {
	static int N = 4, max = 0, sum = 0, end = 0;
	static int value[] = {2,1,2,2};
	static int map[][] = {
			{1,2},{1,3},{2,4}
	};
	
	static List<Integer> list[];
	static boolean isVisited[];
	
	public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {};
        N = n;
        passenger = value;
        train = map;
        
        list = new List[N+1];
        isVisited = new boolean[N+1];
        for(int i=1; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
        
        for(int i=0; i<train.length; i++) {
        	int from = train[i][0];
        	int to = train[i][1];
        	
        	list[from].add(to);
        	list[to].add(from);
        }
        sum = value[0];
        dfs(1);
        System.out.println(max);
        System.out.println(end);
        return answer;
    }

	private static void dfs(int node) {
		isVisited[node] = true;
		
		if(sum >= max) {
			max = sum;
			if(node > end) {
				end = node;
			}
		}
		
		List<Integer> childs = list[node];
		for(int i=0; i<childs.size(); i++) {
			Integer child = childs.get(i);
			if(!isVisited[child]) {
				sum = sum + value[child-1];
				dfs(child);
				sum = sum - value[child-1];
			}
		}
		
	}

	public static void main(String[] args) {
		solution(N, value, map);
	}
}
