package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G1_1135_뉴스전하기_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, nodeCnt[], max;
    static List<Node> graph[];

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());

        nodeCnt = new int[N];
        graph = new List[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            int parent = Integer.parseInt(tokens.nextToken());
            if (i == 0) continue;
            graph[parent].add(new Node(i, 0));
        }

        dfs(0);
//      System.out.println(Arrays.toString(nodeCnt));
        System.out.println(max);
    }

    static int dfs(int cur){
        for(int i=0; i<graph[cur].size(); i++){
            graph[cur].get(i).time = dfs(graph[cur].get(i).node);
        }
        return 0;
    }

    static class Node implements Comparable<Node>{
        int node;
        int time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.time, this.time);
        }
    }

    static String src =
            "24\n" +
                    "-1 0 0 1 1 1 2 2 3 3 4 4 5 5 6 7 7 8 12 13 14 16 16 16";
}
