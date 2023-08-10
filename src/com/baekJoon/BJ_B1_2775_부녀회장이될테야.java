package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B1_2775_부녀회장이될테야 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int dp [][] = new int [15][15];
        for(int i=0; i<dp.length; i++){
            dp[0][i] = i+1;
            dp[i][0] = 1;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

//        for(int x[] : dp){
//            System.out.println(Arrays.toString(x));
//        }
        int T = Integer.parseInt(input.readLine());
        for(int t=0; t<T; t++){
            int k = Integer.parseInt(input.readLine());
            int n = Integer.parseInt(input.readLine());
            System.out.println(dp[k][n-1]);
        }
    }

    static String src =
            "2\n" +
            "1\n" +
            "3\n" +
            "2\n" +
            "3";
}
