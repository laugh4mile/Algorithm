package com.baekJoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_S5_4158_CD {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        while (true){
            tokens = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(tokens.nextToken());
            int M = Integer.parseInt(tokens.nextToken());
            if(N == 0 && M == 0){
                break;
            }
            Set<Integer> set = new HashSet<>();
            int cnt = 0;
            for(int i=0; i<N; i++){
                set.add(Integer.parseInt(input.readLine()));
            }

            for(int i=0; i<M; i++){
                if(set.contains(Integer.parseInt(input.readLine()))){
                    cnt++;
                }
            }
            output.append(cnt+"\n");
        }
        output.close();
    }

    static String src =
            "3 3\n" +
                    "1\n" +
                    "2\n" +
                    "3\n" +
                    "1\n" +
                    "2\n" +
                    "4\n" +
                    "0 0";
}
