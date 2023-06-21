package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_16987_계란으로계란치기 {
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

        solve(0, 0);

        System.out.println(answer);
    }

    private static void solve(int cur, int count) {
        if(answer < count){
            answer = count;
        }
        if(cur == N){
            return;
        }

        if(s[cur] <= 0){
            solve(cur+1, count);
        }else{
            for(int i=0; i<N; i++){
                if(i != cur && s[i]>0){
                    int temp = 0;
                    s[cur] -= w[i];
                    s[i] -= w[cur];
                    if(s[cur] <= 0) temp++;
                    if(s[i] <= 0) temp++;
                    solve(cur+1, count+temp);
                    s[cur] += w[i];
                    s[i] += w[cur];
                }
            }
        }


    }

    static String src =
            "6\n" +
                    "100 1\n" +
                    "100 1\n" +
                    "100 1\n" +
                    "100 1\n" +
                    "100 1\n" +
                    "100 1";
}
