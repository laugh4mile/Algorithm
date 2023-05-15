package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G1_1800_인터넷설치 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N,P,K;
    static int distance[];
    static boolean isVisited[];
    static List<Node> graph[];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        P = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        graph = new List[N+1];
        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<P; i++){
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            int val = Integer.parseInt(tokens.nextToken());
            graph[from].add(new Node(to,val));
            graph[to].add(new Node(from,val));
        }

        int left = 0;
        int right = 1000000;
        int mid = 0;
        int answer = 0;

        while(left <= right){
            mid = (left + right) / 2;

            if(dijkstra(mid)){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(distance[N] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }

    private static boolean dijkstra(int mid) {
        isVisited = new boolean[N+1];
        distance = new int[N+1]; // distance[i] = 1번에서 i번까지 mid값 보다 큰 경로의 수
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        distance[1] = 0;

        while(!pq.isEmpty()){
            Node front = pq.poll();
            if(!isVisited[front.no]){
                isVisited[front.no] = true;

                List<Node> childs = graph[front.no];
                for(int i=0; i<childs.size(); i++){
                    Node child = childs.get(i);
                    int cost = 0;
                    if(child.val > mid){
                        cost = 1;
                    }else{
                        cost = 0;
                    }
                    if(distance[child.no] > distance[front.no] + cost){
                        distance[child.no] = distance[front.no] + cost;
                        pq.offer(new Node(child.no, distance[child.no]));
                    }
                }
            }
        }

        if(distance[N] <= K){ // mid값보다 큰 경로가 K개 이하일 경우 --> mid 값을 더 낮춰도 됨
            return true;
        }else{ // mid값보다 큰 경로가 K개 초과일 경우 --> mid 값을 더 높여야 됨
            return false;
        }
    }

    static class Node implements Comparable<Node>{
        int no;
        int val;

        public Node(int no, int val) {
            this.no = no;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.val, o.val);
        }
    }

    static String src =
            "5 7 1\n" +
            "1 2 5\n" +
            "3 1 4\n" +
            "2 4 8\n" +
            "3 2 3\n" +
            "5 2 9\n" +
            "3 4 7\n" +
            "4 5 6";
}
