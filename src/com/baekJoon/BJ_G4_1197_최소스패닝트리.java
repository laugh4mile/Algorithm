package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_1197_최소스패닝트리 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int V,E;
    static boolean isVisited[];
    static List<Node> graph[];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        V = Integer.parseInt(tokens.nextToken());
        E = Integer.parseInt(tokens.nextToken());

        graph = new List[V+1];
        isVisited = new boolean[V+1];

        for(int i=0; i<V+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            tokens = new StringTokenizer(input.readLine());
            int A = Integer.parseInt(tokens.nextToken());
            int B = Integer.parseInt(tokens.nextToken());
            int C = Integer.parseInt(tokens.nextToken());
            graph[A].add(new Node(B,C));
            graph[B].add(new Node(A,C));
        }
        solve(1);
    }

    private static void solve(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int sum = 0;
        while(!pq.isEmpty()){
            Node front = pq.poll();
            if(!isVisited[front.dest]){
                isVisited[front.dest] = true;
                sum += front.v;
                List<Node> childs = graph[front.dest];
                for(int i=0; i<childs.size(); i++){
                    Node child = childs.get(i);
                    if(!isVisited[child.dest]){
                        pq.offer(child);
                    }
                }
            }
        }
        System.out.println(sum);
    }

    static class Node implements Comparable<Node>{
        int dest;
        int v;
        public Node(int dest, int v){
            this.dest = dest;
            this.v = v;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.v, o.v);
        }
    }

    static String src =
            "3 3\n" +
            "1 2 1\n" +
            "2 3 2\n" +
            "1 3 3";
}
