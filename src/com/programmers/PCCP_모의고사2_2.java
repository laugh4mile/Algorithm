package com.programmers;

import java.util.PriorityQueue;

public class PCCP_모의고사2_2 {
    public static int solution(int[] ability, int number) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<ability.length; i++){
            pq.offer(ability[i]);
        }

        for(int i=0; i<number; i++){
            int a = pq.poll();
            int b = pq.poll();
            int c = a+b;
            pq.offer(c);
            pq.offer(c);
        }
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] ability = {10, 3, 7, 2};
        int number = 2;
        System.out.println(solution(ability, number));
    }
}
