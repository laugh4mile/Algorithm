package com.baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_G3_22345_누적거리 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, Q;
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        Q = Integer.parseInt(tokens.nextToken());
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int x = Integer.parseInt(tokens.nextToken());
        }

        for(int i=0; i<Q; i++){
            
        }
    }

    static String src =
            "3 1 \n" +
                    "2 1 \n" +
                    "1 3 \n" +
                    "3 6 \n" +
                    "4";
}
