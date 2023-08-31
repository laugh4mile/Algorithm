package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_S1_1325_효율적인해킹 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static List<Integer> graph[];
    static int N,M, childs[];
    static boolean isVisited[];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        graph = new List[N+1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        childs = new int[N+1];
        isVisited = new boolean[N+1];
        for(int i=0; i<M; i++){
            tokens = new StringTokenizer(input.readLine());
            int A = Integer.parseInt(tokens.nextToken());
            int B = Integer.parseInt(tokens.nextToken());
            graph[A].add(B);
        }
        for(int i=1; i<=N; i++){
            bfs(i);
        }

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int front = queue.poll();
            List<Integer> childs = graph[front];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(child);
                }
            }
        }
    }

    private static class Node {
        int dest;
        int v;
        public Node(int dest, int v){
            this.dest = dest;
            this.v = v;
        }
    }

    static String src =
            "5 4\n" +
            "3 1\n" +
            "3 2\n" +
            "4 3\n" +
            "5 3";
}
