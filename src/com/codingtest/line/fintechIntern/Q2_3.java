package com.codingtest.line.fintechIntern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q2_3 {
    static int[] x = {1, 2, 6, 8};
    static int[] y = {1, 2, 5, 7};
    static int[] x2 = {1, 2, 4, 2};
    static int[] y2 = {1, 1, 4, 2};
    static int[] x3 = {1, 9, 5, 8, 4};
    static int[] y3 = {1, 5, 3, 1, 7};
    public static void main(String[] args) {
        System.out.println(solution(x3, y3));
    }

    static List<Integer> graph[];
    static boolean isVisited[];

    public static int solution(int[] x, int[] y) {
        int answer = 0;
        N = x.length; // 섬의 개수
        int distance[] = new int[N];
        isVisited = new boolean[N];
        graph = new List[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            graph[x[i]].add(y[i]);
            graph[y[i]].add(x[i]);
        }

        for(int i=0; i<N; i++){
            bfs(i);
        }
        return answer;
    }
    static int N;
    private static void bfs(int startNode) {
        isVisited = new boolean[N];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startNode,0));

        while(!queue.isEmpty()){
            Node front = queue.poll();
        }
    }

    static class Node{
        int node;
        int v;

        public Node(int node, int v) {
            this.node = node;
            this.v = v;
        }
    }
}
