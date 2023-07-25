package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_S2_5567_결혼식 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static List<Integer> graph[];
    static boolean isVisited[];
    static int n, m;
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        n = Integer.parseInt(input.readLine());
        m = Integer.parseInt(input.readLine());
        isVisited = new boolean[n+1];
        graph = new List[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        isVisited[1] = true;
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue = new LinkedList<>();
        queue.offer(new Node(1, 0));
        isVisited[1] = true;
        int sum = 0;
        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(front.depth == 1 || front.depth == 2){
                sum++;
            }
            if(front.depth > 2) break;
            List<Integer> childs = graph[front.no];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(new Node(child, front.depth+1));
                }
            }
        }
        return sum;
    }

    static class Node{
        int no;
        int depth;

        public Node(int no, int depth){
            this.no = no;
            this.depth = depth;
        }
    }

    static String src =
            "6\n" +
                    "5\n" +
                    "2 3\n" +
                    "3 4\n" +
                    "4 5\n" +
                    "5 6\n" +
                    "2 5";
}
