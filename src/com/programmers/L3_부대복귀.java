package com.programmers;
import java.util.*;

public class L3_부대복귀 {

    static List[] graph;
    static int[] result;
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        graph = new List[n+1];
        result = new int[n+1];
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
            result[i] = -1;
        }

        for(int i=0; i<roads.length; i++){
            int from = roads[i][0];
            int to   = roads[i][1];

            graph[from].add(to);
            graph[to].add(from);
        }

//        for(int i=0; i<sources.length; i++){
//            int source = sources[i];
//
//            isVisited = new boolean[n+1];
//            int min = bfs(source, destination);
//
//            answer[i] = min;
//        }
        isVisited = new boolean[n+1];
        bfs(destination);

        for(int i=0; i<sources.length; i++){
            answer[i] = result[sources[i]];
        }
        return answer;
    }

    private static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        isVisited[start] = true;

        while (!queue.isEmpty()){
            Node front = queue.poll();
            result[front.area] = front.time;

            List<Integer> childs = graph[front.area];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    queue.offer(new Node(child, front.time+1));
                    isVisited[child] = true;
                }
            }

        }
    }

    static class Node{
        int area;
        int time;

        public Node(int area, int time){
            this.area = area;
            this.time = time;
        }
    }

    static boolean isVisited[];

    public static void main(String[] args) {
        int n = 5;
        int[][] road = {{1, 2},{1, 4},{2, 4},{2, 5},{4, 5}};
        int[] sources = {1,3,5};
        int destination = 5;

        int answer[] = solution(n, road, sources, destination);

        System.out.println(Arrays.toString(answer));
    }
}
