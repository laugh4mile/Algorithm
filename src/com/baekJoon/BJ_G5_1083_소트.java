package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1083_소트 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, S, arr[];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        arr = new int[N];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        S = Integer.parseInt(input.readLine());

        int max = 0, maxIdx = 0;

        for(int i=0; i<N; i++){
            if(S <= 0) break;
            max = arr[i];
            maxIdx = i;

            for(int j=i+1; j<= i+S; j++){
                if(j>=N){
                    break;
                }
                if(max < arr[j]){
                    max = arr[j];
                    maxIdx = j;
                }
            }
            for(int j=maxIdx; j>i; j--){
                arr[j] = arr[j-1];
            }
            arr[i] = max;
            S -= maxIdx-i;
        }

        for(int i=0; i<N; i++){
            System.out.print(arr[i]+" ");
        }

    }

    static String src =
            "10\n" +
                    "1 2 3 4 5 6 7 8 9 10\n" +
                    "17";
}
