package com.codingtest.junho.kakaoEnterprise;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());

        int minAnswer = 0, maxAnswer = 0;
        int penguins[] = new int[3];

        penguins[0] = Integer.parseInt(tokens.nextToken());
        penguins[1] = Integer.parseInt(tokens.nextToken());
        penguins[2] = Integer.parseInt(tokens.nextToken());

        Arrays.sort(penguins);

        // max는 무조건 이거임
        maxAnswer = penguins[1] - penguins[0] - 1;
        if(maxAnswer < penguins[2] - penguins[1] - 1){
            maxAnswer = penguins[2] - penguins[1] - 1;
        }


        int cnt = 0;
        int left = 0;
        int right = 0;
        int mid = 0;
        // minAnswer 구하기
        if(penguins[2] - penguins[0] == 2){ // 3개 붙어있는 경우
            System.out.println(0);
            System.out.println(0);
            return;
        }else if(penguins[2]-penguins[1] == 2 || penguins[1]-penguins[0] == 2){ // 한칸만 떨어진 케이스가 존재할 경우
            System.out.println(1);
            System.out.println(maxAnswer);
            return;
        }else if(penguins[2]-penguins[1] == 1){ // 뒤에 2개가 붙어있을 경우
            left = penguins[0];
            right = penguins[1];
        }else if(penguins[1]-penguins[0] == 1){ // 앞의 2개가 붙어있을 경우
            left = penguins[1];
            right = penguins[2];
        }else{
            if(penguins[1] - penguins[0] < penguins[2] - penguins[1]){
                left = penguins[0];
                right = penguins[1];
            }else{
                left = penguins[1];
                right = penguins[2];
            }
        }

        while (left < right){
//            System.out.println(left+" "+right);
            if(right - left == 1){
                break;
            }
            right = (right + left) / 2;
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(maxAnswer);


    }

    static String src =
//            "4 7 9";
            "1 2 3";
//            "5 6 10";
}
