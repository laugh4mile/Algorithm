package com.programmers;

import java.util.Arrays;

class L2_행렬의곱셈 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int r=0; r<arr1.length; r++){
            for(int c=0; c<arr2[0].length; c++){
                for(int i=0; i<arr2.length; i++){
                    answer[r][c] += arr1[r][i] * arr2[i][c];
                }
            }
        }
        for(int[] x : answer){
            System.out.println(Arrays.toString(x));
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr1[][] = {{1, 4}, {3, 2}, {4, 1}};
        int arr2[][] = {{3,3},{3,3}};
        System.out.println(solution(arr1,arr2));
    }
}