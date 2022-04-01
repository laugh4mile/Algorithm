package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_2110_공유기설치 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, C, arr[];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(arr);

        int left = 1;
        int right = (arr[arr.length-1] - arr[0]) / (C-1);
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            if(isAble(mid)){
                left = mid + 1;
                answer = mid;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isAble(int mid) {
        int cur = arr[0];
        int cnt = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] - cur >= mid){
                cur = arr[i];
                if(++cnt == C){
                    return true;
                }
            }
        }
        return false;
    }

    static String src =
            "5 3\n" +
            "1\n" +
            "2\n" +
            "8\n" +
            "4\n" +
            "9";
}
