package com.programmers;

import java.util.Arrays;

class L3_최고의집합 {
    public static int[] solution(int n, int s) {
        int[] answer = {-1};
        if(n > s){
            return answer;
        }

        answer = new int[n];
        int a = s / n;
        int b = s % n;
        Arrays.fill(answer, a);
        for(int i=n-b; i<n; i++){
            answer[i]++;
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(12,11)));
    }
}