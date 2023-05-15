package com.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L2_숫자변환하기 {
//    static int isSelected[];
    static boolean isSelected[];
    static int answer;
    public static int solution(int x, int y, int n) {
//        isSelected = new int[1000001];
        isSelected = new boolean[1000001];
        bfs(x,y,n);
//        bfs(x,y,n, 0);

        if(!isSelected[y]) return -1;
        return answer;
    }

    private static void bfs(int x, int y, int n) {
        Queue<Node> queue = new LinkedList<>();
        isSelected[x] = true;
        queue.offer(new Node(x,0));
        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(front.x == y){
                answer = front.depth;
                return;
            }
            int x1 = front.x+n;
            int x2 = front.x*2;
            int x3 = front.x*3;
            if(x1<=y && !isSelected[x1]){
                isSelected[x1] = true;
                queue.offer(new Node(x1, front.depth+1));
            }
            if(x2<=y && !isSelected[x2]){
                isSelected[x2] = true;
                queue.offer(new Node(x2, front.depth+1));
            }
            if(x3<=y && !isSelected[x3]){
                isSelected[x3] = true;
                queue.offer(new Node(x3, front.depth+1));
            }
        }
    }

    static class Node{
        int x;
        int depth;

        public Node(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }

//    private static void dfs(int cur, int y, int n, int depth) {
//        if(cur > y || cur > 1000000) return;
//        if(isSelected[cur] > depth){
//            isSelected[cur] = depth;
//        }else{
//            return;
//        }
//        dfs(cur+n,y, n, depth+1);
//        dfs(cur*2,y, n, depth+1);
//        dfs(cur*3,y, n, depth+1);
//
//    }

    public static void main(String[] args) {
        int x = 10;
        int y = 1000000;
        int n = 5;
        System.out.println(solution(x, y, n));
    }
}
