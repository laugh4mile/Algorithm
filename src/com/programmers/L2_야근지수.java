package com.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

class L2_야근지수 {
    public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        System.out.println(pq);
        while(n>0){
            pq.offer(pq.poll()-1);
            n--;
        }

        while (!pq.isEmpty()){
            int work = pq.poll();
            if(work > 0){
                answer+=Math.pow(work,2);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] works = {4, 3, 3};
        System.out.println(solution(4, works));
    }
}