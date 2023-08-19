package com.programmers;

import java.util.*;

public class L2_배달 {

    static List<Node> graph[];
    static int shortestPath[];
    static boolean isVisited[];
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new List[N+1];
        isVisited = new boolean[N+1];
        shortestPath = new int[N+1];
        for(int i=1; i<=N; i++){
            shortestPath[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int val = road[i][2];
            graph[from].add(new Node(to, val));
            graph[to].add(new Node(from, val));
        }
        dijkstra(1);
        System.out.println(Arrays.toString(shortestPath));
        for(int i=1; i<N+1; i++){
            if(shortestPath[i]<=K) answer++;
        }
        return answer;
    }

    private static void dijkstra(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        shortestPath[start] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(!isVisited[cur]){
                isVisited[cur] = true;
                List<Node> childs = graph[cur];
                for(int i=0; i<childs.size(); i++){
                    Node child = childs.get(i);
                    if(shortestPath[child.node] > shortestPath[cur] + child.val){
                        shortestPath[child.node] = shortestPath[cur] + child.val;
                        queue.offer(child.node);
                    }
                }
            }
        }

    }

    static class Node{
        int node;
        int val;

        public Node(int node, int val){
            this.node = node;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] road ={{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        int[][] road2 ={{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        System.out.println(solution(N,road,K));
        System.out.println(solution(6,road2,4));
    }
}
