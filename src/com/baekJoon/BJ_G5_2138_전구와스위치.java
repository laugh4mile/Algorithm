package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_2138_전구와스위치 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N;
    static int[] origin, result, temp;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        char[] originStr = input.readLine().toCharArray();
        char[] resultStr = input.readLine().toCharArray();

        origin = new int[N];
        result = new int[N];

        for(int i=0; i<N; i++){
            origin[i] = originStr[i] - '0';
            result[i] = resultStr[i] - '0';
        }

        if(Arrays.toString(origin).equals(Arrays.toString(result))){
            System.out.println(0);
            return;
        }

        int answer = -1;

        // 0 번을 누를 경우
        int cnt = 1;
        temp = origin.clone();
        pushSwich(0);
        for(int i=1; i<N; i++){
            if(result[i-1] != temp[i-1]){
                pushSwich(i);
                cnt++;
            }
        }
        if(Arrays.toString(temp).equals(Arrays.toString(result))){
            answer = cnt;
        }

        // 0 번을 누르지 않을 경우
        cnt = 0;
        temp = origin.clone();
        for(int i=1; i<N; i++){
            if(result[i-1] != temp[i-1]){
                pushSwich(i);
                cnt++;
            }
        }
        if(Arrays.toString(temp).equals(Arrays.toString(result))){
            answer = cnt;
        }

        System.out.println(answer);
    }

    static void pushSwich(int idx){
        if(idx == 0){
            temp[idx] = (temp[idx]+1) % 2;
            temp[idx+1] = (temp[idx+1]+1) % 2;
        }else if(idx == N-1){
            temp[idx-1] = (temp[idx-1]+1) % 2;
            temp[idx] = (temp[idx]+1) % 2;
        }else{
            temp[idx-1] = (temp[idx-1]+1) % 2;
            temp[idx] = (temp[idx]+1) % 2;
            temp[idx+1] = (temp[idx+1]+1) % 2;
        }
    }

    static String src =
            "3\n" +
            "000\n" +
            "010";
}
