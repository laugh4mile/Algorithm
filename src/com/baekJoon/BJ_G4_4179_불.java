package com.baekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_4179_불 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int R, C;
    static char map[][];
    static boolean isVisited[][][];
    static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        map = new char[R][C];
        isVisited = new boolean[2][R][C];

        queue = new LinkedList<>();
        Queue<Node> fire = new LinkedList<>();
        for(int r=0; r<R; r++){
            String line = input.readLine();
            for(int c=0; c<C; c++){
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'J'){
                    queue.offer(new Node(r, c, 'J', 1));
                    isVisited[0][r][c] = true;
                }
                if(map[r][c] == 'F'){
                    fire.offer(new Node(r, c, 'F', 1));
                    isVisited[1][r][c] = true;
                }
            }
        }

        while (!fire.isEmpty()){
            queue.offer(fire.poll());
        }
        escape();
    }

    private static void escape() {
        while (!queue.isEmpty()) {
            Node front = queue.poll();

            if(front.JorF == 'J'){
                if(isVisited[1][front.r][front.c]) continue; // 불에 탐ㅜㅜ
                for(int d=0; d<4; d++){
                    int nr = front.r + dr[d];
                    int nc = front.c + dc[d];
                    if(!isIn(nr,nc)){
                        System.out.println(front.time);
                        return;
                    }

                    if(isIn(nr,nc) && !isVisited[0][nr][nc] && !isVisited[1][nr][nc] && map[nr][nc] == '.'){
                        isVisited[0][nr][nc] = true;
                        queue.offer(new Node(nr,nc, front.JorF, front.time+1));
                    }
                }
            }else{
                for(int d=0; d<4; d++){
                    int nr = front.r + dr[d];
                    int nc = front.c + dc[d];

                    if(isIn(nr,nc) && !isVisited[1][nr][nc] && map[nr][nc] != '#'){
                        isVisited[1][nr][nc] = true;
                        queue.offer(new Node(nr,nc, front.JorF, front.time+1));
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static class Node{
        int r;
        int c;
        char JorF;
        int time;

        public Node(int r, int c, char JorF, int time) {
            this.r = r;
            this.c = c;
            this.JorF = JorF;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", JorF=" + JorF +
                    ", time=" + time +
                    '}';
        }
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<R && c<C);
    }

    static String src =
            "4 4\n" +
                    "####\n" +
                    "#JF#\n" +
                    "#..#\n" +
                    "#..#";
}
