package com.codingtest.junho.kakaoEnterprise;

import java.io.*;
import java.util.*;

public class Q4 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N,M;
    static List<Integer> graph[];
    static List<Integer> graphReverse[];
    static boolean isVisited[];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        graph = new List[N+1];
        graphReverse = new List[N+1];

        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
            graphReverse[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            graph[from].add(to);
            graphReverse[to].add(from);
        }

        int answer = 0;
        for(int i=1; i<N+1; i++){
            isVisited = new boolean[N+1];
            if(bfs(i) + bfsReverse(i) == N+1){
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static int bfsReverse(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;
        int cnt = 0;

        while (!queue.isEmpty()){
            cnt++;
            int front = queue.poll();
            List<Integer> childs = graphReverse[front];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(child);
                }
            }
        }
        return cnt;
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;
        int cnt = 0;

        while (!queue.isEmpty()){
            cnt++;
            int front = queue.poll();
            List<Integer> childs = graph[front];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(child);
                }
            }
        }
        return cnt;
    }

    static String src =
            "5 5\n" +
            "4 3\n" +
            "4 2\n" +
            "3 2\n" +
            "1 2\n" +
            "2 5";
}
