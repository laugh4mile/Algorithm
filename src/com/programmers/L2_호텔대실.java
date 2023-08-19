package com.programmers;

import java.util.*;

public class L2_호텔대실 {
    public static int solution(String[][] book_time) {
        int answer = 0;

        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });
        Queue<Node> costomers = new LinkedList<>();
        for(int i=0; i< book_time.length; i++){
            String st = book_time[i][0];
            int sh = Integer.parseInt(st.substring(0,2));
            int sm = Integer.parseInt(st.substring(3,5));
            String et = book_time[i][1];
            int eh = Integer.parseInt(et.substring(0,2));
            int em = Integer.parseInt(et.substring(3,5));

            costomers.offer(new Node(sh*60+sm, eh*60+em+10));
        }

        PriorityQueue<Node> useRoom = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.endTime, o2.endTime);
            }
        });

        for(int t=0; t<1440; t++){
            while(!costomers.isEmpty() && costomers.peek().startTime <= t){
                useRoom.offer(costomers.poll());
            }

            while(!useRoom.isEmpty() && useRoom.peek().endTime < t){
                useRoom.poll();
            }
            answer = Math.max(answer, useRoom.size());
        }

        return answer;
    }

    static class Node{
        int startTime;
        int endTime;

        public Node(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }

    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"},{"16:40", "18:20"},{"14:20", "15:20"},{"14:10", "19:20"},{"18:20", "21:20"}};
        System.out.println(solution(book_time));
    }
}
