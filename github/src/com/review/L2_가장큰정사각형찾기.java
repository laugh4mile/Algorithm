package com.review;

public class L2_가장큰정사각형찾기 {
    public static int solution(int [][]board)
    {
        int answer = 0;

        int dp[][] = new int[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            if(board[i][0] == 1) {
                answer = 1;
                dp[i][0] = 1;
            }
        }
        for(int i=0; i<board[0].length; i++){
            if(board[0][i] == 1) {
                answer = 1;
                dp[0][i] = 1;
            }
        }

        for(int r=1; r<board.length; r++){
            for(int c=1; c<board[0].length; c++){
                if(board[r][c] == 1){
                    dp[r][c] = Math.min(Math.min(dp[r-1][c-1], dp[r-1][c]), dp[r][c-1]) + 1;
                    answer = Math.max(answer, dp[r][c]);
                }
            }
        }


        return answer*answer;
    }


    public static void main(String[] args) {
        int [][]board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution(board));
    }
}
