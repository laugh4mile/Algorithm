package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_9763_마을의친밀도 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, town[][], result[];
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        town = new int[N][3];
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            town[i][0] = Integer.parseInt(tokens.nextToken());
            town[i][1] = Integer.parseInt(tokens.nextToken());
            town[i][2] = Integer.parseInt(tokens.nextToken());
        }
        int answer = Integer.MAX_VALUE;

        int min = 0;
        int min2 = 0;
        for(int i=0; i<N; i++){
            min = Integer.MAX_VALUE/2;
            min2 = Integer.MAX_VALUE/2;
            for(int j=0; j<N; j++){
                if(i == j) continue;
                if(Math.abs(town[i][0] - town[j][0]) + Math.abs(town[i][1] - town[j][1]) + Math.abs(town[i][2] - town[j][2]) <= min){
                    min2 = min;
                    min = Math.abs(town[i][0] - town[j][0]) + Math.abs(town[i][1] - town[j][1]) + Math.abs(town[i][2] - town[j][2]);
                    answer = Math.min(answer, min+min2);

                }else if(Math.abs(town[i][0] - town[j][0]) + Math.abs(town[i][1] - town[j][1]) + Math.abs(town[i][2] - town[j][2]) < min2){
                    min2 = Math.abs(town[i][0] - town[j][0]) + Math.abs(town[i][1] - town[j][1]) + Math.abs(town[i][2] - town[j][2]);
                    answer = Math.min(answer, min+min2);
                }
            }
        }

        System.out.println(answer);
    }


    static String src =
            "9\n" +
            "0 0 1\n" +
            "0 0 11\n" +
            "0 0 3\n" +
            "0 0 4\n" +
            "0 0 6\n" +
            "0 0 8\n" +
            "0 0 7\n" +
            "0 0 9\n" +
            "0 0 10";
}
