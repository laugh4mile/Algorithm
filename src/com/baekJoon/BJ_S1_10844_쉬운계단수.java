package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_S1_10844_쉬운계단수 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int mod = 1_000_000_000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        input = new BufferedReader(new StringReader(src)); 
        N = Integer.parseInt(input.readLine());
        System.out.println(dp(N));
    }

    static long dp(int n) {
        // dt[n][i] = n자리에서 마지막 수가 i일 때 계단수의 개수
        int[][] dt = new int[n + 1][10];

        // 초기화 1글자를 만들 때 i로 끝나는 계단수의 개수?
        for (int i = 1; i < 10; i++) {
            dt[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            // 마지막 숫자가 0이 추가되는 경우 - 이전 수는 무조건 1
            dt[i][0] = dt[i - 1][1];
            // 마지막 숫자가 9가 추가되는 경우 - 이전 수는 무조건 8
            dt[i][9] = dt[i - 1][8];
            // 나머지 경우는 +1, -1 고려
            for (int k = 1; k < 9; k++) {
                dt[i][k] = (dt[i - 1][k - 1] + dt[i - 1][k + 1]) % mod;
            }
        }
        // n 번째 요소 합하기
        int cnt = 0;
        for (int k = 0; k < 10; k++) {
            // cnt+=dt[n][k];
            cnt = (cnt + dt[n][k]) % mod;
        }
        return cnt;
    }

    static String src = "100";
}
