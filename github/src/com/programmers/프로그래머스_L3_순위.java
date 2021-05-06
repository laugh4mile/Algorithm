package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프로그래머스_L3_순위 {
	static List<Integer> list1[];
    static List<Integer> list2[];
    static boolean isVisited[];
    static int sum[];
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        list1 = new List[n+1];
        list2 = new List[n+1];
        sum = new int[n+1];
        
        for(int i=0; i<n+1; i++){
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }
        
        for(int i=0; i<results.length; i++){
            list1[results[i][0]].add(results[i][1]);
            list2[results[i][1]].add(results[i][0]);
        }
        
        for(int i=1; i<n+1; i++){
            isVisited = new boolean[n+1];
            bfs(i, list1);
            isVisited = new boolean[n+1];
            bfs(i, list2);
            if(sum[i] == n-1){
                answer++;
            }
        }
        return answer;
    }
    static void bfs(int num, List<Integer> list[]){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        isVisited[num] = true;
        int cnt = 0;
        
        while(!queue.isEmpty()){
            Integer front = queue.poll();
            List<Integer> childs = list[front];
            for(int i=0; i<childs.size(); i++){
                Integer child = childs.get(i);
                if(!isVisited[child]){
                    queue.offer(child);
                    isVisited[child] = true;
                    cnt++;
                }
            }
        }
        sum[num] += cnt;
    }
}
