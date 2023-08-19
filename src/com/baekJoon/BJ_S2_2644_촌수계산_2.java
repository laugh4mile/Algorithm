package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_S2_2644_촌수계산_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static boolean isVisited[];
    static List<Integer> graph[];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int n = Integer.parseInt(input.readLine());
        graph = new List[n+1];
        isVisited = new boolean[n+1];
        for(int i=1; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        tokens = new StringTokenizer(input.readLine());
        int start = Integer.parseInt(tokens.nextToken());
        int end = Integer.parseInt(tokens.nextToken());

        int m = Integer.parseInt(input.readLine());

        for(int i=0; i<m; i++){
            tokens = new StringTokenizer(input.readLine());

            int parent = Integer.parseInt(tokens.nextToken());
            int child = Integer.parseInt(tokens.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }

        System.out.println(bfs(start, end));
    }

    private static int bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        isVisited[start] = true;

        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(front.no == end){
                return front.depth;
            }
            List<Integer> childs = graph[front.no];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(new Node(child, front.depth+1));
                }
            }
        }
        return -1;
    }

    static class Node{
        int no;
        int depth;

        public Node(int no, int depth) {
            this.no = no;
            this.depth = depth;
        }
    }

    static String src =
            "9\n" +
                    "8 6\n" +
                    "7\n" +
                    "1 2\n" +
                    "1 3\n" +
                    "2 7\n" +
                    "2 8\n" +
                    "2 9\n" +
                    "4 5\n" +
                    "4 6";
}
