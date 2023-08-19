package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G1_1162_도로포장 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, M, K;
    static long distance[][];
    static List<Node> graph[];
    static boolean isVisited[][];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        graph = new List[N+1];
        distance = new long[K+2][N+1];
        isVisited = new boolean[K+2][N+1];
//        for(int i=0;)
        for(int c=0; c<N+1; c++){
            graph[c] = new ArrayList<>();
            for(int r=0; r<K+2; r++){
                distance[r][c] = Long.MAX_VALUE;
            }
        }
//        for(int x[] : distance){
//            System.out.println(Arrays.toString(x));
//        }
//        System.out.println();

        for(int i=0; i<M; i++){
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            int time = Integer.parseInt(tokens.nextToken());
            graph[from].add(new Node(to, time));
            graph[to].add(new Node(from, time));
        }

        for(int t=1; t<K+2; t++){
            distance[t][1] = 0;
            dijkstra(1, t);
        }
//        for(int x[] : distance){
//            System.out.println(Arrays.toString(x));
//        }
        System.out.println(distance[K+1][N]);
    }

    private static void dijkstra(int start, int t) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node front = pq.poll();
            if(isVisited[t][front.destCity]) continue;
            isVisited[t][front.destCity] = true;
            List<Node> childs = graph[front.destCity];
            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);
                long temp = Math.min(distance[t][front.destCity] + child.time, distance[t-1][front.destCity]);
                if(!isVisited[t][child.destCity] && distance[t][child.destCity] > temp){
                    distance[t][child.destCity] = temp;
                    pq.offer(new Node(child.destCity, distance[t][child.destCity]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int destCity;
        long time;

        public Node(int destCity, long time){
            this.destCity = destCity;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            return Long.compare(this.time, o.time);
        }
    }
    static String src =
            "4 4 1\n" +
            "1 2 10\n" +
            "2 4 10\n" +
            "1 3 1\n" +
            "3 4 100";
}
