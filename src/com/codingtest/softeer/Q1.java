package com.codingtest.softeer;

import java.io.*;
import java.util.StringTokenizer;

public class Q1 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    // 1 <= S <= 1000_000_000_000
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        long S = Long.parseLong(input.readLine());
        long arr[] = new long[40];

        long temp = 2;
        for(int i=0; i<arr.length; i++){
            arr[i] = temp-1;
            temp *= 2;
        }
        double t = Math.log10(S)/Math.log10(2);
        System.out.println(arr[(int)t]);
    }

    static String src =
            "1";
//            "1000000000000";
}
