package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G5_15591_MooTube {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static boolean isVisited[];
    static List<Node> graph[];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int Q = Integer.parseInt(tokens.nextToken());

        graph = new List[N+1];
        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int n=0; n<N-1; n++){
            tokens = new StringTokenizer(input.readLine());
            int p = Integer.parseInt(tokens.nextToken());
            int q = Integer.parseInt(tokens.nextToken());
            int r = Integer.parseInt(tokens.nextToken());
            graph[p].add(new Node(q,r));
            graph[q].add(new Node(p,r));
        }

        for(int q=0; q<Q; q++){
            tokens = new StringTokenizer(input.readLine());
            int k = Integer.parseInt(tokens.nextToken());
            int v = Integer.parseInt(tokens.nextToken());

            isVisited = new boolean[N+1];
            int videos = getRecomndedVideos(k, v);
            System.out.println(videos);
        }
    }

    private static int getRecomndedVideos(int k, int v) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(v, Integer.MAX_VALUE));
        isVisited[v] = true;
        int cnt = 0;

        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(front.u >= k){
                cnt++;
            }else{
                continue;
            }
            List<Node> childs = graph[front.node];
            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);
                if(!isVisited[child.node]){
                    isVisited[child.node] = true;
                    if(child.u < front.u){
                      queue.offer(child);
                    }else{
                        queue.offer(new Node(child.node, front.u));
                    }
                }
            }
        }
        return cnt-1;
    }

    static class Node {
        int node;
        int u;

        public Node(int node, int u){
            this.node = node;
            this.u = u;
        }
    }

    static String src =
            "4 3\n" +
            "1 2 3\n" +
            "2 3 2\n" +
            "2 4 4\n" +
            "1 2\n" +
            "4 1\n" +
            "3 1";
}
