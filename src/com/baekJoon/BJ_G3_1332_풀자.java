package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G3_1332_풀자 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int V = Integer.parseInt(tokens.nextToken());
        int arr[] = new int[N];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        int min = arr[0];
        int max = arr[0];
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<N; i++){
            if(arr[i] < min){
                min = arr[i];
            }else if(arr[i] > max) {
                max = arr[i];
            }

            if(max - min >= V){
                for(int j=0; j<i; j++){
                    if(Math.abs(arr[i] - arr[j]) >= V){
                        answer = Math.min(answer, (j+1)/2+1 + (i-j+1)/2);
                    }
                }
                System.out.println(answer);
                return;
            }
        }
        System.out.println(N);
    }

    static String src =
            "9 4\n" +
                    "6 2 6 2 6 3 3 3 7";
}
