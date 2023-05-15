package com.baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_S5_17266_어두운굴다리 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        int M = Integer.parseInt(input.readLine());

        int arr[] = new int[M];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        if(N == 1){
            System.out.println(1);
            return;
        }
        int distance = arr[0];
        if(N>1){
            distance = Math.max(distance, N-arr[M-1]);
        }

        for(int i=1; i<M; i++){
            distance = (int) Math.max(distance, Math.ceil((double)(arr[i] - arr[i - 1])/2));
        }

        System.out.println(distance);
    }

    static String src =
            "10\n" +
                    "2\n" +
                    "0 9";
}
