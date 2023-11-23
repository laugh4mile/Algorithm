package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_1461_도서관 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            int book = Integer.parseInt(tokens.nextToken());
            if(book > 0){
                plus.add(book);
            }else{
                minus.add(book * -1);
            }
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus, Collections.reverseOrder());

        int answer = 0;
        for(int i=0; i<minus.size(); i=i+M){
            answer += minus.get(i) * 2;
        }
        for(int i=0; i<plus.size(); i=i+M){
            answer += plus.get(i) * 2;
        }
        plus.add(0);
        minus.add(0);
        answer -= Math.max(plus.get(0), minus.get(0));
        System.out.println(answer);

    }

    static String src =
            "1 50\n" +
                    "1";
}
