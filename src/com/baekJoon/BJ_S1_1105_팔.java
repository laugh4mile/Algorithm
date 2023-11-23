package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1105_팔 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        String L = tokens.nextToken();
        String R = tokens.nextToken();

        if (L.length() != R.length()){
            System.out.println(0);
            return;
        }
        int answer = 0;
        for(int i=0; i<R.length(); i++){
            if(R.charAt(i) == L.charAt(i)){
                if(R.charAt(i) == '8'){
                    answer++;
                }
            }else{
                break;
            }
        }
        System.out.println(answer);
    }

    static String src =
            "8808 8818";
}
