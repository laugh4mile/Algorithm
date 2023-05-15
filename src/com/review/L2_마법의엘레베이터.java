package com.review;

import java.util.LinkedList;
import java.util.Queue;

public class L2_마법의엘레베이터 {
    public static int solution(int storey) {
        int answer = 0;
        answer = bfs(storey);
        return answer;
    }

    private static int bfs(int storey) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(storey, 0));

        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Node front = queue.poll();
//            System.out.println(front.layer + " " +front.cnt);
            if(front.layer == 0){
                min = Math.min(min, front.cnt);
            }
            if(front.layer%10 != 0){
                queue.offer(new Node((front.layer - front.layer%10) / 10, front.cnt+front.layer%10));
                if(front.layer != 1){
                    queue.offer(new Node((front.layer + 10 - front.layer%10) / 10, front.cnt+10 - front.layer%10));
                }
            }else{
                if(front.layer > 0){
                    queue.offer(new Node(front.layer / 10, front.cnt));
                }
            }
        }
        return min;
    }

    static class Node{
        int layer;
        int cnt;

        public Node(int layer, int cnt){
            this.layer = layer;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        int storey = 9994;
        System.out.println(solution(storey));
    }
}
