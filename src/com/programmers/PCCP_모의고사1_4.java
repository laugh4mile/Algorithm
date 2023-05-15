package com.programmers;

import java.util.*;

public class PCCP_모의고사1_4 {
    public static long[] solution(int[][] program) {
        long[] answer = new long[11];
        Arrays.sort(program, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<program.length; i++){
            queue.offer(new Node(program[i][0],program[i][1],program[i][2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        long t = 0;

        while(!queue.isEmpty() || !pq.isEmpty()){
            if(!pq.isEmpty()){
                answer[pq.peek().score] += t - pq.peek().callTime;
                t += pq.poll().runningTime;
            }else{
                t = queue.peek().callTime;
            }
            while(!queue.isEmpty() && queue.peek().callTime <= t){
                pq.offer(queue.poll());
            }
        }
        answer[0] = t;
        return answer;
    }

    static class Node implements Comparable<Node>{
        int score;
        int callTime;
        int runningTime;

        public Node(int score, int callTime, int runningTime) {
            this.score = score;
            this.callTime = callTime;
            this.runningTime = runningTime;
        }

        @Override
        public int compareTo(Node o) {
            if(this.score == o.score){
                return Integer.compare(this.callTime, o.callTime);
            }
            return Integer.compare(this.score, o.score);
        }
    }


    public static void main(String[] args) {
        int[][] program = {{2, 0, 10},{1, 5, 5},{3, 5, 3},{3, 12, 2}};
        System.out.println(Arrays.toString(solution(program)));
    }
}
