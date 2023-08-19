package com.codingtest.line.fintech;

import java.util.*;

public class Q1 {
//    static String[] record = {"P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"};
//    static String[] record = {"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"};
    static String[] record = {"P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(record)));
    }

    public static int[] solution(String[] record) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer tokens;
        int a = 0; // 선입선출법 매출. queue
        int b = 0; // 후입선출법 매출. stack
        for(int i=0; i<record.length; i++){
            tokens = new StringTokenizer(record[i]);
            char activity = tokens.nextToken().charAt(0);
            int price = Integer.parseInt(tokens.nextToken());
            int amount = Integer.parseInt(tokens.nextToken());

            if(activity == 'P'){ // 구매
                for(int j=0; j<amount; j++){
                    queue.offer(price);
                    stack.push(price);
                }
            }else{ // 판매
                for(int j=0; j<amount; j++){
                    a += queue.poll();
                    b += stack.pop();
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = a;
        answer[1] = b;

        return answer;
    }
}
