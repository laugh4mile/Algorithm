package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_11497_통나무건너뛰기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception {
        input = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(input.readLine());

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(input.readLine());
            int arr[] = new int[N];
            tokens = new StringTokenizer(input.readLine());
            for (int i=0; i<N; i++){
                arr[i] = Integer.parseInt(tokens.nextToken());
            }
            Arrays.sort(arr);

            int max = 0;

            for(int i=0; i<N-2; i++){
                max = Math.max(max, arr[i+2] - arr[i]);
            }
            max = Math.max(max, arr[N-1] - arr[N-2]);
            output.append(max+"\n");
        }
        output.close();
    }

    static String src =
            "3\n" +
                    "7\n" +
                    "13 10 12 11 10 11 12\n" +
                    "5\n" +
                    "2 4 5 7 9\n" +
                    "8\n" +
                    "6 6 6 6 6 6 6 6";
}
