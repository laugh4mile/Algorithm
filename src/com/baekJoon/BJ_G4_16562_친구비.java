package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G4_16562_친구비 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, M, k, costOfFriendship[];
    static List<Integer> graph[];
    static boolean isVisited[];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());

        costOfFriendship = new int[N+1];
        tokens = new StringTokenizer(input.readLine());
        for(int i=1; i<N+1; i++){
            costOfFriendship[i] = Integer.parseInt(tokens.nextToken());
        }
        graph = new List[N+1];
        isVisited = new boolean[N+1];

        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            tokens = new StringTokenizer(input.readLine());

            int v = Integer.parseInt(tokens.nextToken());
            int w = Integer.parseInt(tokens.nextToken());

            if(v==w || graph[v].contains(w) || graph[w].contains(v)) continue;

            graph[v].add(w);
            graph[w].add(v);
        }

        int totalCost = 0;
        for(int i=1; i<N+1; i++){
            if(!isVisited[i]){
                totalCost += getMinCost(i);
                if(totalCost > k){
                    System.out.println("Oh no");
                    return;
                }
            }
        }
        System.out.println(totalCost);
    }

    private static int getMinCost(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;
        int minCost = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            int front = queue.poll();
            if(costOfFriendship[front] < minCost){
                minCost = costOfFriendship[front];
            }

            List<Integer> friends = graph[front];
            for(int i=0; i<friends.size(); i++){
                int friend = friends.get(i);
                if(!isVisited[friend]){
                    isVisited[friend] = true;
                    queue.offer(friend);
                }
            }
        }

        return minCost;
    }

    static String src =
            "5 3 10\n" +
                    "10 10 20 20 30\n" +
                    "1 3\n" +
                    "2 4\n" +
                    "5 4";
}
