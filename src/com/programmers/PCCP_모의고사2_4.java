package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PCCP_모의고사2_4 {
    static int N,M, map[][], min = Integer.MAX_VALUE;
    static boolean isVisited[][][];
    public static int solution(int n, int m, int[][] hole) {
        int answer = 0;
        N = n;
        M = m;
        map = new int[N][M];
        isVisited = new boolean[N][M][2];
        for(int i=0; i<hole.length; i++){
            map[hole[i][0]-1][hole[i][1]-1] = 1;
        }

//        for(int x[] : map){
//            System.out.println(Arrays.toString(x));
//        }

        bfs(0,0,0,0);
        answer = min;
        return answer;
    }

    private static void bfs(int r, int c, int t, int useJump) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r,c,t,useJump));
        isVisited[r][c][useJump] = true;

        while (!queue.isEmpty()){
            Node front = queue.poll();
            if(front.r == N-1 && front.c == M-1){
                min = Math.min(min, front.t);
            }
            for(int d=0; d<4; d++){
                int nr = front.r+dr[d];
                int nc = front.c+dc[d];
                if(isIn(nr,nc) && !isVisited[nr][nc][front.useJump] && map[nr][nc] != 1){
                    isVisited[nr][nc][front.useJump] = true;
                    queue.offer(new Node(nr,nc,front.t+1,front.useJump));
                }
            }
            if(front.useJump == 0){
                for(int d=0; d<4; d++){
                    int nr = front.r+2*dr[d];
                    int nc = front.c+2*dc[d];
                    if(isIn(nr,nc) && !isVisited[nr][nc][1] && map[nr][nc] != 1){
                        isVisited[nr][nc][1] = true;
                        queue.offer(new Node(nr,nc,front.t+1,1));
                    }
                }
            }
        }

    }

    static class Node{
        int r;
        int c;
        int t;
        int useJump;

        public Node(int r, int c, int t, int useJump) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.useJump = useJump;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", t=" + t +
                    ", useJump=" + useJump +
                    '}';
        }
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<M);
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] hole = {{2,3},{3,3}};
        System.out.println(solution(n,m,hole));
    }
}
