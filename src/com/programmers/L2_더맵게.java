package com.programmers;

import java.util.PriorityQueue;

class L2_더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }

        while(pq.size() > 1){
            if(pq.peek() >= K){
                break;
            }
            int first  = pq.poll();
            int second = pq.poll();

            pq.offer(first+second*2);
            answer++;
        }

        if(pq.peek() >= K){
            return answer;
        }

        return -1;
    }
}