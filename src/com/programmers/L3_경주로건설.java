package com.programmers;

public class L3_경주로건설 {

    static boolean isVisited[][][];
    static int map[][], N, answer=Integer.MAX_VALUE;
    static int cost[][][];
    public static int solution(int[][] board) {
        N = board.length;
        isVisited = new boolean[N][N][4];
        map = new int[N][N];
        cost = new int[N][N][4];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                map[r][c] = board[r][c];
                for(int d=0; d<4; d++){
                    cost[r][c][d] = Integer.MAX_VALUE;
                }
            }
        }
        for(int d=0; d<4; d++){
            cost[0][0][d] = 0;
        }
        dfs(0,0,-1, 0);

//        System.out.println(cost[N-1][N-1]);
        return answer;
    }

    private static void dfs(int r, int c, int dir, int sum) {
        if(dir == -1){
        }else if(cost[r][c][dir] >= sum){
            cost[r][c][dir] = sum;
        }else{
            return;
        }
        if(r==N-1 && c==N-1){
            if(answer > sum){
                answer = sum;
            }
            return;
        }
        for(int d=0; d<4; d++){
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(isIn(nr,nc) && !isVisited[nr][nc][d] && map[nr][nc] != 1){
                isVisited[nr][nc][d] = true;
                if(dir == -1 || dir == d){
                    dfs(nr,nc,d, sum+100);
                }else{
                    dfs(nr,nc,d, sum+600);
                }
                isVisited[nr][nc][d] = false;
            }
        }
    }

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    static int[] dr = {1,-1,0,0}; // 하상우좌
    static int[] dc = {0,0,1,-1};

    static class Node{
        int r;
        int c;
        int dir;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        System.out.println(solution(board));
    }
}
