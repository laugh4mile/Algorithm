package com.programmers;

import java.util.Arrays;

public class L2_줄서는방법 {
    static boolean isSelected[];
    static int result[];
    static int answer[];
    static long K, count;
    public static int[] solution(int n, long k) {
        answer = new int[n];
        result = new int[n];
        isSelected = new boolean[n];
        K = k;
        permutation(0,n);
        return answer;
    }

    private static void permutation(int cnt, int n) {
        if(cnt == n){
            count++;
            if(count==K){
                for(int i=0; i<n; i++){
                    answer[i] = result[i];
                }
            }
            return;
        }
        for(int i=0; i<n; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            result[cnt] = i+1;
            permutation(cnt+1, n);
            isSelected[i] = false;

        }
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        System.out.println((Arrays.toString(solution(n,k))));
    }
}
