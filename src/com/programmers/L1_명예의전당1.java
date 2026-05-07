package com.programmers;

import java.util.PriorityQueue;

public class L1_명예의전당1 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<score.length; i++){
            if(pq.size() <= k){
                pq.offer(score[i]);
            }

            if(pq.size() > k){
                pq.poll();
            }

            answer[idx++] = pq.peek();
        }

        return answer;
    }
}
