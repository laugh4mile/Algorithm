package com.codingtest.snow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q3 {
    static int[][] v = {
            {1,1,0,1,1},
            {0,1,1,0,0},
            {0,0,0,0,0},
            {1,1,0,1,1},
            {1,0,1,1,1},
            {1,0,1,1,1}
    };
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(v)));
    }
    static int R, C, map[][], cnt, max;
    static boolean isVisited[][];
    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};


    public static int[] solution(int[][] v) {
        R = v.length;
        C = v[0].length;
        map = new int[R][C];
        isVisited = new boolean[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(!isVisited[r][c] && v[r][c] == 1){
                    bfs(r,c,v);
                }
            }
        }
        int[] answer = {cnt,max};
        return answer;
    }

    private static void bfs(int r, int c, int[][] v) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r,c));
        isVisited[r][c] = true;
        cnt++;
        int sum = 1;
        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(sum > max){
                max = sum;
            }
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc) && !isVisited[nr][nc] && v[nr][nc] == 1){
                    isVisited[nr][nc] = true;
                    queue.offer(new Node(nr,nc));
                    sum++;
                }
            }
        }
    }

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
}
