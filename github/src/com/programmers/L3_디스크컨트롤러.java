package com.programmers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class L3_디스크컨트롤러 {
    public static int solution(int[][] jobs) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Node> pq1 = new PriorityQueue(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.requestTime== o2.requestTime){
                    return Integer.compare(o1.workTime, o2.workTime);
                }
                return Integer.compare(o1.requestTime,o2.requestTime);
            }
        });

        PriorityQueue<Node> pq2 = new PriorityQueue(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.workTime == o2.workTime){
                    return Integer.compare(o1.requestTime, o2.requestTime);
                }
                return Integer.compare(o1.workTime, o2.workTime);
            }
        });

        for(int i=0; i<jobs.length; i++){
            pq1.offer(new Node(jobs[i][0], jobs[i][1]));
        }

        int curTime = 0;

        int totalTime = 0;
        while (!pq1.isEmpty() || !pq2.isEmpty()){
            if(pq2.isEmpty()){ // && curTime <= pq1.peek().requestTime

                totalTime += pq1.peek().workTime;
                curTime = pq1.peek().requestTime+ pq1.poll().workTime;
            }else{
                totalTime += curTime-pq2.peek().requestTime + pq2.peek().workTime;
                curTime += pq2.poll().workTime;
            }
            while (!pq1.isEmpty() && curTime >= pq1.peek().requestTime){
                pq2.offer(pq1.poll());
            }
        }

        return totalTime/jobs.length;
    }

    static class Node {
        int requestTime;
        int workTime;

        public Node(int r, int w){
            this.requestTime = r;
            this.workTime = w;
        }
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3},{1, 9},{2, 6}};
        System.out.println(solution(jobs));
    }
}
