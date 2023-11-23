package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_1911_흙길보수하기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, L;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        L = Integer.parseInt(tokens.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            int s = Integer.parseInt(tokens.nextToken());
            int e = Integer.parseInt(tokens.nextToken());
            pq.offer(new Node(s, e));
        }
        int cur = 0, cnt = 0, answer = 0;
        while(!pq.isEmpty()){
            Node front = pq.poll();
            if(cur <= front.s){
                cnt = (int)Math.ceil((double)(front.e-front.s)/L);
                answer += cnt;
                cur = front.s + cnt * L;
            }else{
                if(cur >= front.e) continue;
                cnt = (int)Math.ceil((double)(front.e-cur)/L);
                answer += cnt;
                cur = cur + cnt * L;
            }
        }
        System.out.println(answer);
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
            return Integer.compare(this.s, o.s);
        }
    }

    static String src =
            "3 3\n" +
                    "1 6\n" +
                    "13 17\n" +
                    "8 12";
}
