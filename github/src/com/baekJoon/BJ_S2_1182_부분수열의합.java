package com.baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_S2_1182_부분수열의합 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, S, arr[], answer;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        S = Integer.parseInt(tokens.nextToken());
        arr = new int[N];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        dfs(0,0);
        if(S == 0){
            System.out.println(answer-1);
        }else{
            System.out.println(answer);
        }
    }

    private static void dfs(int i, int sum) {
        if(i == N) {
            if(sum == S) {
                answer++;
            }
            return;
        }
        dfs(i+1, sum); // 선택안할경우
        dfs(i+1, sum + arr[i]); // 선택할경우
    }

    static String src =
            "5 0\n" +
            "-7 -3 -2 5 8";
}
