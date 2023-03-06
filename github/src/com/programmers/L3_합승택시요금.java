package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class L3_합승택시요금 {
    static List<Node> graph[];
    static int distance[][];
    static boolean isVisited[];
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        graph = new List[n+1];
        distance = new int[n+1][n+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<fares.length; i++){
            graph[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
            graph[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
        }

        for(int i=1; i<n+1; i++){
            isVisited = new boolean[n+1];
            getDistance(i);
        }

        answer = distance[s][a] + distance[s][b];

        for(int i=1; i<n+1; i++){
            if(answer > distance[s][i] + distance[i][a] + distance[i][b]){
                answer = distance[s][i] + distance[i][a] + distance[i][b];
            }
        }

        return answer;
    }

    private static void getDistance(int start) {
        distance[start][start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node front = pq.poll();
            List<Node> childs = graph[front.node];
            if(distance[start][front.node] < front.val) continue;
            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);
                if(distance[start][child.node] > distance[start][front.node] + child.val){
                    distance[start][child.node] = distance[start][front.node] + child.val;
                    pq.offer(child);
                }
            }
        }

    }

    static class Node implements Comparable<Node>{
        int node;
        int val;

        public Node(int node, int val){
            this.node = node;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.val, o.val);
        }
    }

    public static void main(String[] args) {
        int n=6;
        int s=4;
        int a=6;
        int b=2;
        int[][] fares = {{4, 1, 10},{3, 5, 24},{5, 6, 2},{3, 1, 41},{5, 1, 24},{4, 6, 50},{2, 4, 66},{2, 3, 22},{1, 6, 25}};
        System.out.println(solution(n,s,a,b,fares));
    }
}
