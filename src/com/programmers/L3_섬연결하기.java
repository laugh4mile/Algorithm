package com.programmers;

import java.util.*;

public class L3_섬연결하기 {
    static List<Node> graph[];
    static int distance[], answer;
    static boolean isVisited[];
    public static int solution(int n, int[][] costs) {
        graph = new List[n];
        distance = new int[n];
        isVisited = new boolean[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<costs.length; i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int val = costs[i][2];

            graph[from].add(new Node(to,val));
            graph[to].add(new Node(from,val));
        }

        for(int i=0; i<n; i++){
            if(!isVisited[i]){
                dijkstra(i);
            }
        }

        return answer;
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(!isVisited[cur.node]){
                answer+=cur.val;
                isVisited[cur.node] = true;
                List<Node> childs = graph[cur.node];
                for(int i=0; i<childs.size(); i++){
                    Node child = childs.get(i);
                    pq.offer(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(solution(n,costs));
    }

    static class Node implements Comparable<Node>{
        int node;
        int val;

        public Node (int node, int val){
            this.node = node;
            this.val = val;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.val, o.val);
        }
    }
}
