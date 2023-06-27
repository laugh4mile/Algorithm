package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_12919_A와B2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int answer;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringBuilder A = new StringBuilder(input.readLine());
        StringBuilder B = new StringBuilder(input.readLine());

        dfs(A, B);
        System.out.println(answer);
    }

    private static void dfs(StringBuilder A, StringBuilder B) {
        String a = A.toString();
        String b = B.toString();
//        System.out.println(a+"  "+b);
        if(a.equals(b)){
            answer = 1;
            return;
        }
        if(a.length() > b.length()){
            return;
        }

        if(b.charAt(b.length()-1) == 'A'){
            dfs(A, new StringBuilder(b.substring(0,b.length()-1)));
        }
        if(b.charAt(0) == 'B'){
            dfs(A, new StringBuilder(b.substring(1)).reverse());
        }
    }

    static String src =
            "A\n" +
                    "BABA";
}
