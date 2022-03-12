package com.codingtest.sk;

import java.util.ArrayList;
import java.util.List;

public class Q4_2 {
    static int n = 6;
    static int[][] edges = {{0,1},{0,2},{1,3},{1,4},{0,5}};
//    static int n = 4;
//    static int[][] edges = {{2,3},{0,1},{1,2}};
    public static void main(String[] args) {
        System.out.println(solution(n,edges));
    }

    static List<Integer>graph[];
    static boolean isVisited[];
    static long answer;
    public static long solution(int n, int[][] edges) {
        graph = new List[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            graph[from].add(to);
            graph[to].add(from);
        }

        for(int i=0; i<n; i++){
            isVisited = new boolean[n];
            isVisited[i] = true;
            dfs(i,1, 1); // i 번 노드를 고르고 시작.
        }

        return answer;
    }

    private static void dfs(int node, int depth, int selectCnt) {
        if(selectCnt >= 3){
            answer += depth-2;
            return;
        }
        List<Integer> childs = graph[node];
        for(int i=0; i<childs.size(); i++){
            int child = childs.get(i);
            if(!isVisited[child] && selectCnt < 3){
                isVisited[child] = true;
                dfs(child, depth+1, selectCnt+1); // 현재 노드를 선택할 경우
                dfs(child, depth+1, selectCnt); // 현재 노드를 선택하지 않을 경우
            }
        }
    }
}
