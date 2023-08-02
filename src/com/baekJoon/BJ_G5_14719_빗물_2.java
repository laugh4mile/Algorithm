package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_G5_14719_빗물_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int H = Integer.parseInt(tokens.nextToken());
        int W = Integer.parseInt(tokens.nextToken());

        tokens = new StringTokenizer(input.readLine());
        int [] map = new int[W];
        for(int i=0; i<W; i++){
            map[i] = Integer.parseInt(tokens.nextToken());
        }

        int answer = 0;
        for(int i=0; i<W-1; i++){
            int max = map[i+1];
            int maxIdx = i+1;
            for(int j=i+1; j<W; j++){
                if(max < map[j]){
                    max = map[j];
                    maxIdx = j;
                }
                if(map[i] <= max){
                    break;
                }
            }
            for(int j=i+1; j<maxIdx; j++){
                answer += Math.min(max, map[i]) - map[j];
            }
            i = maxIdx-1;
        }
        System.out.println(answer);
    }

    static String src =
            "4 4\n" +
                    "2 1 0 1";
}
