package com.programmers;

import java.util.*;

public class L2_배달 {


    List<Node> graph[];
    int distance[];
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new List[N+1];
        distance = new int[N+1];
        for(int i=1; i<=N; i++){
            distance[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int val = road[i][2];
            graph[from].add(new Node(to, val));
            graph[to].add(new Node(from, val));
        }
        distance[1] = 0;
        dijkstra(1);

        System.out.println(Arrays.toString(distance));

        return (int) Arrays.stream(distance)
                .filter(x -> x <= K)
                .count()-1;
    }

    private void dijkstra(int start) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(start);

        while(!pq.isEmpty()){
            int front = pq.poll();

            List<Node> childs = graph[front];
            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);

                if(distance[child.t] > distance[front] + child.l){
                    distance[child.t] = distance[front] + child.l;
                    pq.offer(child.t);
                }
            }
        }

    }

    class Node{
        int t;
        int l;

        public Node(int t, int l){
            this.t = t;
            this.l = l;
        }
    }
}
