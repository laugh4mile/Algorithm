package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_S3_2606_바이러스_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static List<Integer> graph[];
    static boolean isVisited[];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(str));
        int computers = Integer.parseInt(input.readLine());
        graph = new List[computers+1];
        isVisited = new boolean[computers+1];
        for(int i=1; i<computers+1; i++){
            graph[i] = new ArrayList<>();
        }
        int connections = Integer.parseInt(input.readLine());

        for(int i=0; i<connections; i++){
            tokens = new StringTokenizer(input.readLine());

            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(bfs(1));

    }

    private static int bfs(int virusComputer) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(virusComputer);
        isVisited[virusComputer] = true;

        while(!queue.isEmpty()){
            int front = queue.poll();

            List<Integer> childs = graph[front];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(child);
                    cnt++;
                }
            }
        }
        List<Integer> list = graph[virusComputer];

        return cnt;
    }

    static String str =
            "7\n" +
            "6\n" +
            "1 2\n" +
            "2 3\n" +
            "1 5\n" +
            "5 2\n" +
            "5 6\n" +
            "4 7";
}
