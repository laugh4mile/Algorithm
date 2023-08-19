package com.programmers;

import java.util.Arrays;

class L2_피로도 {
    static boolean isSelected[];
    static int result[], answer, K, arr[][];
    public static int solution(int k, int[][] dungeons) {
        arr = new int[dungeons.length][2];
        for(int i=0; i<dungeons.length; i++){
            arr[i] = dungeons[i].clone();
        }
        isSelected = new boolean[dungeons.length];
        result = new int[dungeons.length];
        K = k;
        for(int i=0; i<dungeons.length; i++){
            result[i] = i+1;
        }
        permutation(0);
        return answer;
    }

    private static void permutation(int cnt) {
        if(cnt == result.length){
            int temp = getCount();
            if(answer < temp){
                System.out.println(Arrays.toString(result));
                answer =temp;
            }
            return;
        }
        for(int i=0; i<result.length; i++){
            if(isSelected[i]) continue;
            result[cnt] = i;
            isSelected[i] = true;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }

    private static int getCount() {
        int piro = K;
        int cnt = 0;
        for(int i=0; i<result.length; i++){
            System.out.println(arr[result[i]][0] +" " +arr[result[i]][1]);
            if(piro >= arr[result[i]][0]){
                cnt++;
                piro -= arr[result[i]][1];
            }else{
                break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40},{40,40}};
        System.out.println(solution(k, dungeons));
    }
}