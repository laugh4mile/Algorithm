package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G5_5972_택배배송_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static List<Node> graph[];
    static int distance[];
    static boolean isVisited[];
    static StringTokenizer tokens;
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        graph = new List[N+1];
        distance = new int[N+1];
        isVisited = new boolean[N+1];
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<M; i++){
            tokens = new StringTokenizer(input.readLine());
            int A = Integer.parseInt(tokens.nextToken());
            int B = Integer.parseInt(tokens.nextToken());
            int C = Integer.parseInt(tokens.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }
        dijkstra(1);
        System.out.println(Arrays.toString(distance));
        System.out.println(distance[N]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        distance[start] = 0;
        while(!pq.isEmpty()){
            Node front = pq.poll();
            if(isVisited[front.dest]) continue;
            isVisited[front.dest] = true;
            List<Node> childs = graph[front.dest];
            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);
                if(!isVisited[child.dest] && distance[child.dest] > distance[front.dest] + child.v){
                    distance[child.dest] = distance[front.dest] + child.v;
                    pq.offer(new Node(child.dest, distance[child.dest]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int dest;
        int v;

        public Node(int dest, int v){
            this.dest = dest;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.v, o.v);
        }
    }
    static String src =
            "6 8\n" +
            "4 5 3\n" +
            "2 4 0\n" +
            "4 1 4\n" +
            "2 1 1\n" +
            "5 6 1\n" +
            "3 6 2\n" +
            "3 2 6\n" +
            "3 4 4";
}
