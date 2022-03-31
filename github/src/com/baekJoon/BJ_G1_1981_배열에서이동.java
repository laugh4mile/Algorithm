package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G1_1981_배열에서이동 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, map[][];
    static boolean isVisited[][];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        int left = 0;
        int right = 0;
        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
                if(map[r][c] > right){
                    right = map[r][c];
                }
            }
        }
        int answer = 0;
        int mid = 0;
        while(left <= right){
            mid = (right + left) / 2;
            if(bfs(mid)){
                right = mid-1;
                answer = mid;
            }else{
                left = mid+1;
            }
        }
        System.out.println(answer);
    }

    private static boolean bfs(int mid) {
        isVisited = new boolean[N][N];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0,0, Math.min(map[0][0], map[N-1][N-1]), Math.max(map[0][0], map[N-1][N-1])));
        isVisited[0][0] = true;

        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(front.r == N-1 && front.c == N-1){
                return true;
            }

            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc) && !isVisited[nr][nc]){
                    int max = front.max;
                    int min = front.min;
                    if(map[nr][nc] > front.max){
                        max = map[nr][nc];
                    }
                    if(map[nr][nc] < front.min){
                        min = map[nr][nc];
                    }
                    if(max - min <= mid){
                        isVisited[nr][nc] = true;
                        queue.offer(new Node(nr,nc,min, max));
                    }
                }
            }
        }
        return false;
    }

    static class Node implements Comparable<Node>{
        int r;
        int c;
        int min;
        int max;

        public Node(int r, int c, int min, int max) {
            this.r = r;
            this.c = c;
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", min=" + min +
                    ", max=" + max +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.max-this.min, o.max-o.min);
        }
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    static String src =
            "5\n" +
                    "1 1 3 6 8\n" +
                    "1 2 2 5 5\n" +
                    "4 4 0 3 3\n" +
                    "8 0 2 3 4\n" +
                    "4 3 0 2 1";
}
