package com.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class L2_삼각달팽이 {
    static int N, map[][];
    public static int[] solution(int n) {
        int[] answer = {};
        N = n;
        map = new int[n][n];
        answer = new int[(n*(1+n))/2];

        triangleSnail();

        int cnt = 0;
        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                if(map[r][c] != 0){
                    answer[cnt++] = map[r][c];
                }
            }
        }
        return answer;
    }

    private static void triangleSnail() {
        Queue<Node> queue = new LinkedList<>();
        int cnt = 1;
        queue.offer(new Node(0,0,0));

        while(!queue.isEmpty()){
            Node front = queue.poll();
            map[front.r][front.c] = cnt++;

            int nr = front.r + dr[front.dir];
            int nc = front.c + dc[front.dir];

            if(isIn(nr,nc) && map[nr][nc] == 0){
                queue.offer(new Node(nr,nc,front.dir));
            }else{
                nr = front.r + dr[(front.dir+1)%3];
                nc = front.c + dc[(front.dir+1)%3];
                if(isIn(nr,nc) && map[nr][nc] == 0){
                    queue.offer(new Node(nr, nc, (front.dir +1)%3));
                }
            }
        }
    }

    static class Node{
        int r;
        int c;
        int dir;

        public Node(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.dir = d;
        }
    }

    static int[] dr = {1,0,-1};
    static int[] dc = {0,1,-1};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6)));
    }
}