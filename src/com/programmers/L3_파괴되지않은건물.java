package com.programmers;

public class L3_파괴되지않은건물 {
    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int R = board.length;
        int C = board[0].length;
        int [][] sum = new int[R+1][C+1];

        for(int i=0; i<skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            if(type == 2){
                sum[r1][c1] += degree;
                sum[r1][c2+1] -= degree;
                sum[r2+1][c1] -= degree;
                sum[r2+1][c2+1] += degree;
            }else{
                sum[r1][c1] -= degree;
                sum[r1][c2+1] += degree;
                sum[r2+1][c1] += degree;
                sum[r2+1][c2+1] -= degree;
            }
        }

        for(int r=1; r<R; r++){
            for(int c=0; c<C; c++){
                sum[r][c] += sum[r-1][c];
            }
        }

        for(int c=1; c<C; c++){
            for(int r=0; r<R; r++){
                sum[r][c] += sum[r][c-1];
            }
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                board[r][c] += sum[r][c];
                if(board[r][c] > 0) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.println(solution(board,skill));
    }
}
