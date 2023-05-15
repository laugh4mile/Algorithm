package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

class L2_게임맵최단거리 {
    static int R, C;
    public static int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        boolean isVisited[][] = new boolean[R][C];
        int answer = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,1));
        isVisited[0][0] = true;
        while (!queue.isEmpty()){
            Node front = queue.poll();
            System.out.println(front.r +" "+front.c);
            if(front.r == R-1 && front.c == C-1){
                answer = front.cnt;
                break;
            }
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];
                if(isIn(nr,nc) && !isVisited[nr][nc] && maps[nr][nc] == 1){
                    isVisited[nr][nc] = true;
                    queue.offer(new Node(nr,nc,front.cnt+1));
                }
            }
        }
        return answer;
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};


    static class Node{
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<R && c<C);
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

}