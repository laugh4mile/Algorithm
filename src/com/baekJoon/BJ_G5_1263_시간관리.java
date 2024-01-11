package com.baekJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_1263_시간관리 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        //현수야 이직하려고?
        List<Node> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            int T = Integer.parseInt(tokens.nextToken());
            int S = Integer.parseInt(tokens.nextToken());
            list.add(new Node(T, S));
        }
        Collections.sort(list);

        int sumT = 0;
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<list.size(); i++){
            sumT += list.get(i).t;
            if(sumT > list.get(i).s){
                System.out.println(-1);
                return;
            }
            answer = Math.min(answer, list.get(i).s - sumT);
        }
        System.out.println(answer);
    }
    static class Node implements Comparable<Node>{
        int t;
        int s;

        public Node(int t, int s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.s, o.s);
        }
    }

    static String src =
            "4\n" +
            "3 5\n" +
            "8 14\n" +
            "5 20\n" +
            "1 16";
}