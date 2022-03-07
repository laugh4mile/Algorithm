package com.baekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_16954_움직이는미로탈출 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N = 8, answer;
    static char[][] map = new char[N][N];
    static int isVisited[][] = new int[N][N];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        for(int r=0; r<8; r++){
            String line = input.readLine();
            for(int c=0; c<8; c++){
                map[r][c] = line.charAt(c);
            }
        }
        bfs(7,0);
        System.out.println(answer);
    }

    private static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        isVisited[r][c] = 1;
        queue.offer(new Node(r,c,0));
        while(!queue.isEmpty()){
            Node front = queue.poll();
//            System.out.println(front);
            if(front.r == 0 && front.c == N-1){
                answer = 1;
                return;
            }
            if(isVisited[front.r][front.c] > 2){
                continue;
            }
            for(int d=0; d<9; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];
                if(isIn(nr,nc) && isVisited[nr][nc] < 2 && checkMap(nr,nc,front.t) == '.' && checkMap(nr,nc,front.t+1) == '.'){
                    isVisited[nr][nc]++;
                    queue.offer(new Node(nr,nc,front.t+1));
                    map[nr][nc]++;
                }
            }
        }
    }

    private static char checkMap(int r, int c, int t) { // t초가 지난 후 좌표의 값 map[r][c]
        if(r-t>=0){
            return map[r-t][c];
        }else{
            return '.';
        }
    }

    static int dr[] = {0,-1,-1,-1,0,1,1,1,0};
    static int dc[] = {0,-1,0,1,1,1,0,-1,-1};
    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }
    static class Node{
        int r;
        int c;
        int t;

        public Node(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", t=" + t +
                    '}';
        }
    }
    static String src =
            "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "#.......\n" +
                    ".#######\n" +
                    "#.......\n" +
                    "........";
}
