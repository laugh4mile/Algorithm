package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G3_1937_욕심쟁이판다 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, map[][], distance[][], answer;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        map = new int[N][N];
        distance = new int[N][N];

        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
                pq.offer(new Node(r,c,map[r][c]));
            }
        }

        bfs();

//        for(int x[]: distance){
//            System.out.println(Arrays.toString(x));
//        }

        System.out.println(answer);
    }

    private static void bfs() {
        while(!pq.isEmpty()){
            Node front = pq.poll();
            if(distance[front.r][front.c] + 1 > answer){
                answer = distance[front.r][front.c] + 1;
            }

            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc) && map[nr][nc] > map[front.r][front.c] && distance[front.r][front.c]+1 > distance[nr][nc]){
                    distance[nr][nc] = distance[front.r][front.c] + 1;
                }
            }
        }
    }

    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    static class Node implements Comparable<Node>{
        int r;
        int c;
        int v;

        public Node(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.v, o.v);
        }
    }

    static String src =
            "4\n" +
            "1 9 12 10\n" +
            "2 4 5 4\n" +
            "7 3 2 13\n" +
            "1 2 16 8";
}
