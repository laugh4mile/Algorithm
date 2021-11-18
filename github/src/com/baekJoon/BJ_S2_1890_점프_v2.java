package com.baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_S2_1890_점프_v2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N;
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        int map[][] = new int[N][N];
        long dp[][] = new long[N][N];

        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(r==N-1 && c==N-1) break;
                if(dp[r][c] != 0){
                    if(isIn(r,c+map[r][c])){
                        dp[r][c+map[r][c]] += dp[r][c];
                    }
                    if(isIn(r+map[r][c],c)){
                        dp[r+map[r][c]][c] += dp[r][c];
                    }
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
//        for(int x[] : dp){
//            System.out.println(Arrays.toString(x));
//        }
    }

    static int dr[] = {0,1};
    static int dc[] = {1,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    static String src =
            "4\n" +
                    "2 3 3 1\n" +
                    "1 2 1 3\n" +
                    "1 2 3 1\n" +
                    "3 1 1 0";
}
