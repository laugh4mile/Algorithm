// https://school.programmers.co.kr/learn/courses/30/lessons/159993
package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class L2_미로탈출_old {
    int R = 0;
    int C = 0;
    boolean isVisited[][];
    char[][] map;
    public int solution(String[] maps) {
        int answer = 0;
        R = maps.length;
        C = maps[0].length();
        map = new char[R][C];

        int sr = 0;
        int sc = 0;
        int lr = 0;
        int lc = 0;
        int er = 0;
        int ec = 0;

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                map[r][c] = maps[r].charAt(c);
                if(map[r][c] == 'S'){
                    sr = r;
                    sc = c;
                }
                if(map[r][c] == 'E'){
                    er = r;
                    ec = c;
                }
                if(map[r][c] == 'L'){
                    lr = r;
                    lc = c;
                }
            }
        }
        int a1 = bfs(sr, sc, lr, lc);
        if(a1 == -1){
            return -1;
        }

        int a2 = bfs(lr, lc, er, ec);
        if(a2 == -1){
            return -1;
        }

        return a1+a2;
    }

    int bfs(int sr, int sc, int er, int ec){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sr,sc, 0));

        isVisited = new boolean[R][C];
        isVisited[sr][sc] = true;

        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(front.r == er && front.c == ec){
                return front.cnt;
            }
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] != 'X'){
                    isVisited[nr][nc] = true;
                    queue.offer(new Node(nr, nc, front.cnt+1));
                }
            }
        }
        return -1;
    }

    class Node{
        int r;
        int c;
        int cnt;
        public Node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    int dr[] = {0,0,1,-1};
    int dc[] = {1,-1,0,0};

    boolean isIn(int r, int c){
        return (r >= 0 && c >= 0 && r<R && c<C);
    }
}
