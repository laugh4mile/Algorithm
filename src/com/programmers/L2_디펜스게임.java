package com.programmers;
import java.util.*;

public class L2_디펜스게임 {
    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if(enemy.length <= k){
            answer = enemy.length;
        }else{
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            int i = 0;
            for(i=0; i<enemy.length; i++){
                pq.offer(enemy[i]);

                if(n >= enemy[i]){
                    n -= enemy[i];
                }else{
                    if(k > 0){
                        n -= enemy[i];
                        n += pq.poll();
                        k--;
                    }else{
                        break;
                    }
                }
                System.out.println(pq);
                System.out.println(n);
                System.out.println();

            }
            answer = i;
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};

        int answer = solution(n, k, enemy);

        System.out.println(answer);
    }
}
