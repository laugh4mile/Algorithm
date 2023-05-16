package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_G1_1035_조각움직이기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N=5, totalPiece, temp[][], minMove = Integer.MAX_VALUE;
    static char origin[][];
    static boolean isVisited[][], isOccupied[][];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        origin = new char[N][N];
        temp = new int[N][N];

        for(int r=0; r<N; r++){
            String line = input.readLine();
            for(int c=0; c<N; c++){
                origin[r][c] = line.charAt(c);
                if(origin[r][c] == '*'){
                    totalPiece++;
                }
            }
        }
        dfs(0, 0);

        System.out.println(minMove);
    }

    private static void dfs(int idx, int count) {
        if(count == totalPiece){
            checkLinked();
            return;
        }
        if(idx >= N*N){
            return;
        }
        int r = idx / N;
        int c = idx % N;

        temp[r][c] = 1;
        dfs(idx+1, count+1);
        temp[r][c] = 0;
        dfs(idx+1, count);
    }

    private static void checkLinked() {
        int sr = 0, sc = 0;
        outer : for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(temp[r][c] == 1){
                    sr = r;
                    sc = c;
                    break outer;
                }
            }
        }

        int cnt = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sr, sc));
        isVisited = new boolean[N][N];
        isVisited[sr][sc] = true;
        while(!queue.isEmpty()){
            Node front = queue.poll();
            cnt++;
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc) && !isVisited[nr][nc] && temp[nr][nc] == 1){
                    queue.offer(new Node(nr, nc));
                    isVisited[nr][nc] = true;
                }
            }
        }

        if(cnt == totalPiece){
            int move = getMinMove();
            if(minMove > move){
                minMove = move;
            }
        }
    }

    private static int getMinMove() {
        isOccupied = new boolean[N][N];
        int sum = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(origin[r][c] == '*'){
                    sum += getDist(r, c);
                    if(sum >= minMove){
                        return Integer.MAX_VALUE;
                    }
                }
            }
        }
        return sum;
    }

    private static int getDist(int r, int c) {
        isVisited = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c, 0));
        isVisited[r][c] = true;
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            if(temp[front.r][front.c] == 1 && !isOccupied[front.r][front.c]){
                isOccupied[front.r][front.c] = true;
                return front.d;
            }

            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr, nc) && !isVisited[nr][nc] && !isOccupied[nr][nc]){
                    queue.offer(new Node(nr, nc, front.d+1));
                    isVisited[nr][nc] = true;
                }
            }
        }

        return 111111;
    }

    static class Node{
        int r;
        int c;
        int d;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};
    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    static String src =
            ".....\n" +
                    ".....\n" +
                    ".**..\n" +
                    ".*...\n" +
                    "**...";
}
