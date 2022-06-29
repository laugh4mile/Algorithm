package com.codingtest.youngmin;

import java.io.*;
import java.util.*;

public class p1 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(input.readLine());
        }
        System.out.println(set);

        List<String> answers = new ArrayList<>();
        for(int i=0; i<m; i++){
            String student = input.readLine();
            if(set.contains(student)){
                answers.add(student);
            }
        }
        System.out.println(answers.size());
        for(int i=0; i<answers.size(); i++){
            System.out.println(answers.get(i));
        }
    }

    static String src =
            "5 3\n" +
            "kim\n" +
            "lee\n" +
            "park\n" +
            "choi\n" +
            "min\n" +
            "park\n" +
            "baek\n" +
            "lee";

}
