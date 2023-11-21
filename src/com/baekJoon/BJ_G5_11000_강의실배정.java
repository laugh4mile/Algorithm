package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G5_11000_강의실배정 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        List<Node> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            int s = Integer.parseInt(tokens.nextToken());
            int e = Integer.parseInt(tokens.nextToken());
            list.add(new Node(s, e));
        }
        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<list.size(); i++){
            Node node = list.get(i);
            if(pq.isEmpty()){
                pq.offer(node.e);
            }else{
                if(pq.peek() <= node.s){
                    pq.poll();
                }
                pq.offer(node.e);
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
            if(this.s == o.s){
                return Integer.compare(this.e, o.e);
            }
            return Integer.compare(this.s, o.s);
        }
    }

    static String src =
            "3\n" +
            "1 3\n" +
            "2 4\n" +
            "3 5";
}
