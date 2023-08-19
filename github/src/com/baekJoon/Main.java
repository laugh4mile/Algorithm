package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, w[], s[], answer;


    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        w = new int [N];
        s = new int [N];
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            s[i] = Integer.parseInt(tokens.nextToken());
            w[i] = Integer.parseInt(tokens.nextToken());
        }

        solve(0);

        System.out.println(answer);
    }

    private static void solve(int cur) {
        System.out.println(Arrays.toString(s));
        if(cur == N-1){
            int sum = 0;
            for(int i=0; i<N; i++){
                if(s[i] <= 0){
                    sum++;
                }
            }
            if(answer < sum){
                answer = sum;
            }
            return;
        }

        if(s[cur] <= 0){
            solve(cur+1);
        }else{
            for(int i=0; i<N; i++){
                if(i != cur && s[i]>0){
                    s[cur] -= w[i];
                    s[i] -= w[cur];
                    solve(cur+1);
                    s[cur] += w[i];
                    s[i] += w[cur];
                }
            }
        }


    }

    static String src =
            "4\n" +
                    "100 1\n" +
                    "100 100\n" +
                    "100 1\n" +
                    "100 100";
}