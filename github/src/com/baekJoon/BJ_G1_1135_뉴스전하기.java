package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G1_1135_뉴스전하기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, nodeCnt[], max;
    static List<Integer> graph[];
    static List<Node> graph2[];

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());

        nodeCnt = new int[N];
        graph = new List[N];
        graph2 = new List[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            int parent = Integer.parseInt(tokens.nextToken());
            if (i == 0) continue;
            graph[parent].add(i);
        }

        dfs(0);
//        System.out.println(Arrays.toString(nodeCnt));

        for(int i=0; i<N; i++){
            for(int j=0; j<graph[i].size(); j++){
                int no = graph[i].get(j);
                graph2[i].add(new Node(no, nodeCnt[no], 0));
            }
            Collections.sort(graph2[i]);
//            System.out.println(graph2[i]);
        }

        bfs();
        System.out.println(max);
    }

    private static void dfs(int cur) {
        nodeCnt[cur] = 1;
        List<Integer> childs = graph[cur];
        for(int i=0; i<childs.size(); i++){
            int child = childs.get(i);
            dfs(child);
            nodeCnt[cur] += nodeCnt[child];
        }
    }

    private static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, N,0));

        while(!pq.isEmpty()){
            Node front = pq.poll();
//            System.out.println(front);
            int curTime = front.time;
            if(curTime > max){
                max = curTime;
            }
            List<Node> childs = graph2[front.no];
            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);
                pq.offer(new Node(child.no, nodeCnt[child.no], ++curTime));
            }
        }
    }

    private static class Node implements Comparable<Node>{

        int no;
        int nodeCnt;
        int time;
        public Node(int no, int nodeCnt, int time) {
            this.no = no;
            this.nodeCnt = nodeCnt;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(o.nodeCnt, this.nodeCnt);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", nodeCnt=" + nodeCnt +
                    ", time=" + time +
                    '}';
        }

    }

    static String src =
            "24\n" +
                    "-1 0 0 1 1 1 2 2 3 3 4 4 5 5 6 7 7 8 12 13 14 16 16 16";
}
