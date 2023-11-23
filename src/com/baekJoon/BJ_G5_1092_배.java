package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G5_1092_배 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N,M;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));

        N = Integer.parseInt(input.readLine());
        List<Integer> crane = new ArrayList<>();
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            crane.add(Integer.parseInt(tokens.nextToken()));
        }

        M = Integer.parseInt(input.readLine());
        List<Integer> box = new ArrayList<>();
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<M; i++){
            box.add(Integer.parseInt(tokens.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if(crane.get(0) < box.get(0)){
            System.out.println(-1);
            return;
        }

        int answer = 0;
        while(!box.isEmpty()){
            int idx = 0;
            for(int i=0; i<crane.size(); i++){
                for(int j=idx; j<box.size(); j++){
                    if(crane.get(i) >= box.get(j)){
                        box.remove(j);
                        idx = j;
                        break;
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }

    static String src =
            "10\n" +
                    "11 17 5 2 20 7 5 5 20 7\n" +
                    "5\n" +
                    "18 18 15 15 17";
}
