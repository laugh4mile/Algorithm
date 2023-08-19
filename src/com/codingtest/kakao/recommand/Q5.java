package com.codingtest.kakao.recommand;

import java.util.*;

public class Q5 {
    static List<Integer> graph[], edgeList;
    static boolean isVisited[];
    static int answer[];
    public static List<Integer> solution(int treeNodes, List<Integer> treeFrom, List<Integer> treeTo) {
        if(treeNodes == 1){

        }
        graph = new List[treeNodes+1];
        isVisited = new boolean[treeNodes+1];
        for(int i=1; i<treeNodes+1; i++){
            graph[i] = new LinkedList<>();
        }
        for(int i=0; i<treeFrom.size(); i++){
            graph[treeFrom.get(i)].add(treeTo.get(i));
            graph[treeTo.get(i)].add(treeFrom.get(i));
        }

        edgeList = new ArrayList<>();
        int d = getFarthestNodesDistance(1);

        answer = new int[treeNodes+1];
        bfs(1,d);

        d = getFarthestNodesDistance(edgeList.get(0));

        bfs(edgeList.get(0),d);

        List<Integer> answerList = new ArrayList<>();
        for(int i=1; i<answer.length; i++){
            if(answer[i] == 1){
                answerList.add(1);
            }else{
                answerList.add(0);
            }
        }
        return answerList;
    }

    static void bfs(int startNode, int target){
        Arrays.fill(isVisited, false); // isVisited 초기화
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startNode,0));
        isVisited[startNode] = true;
        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(front.v == target){
                edgeList.add(front.node);
                answer[front.node] = 1;
            }
            List<Integer> childs = graph[front.node];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(new Node(child, front.v+1));
                }
            }
        }
    }

    static int getFarthestNodesDistance(int startNode){
        Arrays.fill(isVisited, false); // isVisited 초기화
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startNode,0));
        isVisited[startNode] = true;
        int maxDistance = 0;
        while(!queue.isEmpty()){
            Node front = queue.poll();
            maxDistance = Math.max(maxDistance, front.v);
            List<Integer> childs = graph[front.node];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                if(!isVisited[child]){
                    isVisited[child] = true;
                    queue.offer(new Node(child, front.v+1));
                }
            }
        }
        return maxDistance;
    }

    static class Node{
        int node;
        int v;

        public Node(int node, int v){
            this.node = node;
            this.v = v;
        }
    }
}
