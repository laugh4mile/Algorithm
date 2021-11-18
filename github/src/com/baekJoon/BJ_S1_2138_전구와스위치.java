package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_2138_전구와스위치 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        char origin[] = input.readLine().toCharArray();
        char result[] = input.readLine().toCharArray();
        char temp[] = origin.clone();

        int cnt = 0;
        for(int i=1; i<N-1; i++){
            if(temp[i-1] != result[i-1]){
                temp[i-1] = convertor(temp[i-1]);
                temp[i] = convertor(temp[i]);
                temp[i+1] = convertor(temp[i+1]);
                cnt++;
            }
        }
        if(isMatch(temp, result)){
            System.out.println(cnt);
            return;
        }
        temp = origin.clone();
        cnt = 0;
        for(int i=1; i<N; i++){
            if(i==1){
                if(temp[0] != result[0]){
                    temp[0] = convertor(temp[0]);
                    temp[1] = convertor(temp[1]);
                    cnt++;
                }
            }else if(i==N-1){
                if(temp[N-2] != result[N-2]){
                    temp[N-2] = convertor(temp[N-2]);
                    temp[N-1] = convertor(temp[N-1]);
                    cnt++;
                }
            }else{
                if(temp[i-1] != result[i-1]){
                    temp[i-1] = convertor(temp[i-1]);
                    temp[i] = convertor(temp[i]);
                    temp[i+1] = convertor(temp[i+1]);
                    cnt++;
                }
            }
        }
        System.out.println(Arrays.toString(temp));

        if(isMatch(temp, result)){
            System.out.println(cnt);
            return;
        }
        System.out.println(-1);
    }
    private static boolean isMatch(char[] temp, char[] result) {
        for(int i=0; i<temp.length; i++){
            if(temp[i] != result[i]){
                return false;
            }
        }
        return true;
    }

    static char convertor(char c){
        if (c == '0'){
            return '1';
        }else{
            return '0';
        }
    }

    static String src =
            "3\n" +
                    "000\n" +
                    "010";
}
