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

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        map = new char[R][C];
        isVisited = new boolean[2][R][C];

        int startR = 0;
        int startC = 0;

        int fireR = 0;
        int fireC = 0;
        for(int r=0; r<R; r++){
            String line = input.readLine();
            for(int c=0; c<C; c++){
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'J'){
                    startR = r;
                    startC = c;
                }
                if(map[r][c] == 'F'){
                    fireR = r;
                    fireC = c;
                }
            }
        }

        escape(startR, startC, fireR, fireC);
    }

    private static void escape(int startR, int startC, int fireR, int fireC) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startR,startC, 'J', 1)); // 지훈이를 queue에 먼저 넣어야 함!
        queue.offer(new Node(fireR,fireC, 'F', 1));
        isVisited[0][startR][startC] = true;
        isVisited[1][fireR][fireC] = true;

        int nr = 0;
        int nc = 0;
        Node front;
        while (!queue.isEmpty()) {
            front = queue.poll();
            if(front.JorF == 'J'){
                isVisited[0][front.r][front.c] = true;
            }else isVisited[1][front.r][front.c] = true;
            if((front.r == 0 || front.r == R-1 || front.c == 0 || front.c == C-1) && front.JorF == 'J'){
                boolean flag = false;
                for(int d=0; d<4; d++){
                    nr = front.r + dr[d];
                    nc = front.c + dc[d];
                    if(isIn(nr,nc) && isVisited[1][nr][nc]){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    System.out.println(front.time);
                    return;
                }
            }

            for(int d=0; d<4; d++){
                nr = front.r + dr[d];
                nc = front.c + dc[d];
                if(front.JorF == 'J'){
                    if(isIn(nr,nc) && !isVisited[0][nr][nc] && !isVisited[1][nr][nc] && map[nr][nc] == '.'){
                        queue.offer(new Node(nr,nc,front.JorF,front.time+1));
                    }
                }else{
                    if(isIn(nr,nc) && !isVisited[1][nr][nc] && map[nr][nc] != '#'){
                        queue.offer(new Node(nr,nc,front.JorF,front.time+1));
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
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<R && c<C);
    }

    static String src =
            "4 5\n" +
            "#####\n" +
            "#J..#\n" +
            "#...#\n" +
            "#...F";
}
