package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_23747_와드 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int R,C,hr,hc;
    static char map[][], answer[][];
    static boolean isVisited[][];
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        map = new char[R][C];
        answer = new char[R][C];
        isVisited = new boolean[R][C];
        for(int r=0; r<R; r++){
            String line = input.readLine();
            for(int c=0; c<C; c++){
                map[r][c] = line.charAt(c);
                answer[r][c] = '#';
            }
        }
        tokens = new StringTokenizer(input.readLine());
        hr = Integer.parseInt(tokens.nextToken())-1;
        hc = Integer.parseInt(tokens.nextToken())-1;
        String command = input.readLine();
        for(int i=0; i<command.length(); i++){
            if(command.charAt(i) == 'W'){
                if(!isVisited[hr][hc]){
                    bfs(hr, hc);
                }
            }
            if(command.charAt(i) == 'U'){
                hr--;
            }
            if(command.charAt(i) == 'D'){
                hr++;
            }
            if(command.charAt(i) == 'L'){
                hc--;
            }
            if(command.charAt(i) == 'R'){
                hc++;
            }
        }
        answer[hr][hc] = '.';
        for(int d=0; d<4; d++){
            int nr = hr + dr[d];
            int nc = hc + dc[d];
            if(isIn(nr,nc)){
                answer[nr][nc] = '.';
            }
        }
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                output.append(answer[r][c]);
            }
            output.append("\n");
        }
        output.close();
    }

    private static void bfs(int hr, int hc) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(hr, hc));
        isVisited[hr][hc] = true;
        answer[hr][hc] = '.';
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];
                if(isIn(nr,nc) && !isVisited[nr][nc] && map[nr][nc] == map[hr][hc]){
                    isVisited[nr][nc] = true;
                    answer[nr][nc] = '.';
                    queue.offer(new Node(nr,nc));
                }
            }
        }
    }
    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};


    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<R && c<C);
    }


    static String src =
            "4 5\n" +
                    "aaabc\n" +
                    "dcbbc\n" +
                    "dccaa\n" +
                    "ddaaa\n" +
                    "3 4\n" +
                    "WLLLWUURRD";
}
