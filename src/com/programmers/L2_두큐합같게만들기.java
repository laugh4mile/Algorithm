package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class L2_두큐합같게만들기 {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;

        for(int i=0; i<queue1.length; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1+=queue1[i];
            sum2+=queue2[i];
        }
        while (sum1 != sum2 && answer < queue1.length*2){
            if(q1.isEmpty() || q2.isEmpty()) return -1;
            if(sum1 > sum2){
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.offer(q1.poll());
            }else if(sum1 < sum2){
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.offer(q2.poll());
            }
            answer++;
        }
        if(answer == queue1.length*2) return -1;

        return answer;
    }

    public static void main(String[] args) {
//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};
        int[] queue1 = {101, 100};
        int[] queue2 = {102, 103};
        System.out.println(solution(queue1,queue2));
    }
}
