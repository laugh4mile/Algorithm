package com.codingtest.sk.skt.first;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q2 {

    static int n = 5;
    static boolean clockwise = true;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n,clockwise)));
    }
    static int N, map[][];
    static boolean isVisited[][];
    public static  int[][] solution(int n, boolean clockwise) {
        N = n;
        map = new int [N][N];
        isVisited = new boolean[N][N];
        bfs();


        return map;
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0, 1,3));
        isVisited[0][0] = true;
        map[0][0] = 1;

        queue.offer(new Node(0,N-1, 1,1));
        isVisited[0][N-1] = true;
        map[0][N-1] = 1;

        queue.offer(new Node(N-1,N-1,1,2));
        isVisited[N-1][N-1] = true;
        map[N-1][N-1] = 1;

        queue.offer(new Node(N-1,0, 1,0));
        isVisited[N-1][0] = true;
        map[N-1][N-1] = 1;

        while(!queue.isEmpty()){
            Node front = queue.poll();
            System.out.println(front);
            map[front.r][front.c] = front.v;

            if(front.d == 0){ // 상
                int nr = front.r+dr[0];
                int nc = front.c+dc[0];

                if(isIn(nr, nc) && !isVisited[nr][nc]){
                    queue.offer(new Node(nr,nc, front.c+1, front.d));
                    isVisited[nr][nc] = true;
                }else{
                    queue.offer(new Node(front.r, front.c, front.c+1, 3));
                    isVisited[nr][nc] = true;
                }
            }else if (front.d == 1){ // 하
                int nr = front.r+dr[1];
                int nc = front.c+dc[1];

                if(isIn(nr, nc) && !isVisited[nr][nc]){
                    queue.offer(new Node(nr,nc, front.c+1, front.d));
                    isVisited[nr][nc] = true;
                }else{
                    queue.offer(new Node(front.r, front.c, front.c+1, 2));
                    isVisited[nr][nc] = true;
                }
            }else if (front.d == 2){ // 좌
                int nr = front.r+dr[2];
                int nc = front.c+dc[2];

                if(isIn(nr, nc) && !isVisited[nr][nc]){
                    queue.offer(new Node(nr,nc, front.c+1, front.d));
                    isVisited[nr][nc] = true;
                }else{
                    queue.offer(new Node(front.r, front.c, front.c+1, 0));
                    isVisited[nr][nc] = true;
                }
            }else{ // 우
                int nr = front.r+dr[3];
                int nc = front.c+dc[3];

                if(isIn(nr, nc) && !isVisited[nr][nc]){
                    queue.offer(new Node(nr,nc, front.c+1, front.d));
                    isVisited[nr][nc] = true;
                }else{
                    queue.offer(new Node(front.r, front.c, front.c+1, 1));
                    isVisited[nr][nc] = true;
                }
            }
        }

    }

    static int dr[] = {-1,1,0,0}; // 상하좌우
    static int dc[] = {0,0,-1,1};

    static class Node{
        int r;
        int c;
        int v;
        int d;

        public Node(int r, int c, int v, int d) {
            this.r = r;
            this.c = c;
            this.v = v;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", v=" + v +
                    ", d=" + d +
                    '}';
        }
    }

    static boolean isIn(int r, int c){
        return(r>=0 && c>=0 && r<N && c<N);
    }
}
