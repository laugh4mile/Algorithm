package com.baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_S3_2805_나무자르기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static Integer arr[];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        arr = new Integer[N];
        tokens = new StringTokenizer(input.readLine());
        int left = 0;
        int right = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
            if(right < arr[i]){
                right = arr[i];
            }
        }
//        Arrays.sort(arr, Collections.reverseOrder());
        int answer = 0;
        int H = 0;
        while(left <= right){
            H = (left+right) / 2;

            if(isMoreThenM(H, M)){
                left = H + 1;
                answer = H;
            }else{
                right = H - 1;
            }
        }

        System.out.println(answer);

    }

    private static boolean isMoreThenM(int H, int M) {
        long sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > H){
                sum += arr[i] - H;
                if(sum >= M){
                    return true;
                }
            }
        }
        return false;
    }


    static String src =
            "4 7\n" +
            "20 15 10 17";
}
