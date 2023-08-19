package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G2_1949_우수마을 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    static int N, residents[], dp[][];
    static List<Integer> graph[];
    static boolean isVisited[];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());

        residents = new int[N+1];
        dp = new int[N+1][2];
        graph = new List[N+1];
        isVisited = new boolean[N+1];

        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        tokens = new StringTokenizer(input.readLine());
        for(int i=1; i<N+1; i++){
            residents[i] = Integer.parseInt(tokens.nextToken());
        }

        for(int i=0; i<N-1; i++){
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }
        dfs(1);

        System.out.println(Integer.max(dp[1][0], dp[1][1]));

    }

    private static void dfs(int cur) {
        isVisited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = residents[cur];

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
            "1000 3000 4000 1000 2000 2000 7000\n" +
            "1 2\n" +
            "2 3\n" +
            "4 3\n" +
            "4 5\n" +
            "6 2\n" +
            "6 7";
}
