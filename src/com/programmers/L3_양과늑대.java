package com.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L3_양과늑대 {
    public static int solution(int[] info, int[][] edges) {
        int answer = 0;

        List[] graph = new List[info.length];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Node>();
        }

        for(int i=0; i<edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];

            graph[from].add(new Node(from, to));
        }
//        for(int i=0; i< graph.length; i++){
//            System.out.println(graph[i]);
//        }

        boolean isVisited[] = new boolean[info.length];
        isVisited[0] = true;
        dfs(graph, isVisited, info, 1, 0);

        answer = max;
        return answer;
    }

    static int max = 0;

    private static void dfs(List[] graph, boolean[] isVisited, int[] info, int sheep, int wolf) {
        if(sheep > max){
            max = sheep;
        }
        for(int i=0; i<isVisited.length; i++){
            if(isVisited[i]){ // 방문한 노드의
                ArrayList<Node> childs = (ArrayList<Node>) graph[i];
                for(int j=0; j<childs.size(); j++){
                    if(!isVisited[childs.get(j).to]){ // 방문안한 자식노드들을 조회해서
                        if(info[childs.get(j).to] == 0){ // 양이 있다면
                            isVisited[childs.get(j).to] = true; // 방문체크하고
                            dfs(graph, isVisited, info, sheep+1, wolf); // 탐색
                            isVisited[childs.get(j).to] = false; // 방문체크 해제
                        }else{ // 늑대가 있다면
                            if(sheep > wolf+1){ // 그래도 양의 수가 더 많을때만
                                isVisited[childs.get(j).to] = true; // 방문체크하고
                                dfs(graph, isVisited, info, sheep, wolf+1); // 탐색
                                isVisited[childs.get(j).to] = false; // 방문체크 해제
                            }
                        }
                    }
                }
            }
        }
    }

    static class Node{
        int from;
        int to;

        public Node(int from, int to){
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1}, {1,2}, {1,4}, {0,8}, {8,7}, {9,10}, {9,11}, {4,3}, {6,5}, {4,6}, {8,9}};
        System.out.println(solution(info, edges));
    }
}
