package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_1756_피자굽기 { // 시간 초과
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int D = Integer.parseInt(tokens.nextToken());
        int N = Integer.parseInt(tokens.nextToken());

        int oven[] = new int[D];
        tokens = new StringTokenizer(input.readLine());
        for(int d=0; d<D; d++){
            oven[d] = Integer.parseInt(tokens.nextToken());
        }

        tokens = new StringTokenizer(input.readLine());
        for(int n=0; n<N; n++){
            int pizzaSize = Integer.parseInt(tokens.nextToken());
            for(int i=0; i<D; i++){
                if(pizzaSize > oven[i]){
                    if(i>0){
                        oven[i-1] = 0;
                        break;
                    }else{
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        for (int i=0; i<D; i++){
            if(oven[i] == 0){
                System.out.println(i+1);
                return;
            }
        }
    }

    static String src =
            "7 3\n" +
            "5 6 4 3 6 2 3\n" +
            "3 2 5";
}
