package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G4_1744_수묶기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(input.readLine());
            if(num > 0){
                plus.add(num);
            }else{
                minus.add(num);
            }
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        int answer = 0;

        if(plus.size()%2 == 0){
            for(int i=0; i<plus.size(); i=i+2){
                answer += Math.max(plus.get(i) * plus.get(i+1), plus.get(i) + plus.get(i+1));
            }
        }else{
            for(int i=0; i<plus.size()-1; i=i+2){
                answer += Math.max(plus.get(i) * plus.get(i+1), plus.get(i) + plus.get(i+1));
            }
            answer += plus.get(plus.size()-1);
        }

        if(minus.size()%2 == 0){
            for(int i=0;  i<minus.size(); i=i+2){
                answer += minus.get(i) * minus.get(i+1);
            }
        }else{
            for(int i=0;  i<minus.size()-1; i=i+2){
                answer += minus.get(i) * minus.get(i+1);
            }
            answer += minus.get(minus.size()-1);
        }

        System.out.println(answer);
    }

    static String src =
            "2\n" +
                    "1\n" +
                    "1";
}
