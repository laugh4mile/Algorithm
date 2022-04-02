package com.codingtest.sk.skt.first;

public class Q3 {
//    static int width = 51;
//    static int height = 37;
//    static int[][] diagonals = {{17,19}};
    static int width = 2;
    static int height = 2;
    static int[][] diagonals = {{1,1},{2,2}};

    public static void main(String[] args) {
        System.out.println(solution(width, height, diagonals));
    }
    static long dp[][];
    static int R, C;
    public static int solution(int width, int height, int[][] diagonals) {
        int answer = 0;
        R = height;
        C = width;
        dp = new long[R+1][C+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 1;
        }
        for(int i=0; i<dp[0].length; i++){
            dp[0][i] = 1;
        }
        for (int r=1; r<dp.length; r++){
            for (int c=1; c<dp[0].length; c++){
                dp[r][c] = (dp[r-1][c] + dp[r][c-1]) % 10000019;
            }
        }

        for(int i=0; i<diagonals.length; i++){
            int r=diagonals[i][1];
            int c=diagonals[i][0];

            answer = (answer + getCountOfPaths(r,c)) % 10000019;

        }

//        for(int x[] : dp){
//            System.out.println(Arrays.toString(x));
//        }

        return answer;
    }

    private static int getCountOfPaths(int r, int c) { // (r-1,c)와 (r,c-1)사이에 대각선이 있다.
        long paths = 0;
        paths += (dp[r-1][c] * dp[R-r][C-(c-1)]) % 10000019;
        paths += (dp[r][c-1] * dp[R-(r-1)][C-c]) % 10000019;
        return (int) paths;
    }
}
