package com.codingtest.devmatching.test4_20220402;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q3 {

    static int[][] dist = {{0,5,2,4,1},{5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}};

    public static void main(String[] args) {
        for(int[] x : solution(dist)){
            System.out.println(Arrays.toString(x));
        }
    }

    public static int[][] solution(int[][] dist) {
        int N = dist.length;
        int[][] answer = new int[2][N];
        int edgeE = 0;
        int maxDistance = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(dist[r][c] > maxDistance){
                    maxDistance = dist[r][c];
                    edgeE = Math.max(r,c);
                }
            }
        }
        List<Node> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(new Node(i,dist[edgeE][i]));
        }
//        System.out.println(list);
        Collections.sort(list);
//        System.out.println(list);
        for(int c=0; c<N; c++){
            answer[0][c] = list.get(c).no;
        }
        for(int c=0; c<N; c++){
            answer[1][c] = list.get(N-1-c).no;
        }
        return answer;
    }

    static class Node implements Comparable<Node>{
        int no;
        int distance;

        public Node(int no, int distance) {
            this.no = no;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", distance=" + distance +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.distance, this.distance);
        }
    }
}
