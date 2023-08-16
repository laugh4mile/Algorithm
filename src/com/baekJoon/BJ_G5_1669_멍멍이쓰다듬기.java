package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_1669_멍멍이쓰다듬기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());

        int X = Integer.parseInt(tokens.nextToken());
        int Y = Integer.parseInt(tokens.nextToken());
        int gap = Y - X;
        if(gap == 0){
            System.out.println(0);
        } else{
            int rootNum = (int) Math.sqrt((double) gap);
            if(rootNum == Math.sqrt((double) gap)){
                System.out.println(rootNum + rootNum - 1);
            }else{
                if(gap - Math.pow((double) rootNum, 2) <= rootNum){
                    System.out.println(rootNum + rootNum);
                }else{
                    System.out.println(rootNum + rootNum + 1);
                }
            }
        }
    }

    static String src =
            "45 50";
}
