package com.ssafy.java.day0923;

public class 페인트칠하기 {
    static int N = 8;
    static long[] memo;
    static int Y = 0, B = 1;
    static long[][] memo2;

    public static void main(String[] args) {
        // memo 배열 초기화
        memo = new long[N + 1];
        // 초기 조건
        memo[1] = 2;// YELLOW, BLUE
        memo[2] = 3;// Blue - Blue는 불가

        System.out.println("재귀+memo 1: " + topDown1(N));
        System.out.println("DP 1: " + bottomUp1(N));
        System.out.println("DP 2: " + bottomUp2(N));

        memo2 = new long[N + 1][2];
        memo2[1][Y] = 1;
        memo2[1][B] = 1;
        System.out.println("재귀+memo 2: " + (topDown2(N, Y) + topDown2(N, B)));
    }

    // 1. 재귀 + memo: 넓은 의미의 DP (하향식 DP)
    static long topDown1(int n) {
        // 이미 얻오놓은 값이 있다면..
        if (memo[n] > 0) {
            return memo[n];
        }
        // 아직 구해놓은게 없다면..
        else {
            // 새롭게 값을 구하고 memo 하기
            return memo[n] = topDown1(n - 1) + topDown1(n - 2);
        }
    }

    // 2. DP(상향식 DP)
    static long bottomUp1(int n) {
        long[] dt = new long[n + 1];
        dt[1] = 2;
        dt[2] = 3;

        for (int i = 3; i <= n; i++) {
            dt[i] = dt[i - 1] + dt[i - 2];
        }
        return dt[n];
    }

    // 3. DP - 2차원 배열 이용
    static long bottomUp2(int n) {

        long[][] dt = new long[n + 1][2];
        // 기본 상황
        dt[1][Y] = 1;
        dt[1][B] = 1;

        for (int i = 2; i <= n; i++) {
            // 노랑은 이전층의 노랑 + 이전층의 파랑
            dt[i][Y] = dt[i - 1][Y] + dt[i - 1][B];
            // 파랑은 이전층의 노랑
            dt[i][B] = dt[i - 1][Y];
        }
        return dt[n][Y] + dt[n][B];
    }

    // 4. 재귀 + memo(2차원 배열 이용)
    static long topDown2(int n, int color) {
        if (memo2[n][color] > 0) {
            return memo2[n][color];
        }

        if (color == Y) {
            return memo2[n][color] = topDown2(n - 1, Y) + topDown2(n - 1, B);
        } else {
            return memo2[n][color] = topDown2(n - 1, Y);
        }
    }
}
