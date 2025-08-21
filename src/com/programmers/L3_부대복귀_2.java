package com.programmers;
import java.util.*;

public class L3_부대복귀_2 {

    static List[] graph;
    static int[] result;
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        graph = new List[n+1];
        result = new int[n+1];
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<roads.length; i++){
            int from = roads[i][0];
            int to   = roads[i][1];

            graph[from].add(to);
            graph[to].add(from);
        }

        dijkstra(destination);

        return answer;
    }

    private static void dijkstra(int start) {
        int min = -1;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        isVisited[start] = true;

        while(!pq.isEmpty()){
            Node front = pq.poll();
        }
    }

    static class Node implements Comparable<Node> {
        int area;
        int time;

        public Node(int area, int time){
            this.area = area;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.time, o.time);
        }
    }

    static boolean isVisited[];

    public static void main(String[] args) {
        int n = 5;
        int[][] road = {{1, 2},{1, 4},{2, 4},{2, 5},{4, 5}};
        int[] sources = {1,3,5};
        int destination = 5;

        int answer[] = solution(n, road, sources, destination);

        System.out.println(Arrays.toString(answer));
    }
}
