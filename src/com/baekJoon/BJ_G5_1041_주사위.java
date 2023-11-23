package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1041_주사위 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        long N = Integer.parseInt(input.readLine());
        tokens = new StringTokenizer(input.readLine());
        int dice[] = new int[6];
        int sum = 0;

        for(int i=0; i<6; i++){
            dice[i] = Integer.parseInt(tokens.nextToken());
            sum += dice[i];
        }

        if(N==1){
            Arrays.sort(dice);
            sum -= dice[5];
            System.out.println(sum);
            return;
        }

        long side_1 = Long.MAX_VALUE;
        long side_2 = Long.MAX_VALUE;
        long side_3 = Long.MAX_VALUE;

        long answer = 0;

        for(int i=0; i<5; i++){
            for(int j=i+1; j<6; j++){
                if(i+j == 5) continue;
                side_2 = Math.min(side_2, dice[i]+dice[j]);
            }
        }

        for(int i=0; i<4; i++){
            for(int j=i+1; j<5; j++){
                for(int k=j+1; k<6; k++){
                    if(i+j == 5 || i+k == 5 || j+k == 5) continue;
                    side_3 = Math.min(side_3, dice[i]+dice[j]+dice[k]);
                }
            }
        }

        Arrays.sort(dice);
        side_1 = dice[0];

        answer = ((N-2)*(N-2)*5 + 4*(N-2)) * side_1
                + (8*(N-2)+4) * side_2
                +  4 * side_3;

        System.out.println(answer);
    }


    static String src =
            "1000000\n" +
                    "50 50 50 50 50 50";
}
