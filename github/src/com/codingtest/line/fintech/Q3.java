package com.codingtest.line.fintech;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q3 {
    static int n = 5, k=16;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n,k)));
    }

    static int distance[][], N;
    static boolean isVisited[][];
    static Node startNode;
    public static int[] solution(int n, int k) {
        distance = new int[n][n];
        isVisited = new boolean[n][n];

        N = n;

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                distance[r][c] = Integer.MAX_VALUE;
            }
        }

        startNode = new Node(0,0,0);
        distance[0][0] = 0;
        for(int i=0; i<k-1; i++){
            fillDistance(startNode.r, startNode.c);

            findStartNode();
        }
        int[] answer = new int[2];
        answer[0] = startNode.r+1;
        answer[1] = startNode.c+1;


        return answer;
    }

    private static void fillDistance(int r, int c) {
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                isVisited[i][j] = false;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r,c,0));
        isVisited[r][c] = true;
        distance[r][c] = 0;

        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(distance[front.r][front.c] > front.d){
                distance[front.r][front.c] = front.d;
            }
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];
                if(isIn(nr,nc) && !isVisited[nr][nc]){
                    isVisited[nr][nc] = true;
                    queue.offer(new Node(nr, nc,front.d+1));
                }
            }
        }

    }

    private static void findStartNode() {
        int max = 0;
        for(int c=0; c<N; c++){
            for(int r=0; r<N; r++){
                if(distance[r][c] > max){
                    max = distance[r][c];
                    startNode.r = r;
                    startNode.c = c;
                    startNode.d = 0;
                }
            }
        }
    }

    static class Node{
        int r;
        int c;
        int d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static boolean isIn(int r, int c){
        return(r>=0 && c>=0 && r<N && c<N);
    }
}
