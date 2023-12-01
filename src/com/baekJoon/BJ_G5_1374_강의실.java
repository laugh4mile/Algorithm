package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G5_1374_강의실 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        List<Node> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            tokens.nextToken();
            int s = Integer.parseInt(tokens.nextToken());
            int e = Integer.parseInt(tokens.nextToken());
            list.add(new Node(s, e));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<list.size(); i++){
            Node cur = list.get(i);
            if(pq.isEmpty()){
                pq.offer(cur.e);
            }else{
                if(pq.peek() <= cur.s){
                    pq.poll();
                    pq.offer(cur.e);
                }else{
                    pq.offer(cur.e);
                }
            }
        }
        System.out.println(pq.size());
    }

    static class Node implements Comparable<Node>{
        int s;
        int e;

        public Node(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node o){
            if (this.s == o.s){
                return Integer.compare(this.e, o.e);
            }
            return Integer.compare(this.s, o.s);
        }
    }

    static String src =
            "8\n" +
                    "6 15 21\n" +
                    "7 20 25\n" +
                    "1 3 8\n" +
                    "3 2 14\n" +
                    "8 6 27\n" +
                    "2 7 13\n" +
                    "4 12 18\n" +
                    "5 6 20";
}
