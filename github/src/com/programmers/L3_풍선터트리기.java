package com.programmers;

import java.util.Arrays;

public class L3_풍선터트리기 {
    public static int solution(int[] a) {
        int answer = 0;

        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i=0; i<a.length; i++){
            if(min > a[i]){
                min = a[i];
                minIdx = i;
            }
        }

        int leftMin = Integer.MAX_VALUE;
        for(int i=0; i<minIdx; i++){
            if(a[i] < leftMin){
                leftMin = a[i];
                answer++;
            }
        }

        int rightMin = Integer.MAX_VALUE;
        for(int i=a.length-1; i>=minIdx; i--){
            if(a[i] < rightMin){
                rightMin = a[i];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, 1, 5}));
        System.out.println(solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }
}
