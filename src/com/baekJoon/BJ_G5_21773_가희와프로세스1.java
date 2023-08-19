package com.baekJoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_21773_가희와프로세스1 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int T = Integer.parseInt(tokens.nextToken());
        int N = Integer.parseInt(tokens.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            int id = Integer.parseInt(tokens.nextToken());
            int t = Integer.parseInt(tokens.nextToken());
            int prio = Integer.parseInt(tokens.nextToken());

            pq.offer(new Node(id, t, prio));
        }

        for(int i=0; i<T; i++){
            Node front = pq.poll();
            output.append(front.id+"\n");
            if(front.t > 1){
                pq.offer(new Node(front.id, --front.t, --front.prio));
            }
        }
        output.close();
    }

    static class Node implements Comparable<Node>{
        int id;
        int t;
        int prio;

        public Node(int id, int t, int prio) {
            this.id = id;
            this.t = t;
            this.prio = prio;
        }

        @Override
        public int compareTo(Node o){
            if(this.prio == o.prio){
                return Integer.compare(this.id, o.id);
            }
            return Integer.compare(o.prio, this.prio);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", t=" + t +
                    ", prio=" + prio +
                    '}';
        }
    }

    static String src =
            "8 2\n" +
            "1 2 1\n" +
            "2 5 1";
}
