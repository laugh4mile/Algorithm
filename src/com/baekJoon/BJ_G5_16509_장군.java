package com.baekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_16509_장군 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static boolean isVisited[][] = new boolean[10][9];
    static int map[][] = new int[10][9];
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int r1 = Integer.parseInt(tokens.nextToken());
        int c1 = Integer.parseInt(tokens.nextToken());

        tokens = new StringTokenizer(input.readLine());
        int r2 = Integer.parseInt(tokens.nextToken());
        int c2 = Integer.parseInt(tokens.nextToken());

        map[r2][c2] = -1;
        bfs(r1,c1,r2,c2);
        System.out.println(map[r2][c2]);
    }

    private static void bfs(int r1, int c1, int r2, int c2) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r1,c1));
        isVisited[r1][c1] = true;

        while (!queue.isEmpty()){
            Node front = queue.poll();
//            System.out.println(front+" "+map[front.r][front.c]);
            if(front.r == r2 && front.c == c2){
                break;
            }
            outer: for(int d=0; d<8; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];
                if(isIn(nr,nc) && !isVisited[nr][nc]){
                    for(int i=0; i<2; i++){
                        if(isIn(front.r+check[d][i][0],front.c+check[d][i][1]) && map[front.r+check[d][i][0]][front.c+check[d][i][1]] == -1){
//                        System.out.println(front.r+" "+front.c+" 에서 "+d+"방향으로 가는 길"+ (front.r+check[d][i][0])+" "+(front.c+check[d][i][1]));
                            continue outer;
                        }
                    }
                    isVisited[nr][nc] = true;
                    map[nr][nc] = map[front.r][front.c] + 1;
                    queue.offer(new Node(nr,nc));
                }
            }
        }
    }
    static int check[][][] = { // 왜 장애물 정보가 없지?
            {
                {0,-1},{-1,-2}
            },
            {
                {-1,0},{-2,-1}
            },
            {
                {-1,0},{-2,1}
            },
            {
                {0,1},{-1,2}
            },
            {
                {0,1},{1,2}
            },
            {
                {1,0},{2,1}
            },
            {
                {1,0},{2,-1}
            },
            {
                {0,-1},{1,-2}
            }
    };

    static int dr[] = {-2,-3,-3,-2,2,3, 3, 2};
    static int dc[] = {-3,-2, 2, 3,3,2,-2,-3};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<10 && c<9);
    }

    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static String src =
            "0 1\n" +
                    "8 4";
}
