package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_B1_27962_오렌지먹은지얼마나오랜지 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        String word = input.readLine();

        for(int i=1; i<N; i++){
            String prefix = word.substring(0,i);
            String subfix = word.substring(N-i);
            int cnt = 0;
            for(int j=0; j<i; j++){
                if(prefix.charAt(j) != subfix.charAt(j)){
                    if(++cnt > 1){
                        break;
                    }
                }
            }
            if(cnt == 1){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    static String src =
            "14\n" +
                    "aaaaaabaaaaaaa";
}
