package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_B4_28224_FinalPrice {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int n = Integer.parseInt(input.readLine());
        int answer = 0;
        for(int i=0; i<n; i++){
            answer += Integer.parseInt(input.readLine());
        }
        System.out.println(answer);
    }

    static String src =
            "2\n" +
            "11\n" +
            "68";
}
