package com.programmers;

import java.util.*;

class L2_프린터 {
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        for(int i=0; i<priorities.length; i++){
            pq.offer(priorities[i]);
            if(i == location){
                queue.offer(new Node(priorities[i],true));
            }else{
                queue.offer(new Node(priorities[i],false));
            }
        }
        while (true){
            if(queue.peek().pr == pq.peek()){
                if(queue.peek().flag){
                    break;
                }else{
                    queue.poll();
                    pq.poll();
                    answer++;
                }
            }else{
                queue.offer(queue.poll());
            }
        }


        return answer;
    }
    static class Node{
        int pr;
        boolean flag;

        public Node(int pr, boolean flag) {
            this.pr = pr;
            this.flag = flag;
        }
    }

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities,location));
    }
}