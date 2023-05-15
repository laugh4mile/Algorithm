package com.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L2_거리두기확인하기 {
    static boolean isVisited[][];
    static int N;
    public static int[] solution(String[][] places) {
        N = 5;
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);

        outer : for(int i=0; i<places.length; i++){
            char map[][] = new char[N][N];
            for(int r=0; r<N; r++){
                String line = places[i][r];
                for(int c=0; c<N; c++){
                    map[r][c] = line.charAt(c);
                }
            }

            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(map[r][c] == 'P'){
                        isVisited = new boolean[N][N];
                        map[r][c] = '0';
                        if(!isObserved(map, r,c)){
                            map[r][c] = 'P';
                            answer[i] = 0;
                            continue outer;
                        }
                        map[r][c] = 'P';
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isObserved(char[][] map, int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c, 0));
        isVisited[r][c] = true;

        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(map[front.r][front.c] == 'P' && front.distance <= 2){
                return false;
            }
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];
                if(isIn(nr,nc) && !isVisited[nr][nc] && map[nr][nc] != 'X'){
                    isVisited[nr][nc] = true;
                    queue.offer(new Node(nr, nc, front.distance+1));
                }
            }
        }
        return true;
    }

    static class Node{
        int r;
        int c;
        int distance;
        public Node(int r, int c, int distance){
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));
    }
}
