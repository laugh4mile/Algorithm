package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G1_1135_뉴스전하기_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, nodeCnt[];
    static List<Integer> graph[];

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
            graph[parent].add(i);
        }

        System.out.println(dfs(0));
//      System.out.println(Arrays.toString(nodeCnt));
    }

    static int dfs(int cur){
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<graph[cur].size(); i++){
            list.add(dfs(graph[cur].get(i)));
        }
        Collections.sort(list, Collections.reverseOrder());
        int max = 0;
        for(int i=0; i<list.size(); i++){
            if(max < list.get(i)+i+1){
                max = list.get(i)+i+1;
            }
        }
        return max;
    }

    static String src =
            "3\n" +
                    "-1 0 0";
}
