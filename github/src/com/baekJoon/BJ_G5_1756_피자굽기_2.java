package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_1756_피자굽기_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int D = Integer.parseInt(tokens.nextToken());
        int N = Integer.parseInt(tokens.nextToken());

        int oven[] = new int[D];

        tokens = new StringTokenizer(input.readLine());
        oven[0] = Integer.parseInt(tokens.nextToken());
        for(int d=1; d<D; d++){
            int ovenSize = Integer.parseInt(tokens.nextToken());
            if(oven[d-1] < ovenSize){ // 아래층의 지름이 위층의 지름보다 커질 필요가 없다.
                oven[d] = oven[d-1];
            }else{
                oven[d] = ovenSize;
            }
        }
        // oven은 내림차순으로 정렬이 된 상태이다.

        tokens = new StringTokenizer(input.readLine());
        Queue<Integer> pizza = new LinkedList<>();
        for(int n=0; n<N; n++){
            pizza.offer(Integer.parseInt(tokens.nextToken()));
        }

        int answer = -1;
        for(int i=D-1; i>=0; i--){
            if(!pizza.isEmpty() && oven[i] >= pizza.peek()){
                pizza.poll();
                answer = i;
            }
        }
        if(!pizza.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(answer+1);
        }
    }

    static String src =
            "7 3\n" +
            "5 6 4 3 6 2 3\n" +
            "3 2 5";
}
