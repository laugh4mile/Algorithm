package com.programmers;

import java.util.PriorityQueue;

class L2_더맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }

        while(pq.size() > 1 && pq.peek() < K){
            pq.offer(pq.poll() + pq.poll()*2);
            answer++;
        }
        if(pq.peek() < K){
            answer = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville,K));
    }
}