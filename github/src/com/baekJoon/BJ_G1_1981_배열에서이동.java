package com.baekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
        int left = Integer.MAX_VALUE;
        int right = 0;
        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
                if(map[r][c] < left){
                    left = map[r][c];
                }
                if(map[r][c] > right){
                    right = map[r][c];
                }
            }
        }

        int mid = 0;
        while(left < right){
            System.out.println(left +"  " + right);
            mid = (right - left) / 2;

            if(bfs(mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

    }

    private static boolean bfs(int mid) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0, Integer.MAX_VALUE, 0));
        isVisited[0][0] = true;
        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(map[front.r][front.c] > front.max){
                front.max = map[front.r][front.c];
            }
            if(map[front.r][front.c] < front.min){
                front.min = map[front.r][front.c];
            }
            if(front.max - front.min <= mid){
                if(front.r == N-1 && front.c == N-1){
                    return true;
                }
            }else{
                continue;
            }

            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc) && !isVisited[nr][nc]){
                    isVisited[nr][nc] = true;
                    queue.offer(new Node(nr,nc,front.min, front.max));
                }
            }
        }
        return false;
    }

    static class Node{
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
