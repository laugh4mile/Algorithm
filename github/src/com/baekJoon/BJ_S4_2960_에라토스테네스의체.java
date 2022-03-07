package com.baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_S4_2960_에라토스테네스의체 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());
        boolean isSelected[] = new boolean[N+1];
        int cnt = 0;
        for(int i=2; i<=N; i++){
            if(!isSelected[i]){
                for(int j=i; j<=N; j=j+i){
                    if(!isSelected[j]){
                        isSelected[j] = true;
                        if(++cnt == K){
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }

    static String src =
            "10 7";
}
