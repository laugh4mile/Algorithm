package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_19539_사과나무 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        tokens = new StringTokenizer(input.readLine());
        int sum = 0;
        int moks2 = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(tokens.nextToken());
            sum += num;
            moks2 += num/2;
        }
        if(sum % 3 == 0 && sum/3 <= moks2){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }

    static String src =
            "5\n" +
                    "1 3 1 3 1";
}
