package com.programmers;

public class L3_네트워크 {
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
