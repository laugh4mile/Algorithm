package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G1_2213_트리의독립집합 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, vals[], dp[][];
    static List<Integer>[] graph;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static boolean isVisited[];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        vals = new int [N+1];
        dp = new int[N+1][2];
        isVisited = new boolean[N+1];
        graph = new List[N+1];

        tokens = new StringTokenizer(input.readLine());
        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
            vals[i] = Integer.parseInt(tokens.nextToken());
        }
        while(true){
            String line = input.readLine();
            if(line == null){
                break;
            }
            tokens = new StringTokenizer(line);
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        dfs(1);
        output.append(Integer.max(dp[1][0], dp[1][1])+"\n");
        if(dp[1][0] < dp[1][1]){
            getNodes(1,0,true);
        }else{
            getNodes(1,0,false);
        }
        while(!pq.isEmpty()){
            output.append(pq.poll()+" ");
        }
        output.close();
    }

    private static void getNodes(int cur, int parent, boolean isAttend) {
        List<Integer> childs = graph[cur];

        if(isAttend){
            pq.offer(cur);
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(child == parent) continue;
                getNodes(child, cur, false);
            }
        }else{
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(child == parent) continue;
                if(dp[child][0] < dp[child][1]){
                    getNodes(child,cur,true);
                }else{
                    getNodes(child,cur,false);
                }
            }
        }
    }


    private static void dfs(int cur) {
        isVisited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = vals[cur];

        List<Integer> childs = graph[cur];
        for(int i=0; i<childs.size(); i++){
            int child = childs.get(i);

            if(!isVisited[child]){
                dfs(child);
                dp[cur][0] += Integer.max(dp[child][0], dp[child][1]);
                dp[cur][1] += dp[child][0];
            }
        }
    }

    static String src =
            "7\n" +
            "10 30 40 10 20 20 70\n" +
            "1 2\n" +
            "2 3\n" +
            "4 3\n" +
            "4 5\n" +
            "6 2\n" +
            "6 7";
}
