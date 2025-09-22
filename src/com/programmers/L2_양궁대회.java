package com.programmers;

import java.util.*;

public class L2_양궁대회 {
    public static int[] solution(int n, int[] info) {
        int[] result = new int[11];

        solve(10, 0, n, result, info);
//        System.out.println(count);
        if(answer == null){
            return new int[]{-1};
        }

        return answer;
    }

    static int start;
    static int[] answer;

    private static void solve(int start, int cnt, int n, int[] result, int[] info) {
        if(cnt == n){
//            count++;
            System.out.println(Arrays.toString(result));
            getMax(info, result);
            return;
        }
        if(start == -1){
            return;
        }
        result[start]++;
        solve( start, cnt+1, n, result, info);
        result[start]--;
        solve( start-1, cnt, n, result, info);
    }

    private static void getMax(int[] info, int[] result) {
        int a = 0;
        int b = 0;
        for(int i=0; i<info.length; i++){
            if(info[i]==0 && result[i]==0) continue;
            if(info[i] >= result[i]){
                a += 10-i;
            }else{
                b += 10-i;
            }
        }
        if(b > a){
            if(b-a > max){ // 무조건 나중에 나온애가 답 아닌가?
                max = b-a;
                answer = new int[result.length];
                answer = result.clone();

            }
        }
    }

    static int max;

    static int count;

    public static void main(String[] args) {
        int n = 10;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int n2 = 9;
        int[] info2 = {0,0,1,2,0,1,1,1,1,1,1};
        int n3 = 3;
        int[] info3 = {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1};

//        System.out.println(Arrays.toString(solution(n, info)));
//        System.out.println(Arrays.toString(solution(n2, info2)));
        System.out.println(Arrays.toString(solution(n3, info3)));
    }
}
