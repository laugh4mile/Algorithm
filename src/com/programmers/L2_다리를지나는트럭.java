package com.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class L2_다리를지나는트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int cur = 0;
        for(int i=0; i<bridge_length; i++){
            queue.offer(0);
        }
        for(int i=0; i< truck_weights.length; i++){
            answer++;
            cur -= queue.poll();
            if(cur+truck_weights[i] <= weight){
                cur += truck_weights[i];
                queue.offer(truck_weights[i]);
            }else{
                queue.offer(0);
                i--;
            }
        }

        return answer+bridge_length;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}