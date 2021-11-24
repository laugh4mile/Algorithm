package com.baekJoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_G5_12904_A와B {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        String S = input.readLine();
        String T = input.readLine();
        Deque<Character> deque = new LinkedList<>();

        int len_s = S.length();
        int len_t = T.length();

        boolean direction = true; // t : 정 , f : 역
        int start_idx = 0;
        int end_idx = len_t-1;
        while (len_s < len_t){
            if(direction){ // 정방향.
                if(T.charAt(end_idx) == 'A'){
                    end_idx--;
                }else{
                    end_idx--;
                    direction = false;
                }
            }else{ // 역방향
                if (T.charAt(start_idx) == 'A'){
                    start_idx++;
                }else{
                    start_idx++;
                    direction = true;
                }
            }
            len_t--;
        }
        StringBuilder sb = new StringBuilder(T.substring(start_idx, end_idx + 1));

        if(!direction){
            sb = sb.reverse();
        }
        if(S.equals(sb.toString())){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    static String src =
            "B\n" +
                    "ABBA";
}
