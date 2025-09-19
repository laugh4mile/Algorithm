package com.programmers;

import java.util.Arrays;

public class L2_비밀코드해독 {
    public static int solution(int n, int[][] q, int[] ans) {
        int[] result = new int[5];
        combi(0, 0, n, q, ans, result);
        return answer;
    }

    static int answer;

    private static void combi(int start, int cnt, int n, int[][] q, int[] ans, int[] result) {
        if(cnt == 5){
            if(isMatched(q, ans, result)){
                answer++;
            }
            return;
        }
        for(int i=start; i<n; i++){
            result[cnt] = i+1;
            combi(i+1, cnt+1, n, q, ans, result);
        }
    }

    private static boolean isMatched(int[][] q, int[] ans, int[] result) {
        boolean flag = true;

        for(int i=0; i<q.length; i++){
            if(getCnt(q[i], result) != ans[i]){
                flag = false;
                break;
            }
        }

        return flag;
    }

    private static int getCnt(int[] q, int[] result) {
        int cnt = 0;
        int start = 0;
        for(int i=0; i<result.length; i++){
            for(int j=start; j<q.length; j++){
                if(result[i] == q[j]){
                    cnt++;
                    start = j;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n  = 15;
        int[][] q = {{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}};
        int[] ans = {2, 1, 3, 0, 1};


        int n2  = 10;
        int[][] q2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans2 = {2, 3, 4, 3, 3};

//        System.out.println(solution(n, q, ans));
        System.out.println(solution(n2, q2, ans2));
    }
}
