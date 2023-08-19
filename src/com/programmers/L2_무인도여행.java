package com.programmers;

import java.util.*;

public class L2_무인도여행 {
    static int N, M, map[][];
    static boolean isVisited[][];
    static List<Integer> list = new ArrayList<>();
    public static int[] solution(String[] maps) {
        int[] answer;
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        isVisited = new boolean[N][M];
        for(int r=0; r<maps.length; r++){
            String line = maps[r];
            for(int c=0; c<line.length(); c++){
                if(line.charAt(c) == 'X'){
                    map[r][c] = 0;
                }else{
                    map[r][c] = line.charAt(c) - '0';
                }
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(!isVisited[r][c] && map[r][c] != 0){
                    bfs(r,c);
                }
            }
        }
        if(list.size() == 0){
            return new int[]{-1};
        }
        answer = new int[list.size()];
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    private static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r,c));
        isVisited[r][c] = true;
        int sum = 0;

        while(!queue.isEmpty()){
            Node front = queue.poll();
            sum += map[front.r][front.c];

            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc) && !isVisited[nr][nc] && map[nr][nc] != 0){
                    isVisited[nr][nc] = true;
                    queue.offer(new Node(nr, nc));
                }
            }
        }

        list.add(sum);
    }

    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<M);
    }

    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};

        System.out.println(Arrays.toString(solution(maps)));
    }
}
