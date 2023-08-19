package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_11909_배열탈출 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static StringTokenizer tokens;
     static int N, map[][], distance[][];
     public static void main(String[] args) throws Exception{
         input = new BufferedReader(new StringReader(src));
         N = Integer.parseInt(input.readLine());
         map = new int[N][N];
         distance = new int[N][N];

         for(int r=0; r<N; r++){
             tokens = new StringTokenizer(input.readLine());
             for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
                distance[r][c] = Integer.MAX_VALUE;
             }
         }
         dijkstra(0,0);
     }

    private static void dijkstra(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r,c));
        distance[r][c] = 0;

        while (!queue.isEmpty()){
            Node front = queue.poll();

            for(int d=0; d<2; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc)){
                    int val = 0;
                    if(map[front.r][front.c] <= map[nr][nc]){
                        val = map[nr][nc] - map[front.r][front.c] + 1;
                    }

                    if(distance[nr][nc] > distance[front.r][front.c] + val){
                        distance[nr][nc] = distance[front.r][front.c] + val;
                        queue.offer(new Node(nr,nc));
                    }
                }
            }
        }
        System.out.println(distance[N-1][N-1]);
    }
    static int dr[] = {0,1};
    static int dc[] = {1,0};

    static class Node {
         int r;
         int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static boolean isIn(int r, int c){
         return (r>=0 && c>=0 && r<N && c<N);
     }

    static String src =
         "5\n" +
                 "1 1 1 1 1\n" +
                 "1 1 1 1 1\n" +
                 "1 1 1 1 1\n" +
                 "1 1 1 1 1\n" +
                 "1 1 1 1 1";
}
