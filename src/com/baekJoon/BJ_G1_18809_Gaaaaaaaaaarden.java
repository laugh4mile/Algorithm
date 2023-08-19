package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G1_18809_Gaaaaaaaaaarden {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, M, G, R, map[][], max;
    static int isVisited[][][];
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        G = Integer.parseInt(tokens.nextToken());
        R = Integer.parseInt(tokens.nextToken());
        map = new int[N][M];
        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<M; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
                if(map[r][c] == 2){
                    list.add(new Node(r,c,-1, 1)); // color -1: 없음, 0: Green, 1: Red
                }
            }
        }
//        for(int x[]: map){
//            System.out.println(Arrays.toString(x));
//        }
        combinationGreen(0, 0);
        System.out.println(max);
    }

    private static void combinationGreen(int start, int cnt) {
        if(cnt == G){
            combinationRed(0,0);
            return;
        }
        for(int i=start; i<list.size(); i++){
            list.get(i).color = 0;
            combinationGreen(i+1, cnt+1);
            list.get(i).color = -1;
        }
    }

    private static void combinationRed(int start, int cnt) {
        if(cnt == R){
//            System.out.println(list);
            bfs();
            return;
        }
        for(int i=start; i<list.size(); i++){
            if(list.get(i).color == -1){
                list.get(i).color = 1;
                combinationRed(i+1, cnt+1);
                list.get(i).color = -1;
            }
        }
    }

    private static void bfs() {
        isVisited = new int[N][M][2]; // isVisited[r][c][color] : r,c 에 color색이 몇번의 이동으로 방문했는지. 0은 미방문
        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).color == -1) continue;
            queue.offer(list.get(i));
            isVisited[list.get(i).r][list.get(i).c][list.get(i).color] = 1;
        }
        int flowers = 0;
//        System.out.println("bfs 시작~~~");
        while(!queue.isEmpty()){
            Node front = queue.poll();
//            System.out.println(front);
            if(isVisited[front.r][front.c][0] == isVisited[front.r][front.c][1]){
//                flowers++;
                continue;
            }
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc) && isVisited[nr][nc][front.color] == 0 && map[nr][nc] != 0){
                    isVisited[nr][nc][front.color] = front.move+1;
                    if(isVisited[nr][nc][front.color^1] != 0){ // 다른색이 칠해져 있을 경우
                        if(isVisited[nr][nc][front.color] == isVisited[nr][nc][front.color^1]) { // 꽃이 만들어지는 경우 -> queue에 안담음
//                            System.out.println(nr + " " + nc);
                            flowers++;
                        }
                    }else{ // 다른색이 안 칠해져 있을경우
                        queue.offer(new Node(nr, nc, front.color, front.move+1));
                    }
                }
            }
        }

        if(max < flowers){
            max = flowers;
        }
    }

    static class Node{
        int r;
        int c;
        int color; // 0: 없음, 1:green, 2:red
        int move;

        public Node(int r, int c, int color, int move) {
            this.r = r;
            this.c = c;
            this.color = color;
            this.move = move;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", color=" + color +
                    ", move=" + move +
                    '}';
        }
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<M);
    }

    static String src =
            "13 17 2 4\n" +
                    "1 1 1 1 1 1 1 2 1 1 1 1 1 1 1 1 0\n" +
                    "1 1 0 0 1 1 1 1 1 1 0 1 1 1 1 1 1\n" +
                    "1 0 1 1 1 1 0 1 1 1 1 1 1 1 1 1 1\n" +
                    "1 1 1 1 1 1 1 1 1 0 1 1 2 1 1 1 1\n" +
                    "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                    "0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                    "1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1 1\n" +
                    "1 1 1 1 1 1 0 1 1 1 0 1 0 1 1 1 1\n" +
                    "1 1 1 1 1 1 1 2 1 1 1 1 1 1 0 1 1\n" +
                    "1 1 1 1 1 0 1 1 1 1 1 1 1 1 1 1 1\n" +
                    "1 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                    "2 1 1 1 1 1 2 1 1 1 1 2 1 1 1 1 1\n" +
                    "2 1 1 1 1 1 1 1 1 1 1 1 1 1 2 1 1";
}
