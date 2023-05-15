package com.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class L2_최댓값과최솟값 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static String solution(String s) throws IOException {
        String answer = "";
        input = new BufferedReader(new StringReader(s));
        tokens = new StringTokenizer(input.readLine());

        List<Integer> list = new ArrayList<>();
        while(tokens.hasMoreTokens()){
            list.add(Integer.parseInt(tokens.nextToken()));
        }
        Collections.sort(list);
        System.out.println(list);



        return answer;
    }

    public static void main(String[] args) throws IOException {
        solution("1 2 3 4");
    }

}
