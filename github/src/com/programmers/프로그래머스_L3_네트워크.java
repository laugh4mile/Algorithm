package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프로그래머스_L3_네트워크 {
	public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisited = new boolean[n];
        for(int i=0; i<computers.length; i++){
            if(!isVisited[i]){
                answer++;
                dfs(computers, isVisited, i);
            }
                
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, boolean [] isVisited, int start){
        isVisited[start] = true;
        for(int i=0; i<computers.length; i++){
            if(!isVisited[i] && computers[start][i] == 1){
                dfs(computers, isVisited, i);
            }
        }
    }
}
