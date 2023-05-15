package com.programmers;

import java.util.*;

public class L2_전력망을둘로나누기 {
    static List<Integer> graph[];
    static boolean isVisited[];
    static int answer = Integer.MAX_VALUE, N;
    public static int solution(int n, int[][] wires) {
        N = n;
        isVisited = new boolean[n+1];
        graph = new List[n+1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<wires.length; i++){
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }

        for(int i=1; i<n+1; i++){
            Arrays.fill(isVisited, false);
            isVisited[i] = true;
            for(int j=1; j<n+1; j++){
                if(!isVisited[j]){
                    bfs(j);
                }
            }
        }

        return answer;
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[start] = true;
        queue.offer(start);
        int cnt = 0;

        while(!queue.isEmpty()){
            int front = queue.poll();
            cnt++;
            List<Integer> childs = graph[front];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(child);
                }
            }
        }
        if(answer > Math.abs(N - 2*cnt)){
            answer = Math.abs(N - 2*cnt);
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        int n2 = 9;
        int[][] wires2 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
//        System.out.println(solution(n, wires));
        System.out.println(solution(n2, wires2));
    }
}
