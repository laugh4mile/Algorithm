package com.codingtest.devmatching.test4_20220402;

import java.util.*;

public class Q2 {
    static String[] grid = {
            "??b", "abc", "cc?"};

    public static void main(String[] args) {
        System.out.println(solution(grid));
    }
    static char[][] map;
    static char[][] temp;
    static int answer;
    public static int solution(String[] grid) {

        map = new char[grid.length][grid[0].length()];
        temp = new char[grid.length][grid[0].length()];
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length(); c++){
                map[r][c] = grid[r].charAt(c);
                temp[r][c] = map[r][c];
            }
        }
        dfs(0,0);
//        for(char x[] : map){
//            System.out.println(Arrays.toString(x));
//        }

        return answer;
    }
    static boolean isVisited[][];
    private static void dfs(int curR, int curC) {
        for(int r=curR; r<map.length; r++){
            for(int c=curC; c<map[0].length; c++){
                if(map[r][c] == '?'){
//                    System.out.println(r+"  ,  "+c);
                    int nr = r;
                    int nc = c+1;
                    if(nc == map[0].length){
                        nc = 0;
                        nr++;
                    }
                    for(int t=0; t<3; t++){
                        temp[r][c] = (char) (t + 'a');
                        if(r == map.length-1 && c == map[0].length-1){
                            check();
                            return;
                        }else{
                            dfs(nr, nc);
                        }
                    }
                }
            }
        }
    }

    private static void check() {
        for(char x[] : temp){
            System.out.println(Arrays.toString(x));
        }
        System.out.println();
        isVisited = new boolean[map.length][map[0].length];
        int sum = 0;
        Set<Character> set = new HashSet<>();
        for(int r=0; r<temp.length; r++){
            for(int c=0; c<temp.length; c++){
                if(!isVisited[r][c]){
                    if(!set.contains(temp[r][c])){
                        set.add(temp[r][c]);
                        bfs(r,c);
                        if(++sum > 3){
                            return;
                        }
                    }else{
                        return;
                    }
                }
            }
        }
        answer++;
    }

    private static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        isVisited[r][c] = true;
        queue.offer(new Node(r,c));

        while (!queue.isEmpty()){
            Node front = queue.poll();

            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc) && !isVisited[nr][nc] && temp[nr][nc] == temp[front.r][front.c]){
                    queue.offer(new Node(nr,nc));
                    isVisited[nr][nc] = true;
                }
            }
        }
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<map.length && c<map[0].length);
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
