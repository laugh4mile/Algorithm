package com.codingtest.softeer;

import java.io.*;
import java.util.*;

public class Q2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        tokens = new StringTokenizer(input.readLine());
        List<Node> list = new ArrayList<>();

        for(int i=1; i<=N; i++){
            list.add(new Node(i, Integer.parseInt(tokens.nextToken())));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });
        for(int i=0; i<list.size(); i++){
            output.append(list.get(i).idx+" ");
        }
        output.close();
    }
    static class Node{
        int idx;
        int num;

        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", num=" + num +
                    '}';
        }
    }

    static String src =
            "3\n" +
                    "2 3 1";
}
