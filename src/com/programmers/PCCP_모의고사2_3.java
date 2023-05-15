package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PCCP_모의고사2_3 {
    public static int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        int t = 0;
        Queue<Node> costomers = new LinkedList<>();

        for(int i=0; i<order.length; i++){
            costomers.offer(new Node(i*k, menu[order[i]]));
        }

        Queue<Node> watings = new LinkedList<>();
        boolean isWating = false;

        int N = 0;
        while (!costomers.isEmpty() || !watings.isEmpty()){
            answer = Integer.max(answer, watings.size()+N);

            if(!watings.isEmpty()){
                isWating = true;
                t += watings.poll().runningTime;
            }else{
                isWating = false;
                t = costomers.peek().arriveTime;
            }


            if(!costomers.isEmpty() && costomers.peek().arriveTime == t){
                N = 0;
                watings.offer(costomers.poll());
            }else{
                while(!costomers.isEmpty() && costomers.peek().arriveTime < t){
                    watings.offer(costomers.poll());
                }
                N = 1;
            }
        }

        return answer;
    }
    static class Node{
        int arriveTime;
        int runningTime;

        public Node(int arriveTime, int runningTime) {
            this.arriveTime = arriveTime;
            this.runningTime = runningTime;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "arriveTime=" + arriveTime +
                    ", runningTime=" + runningTime +
                    '}';
        }
    }

    public static void main(String[] args) {
//        int[] menu = {5, 12, 30};
//        int[] order = {1, 2, 0, 1};
//        int k = 10;

        int[] menu = {5, 12, 30};
        int[] order = {2, 1, 0, 0, 0, 1, 0};
        int k = 10;

//        int[] menu = {5};
//        int[] order = {0,0,0,0,0};
//        int k = 5;
        System.out.println(solution(menu, order, k));
    }
}
