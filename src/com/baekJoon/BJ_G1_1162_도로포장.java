package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G1_1162_도로포장 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, M, K, dist[][];
    static List<Node> graph[];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        graph = new List[N+1];
        dist = new int[N+1][K+1];
        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
            for(int j=1; j<K+1; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
            dist[i][0] = 0;
        }
        for(int i=0; i<M; i++){
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            int time = Integer.parseInt(tokens.nextToken());
            graph[from].add(new Node(to, time));
            graph[to].add(new Node(from, time));
        }

        dijkstra(1);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node front = pq.poll();
            List<Node> childs = graph[front.destCity];
            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);
                if(dist[child.destCity][0] > dist[front.destCity][0] + child.time){
                    dist[child.destCity][0] = dist[front.destCity][0] + child.time;
                    pq.offer(child);
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int destCity;
        int time;

        public Node(int destCity, int time){
            this.destCity = destCity;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.time, o.time);
        }
    }
    static String src =
            "4 4 1\n" +
            "1 2 10\n" +
            "2 4 10\n" +
            "1 3 1\n" +
            "3 4 100";
}
