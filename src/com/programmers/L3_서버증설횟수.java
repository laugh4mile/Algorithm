package com.programmers;
import java.util.*;

public class L3_서버증설횟수 {
    public static int solution(int[] players, int m, int k) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<k; i++){
            queue.offer(0);
        }

        int totalServer = 0; // 현재 증설된 서버 총합
        for(int i=0; i<players.length; i++){

            totalServer -= queue.poll();

            int player = players[i];
            int requierServer = 0;

            if(player >= totalServer * m){
                requierServer = (player - totalServer * m) / m;

                queue.offer(requierServer);
                totalServer += requierServer;
                answer      += requierServer;
            }else{
                queue.offer(0);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;

        int answer = solution(players, m, k);

        System.out.println(answer);
    }
}
