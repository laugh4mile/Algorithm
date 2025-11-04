package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class L2_조이스틱 {
    public static int solution(String name) {
        int answer = 0;

        int size = name.length();
        int[] arr = new int[size];

        int loop = 0;
        for(int i=0; i<size; i++){
            arr[i] = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            if(arr[i] != 0){
                loop++;
            }
        }

        dfs(arr, 0, 0, loop);

        return answer;
    }

    private static void dfs(int[] arr, int sum, int cnt, int loop) {
        if(cnt == loop){
            System.out.println(sum);
            return;
        }
        for(int i=0; i<arr.length; i++){

        }
    }


    static class Node{
        int idx;
        int move;

        public Node(int idx, int move){
            this.idx  = idx;
            this.move = move;
        }
    }

    public static void main(String[] args) {
        String name = "JEROEN";
//        String name = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println(solution(name)); // answer: 56
    }
}
