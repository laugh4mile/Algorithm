package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_B2_10809_알파벳찾기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        String word = input.readLine();
        int answer[] = new int[26];
        Arrays.fill(answer, -1);
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(answer[idx] == -1){
                answer[idx] = i;
            }
        }
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i]+" ");
        }
    }

    static String src =
            "baekjoon";
}
