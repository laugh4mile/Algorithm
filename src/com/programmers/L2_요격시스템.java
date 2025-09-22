package com.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class L2_요격시스템 {
    public static int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o2[0]){
//                    return o1[1] - o2[1];
//                }
                return o1[1] - o2[1];
            }
        });
        for(int[] x : targets){
            System.out.println(Arrays.toString(x));
        }
        System.out.println();
        if(targets.length == 1){
            return 1;
        }

        int end = targets[0][1];

        for(int i=1; i<targets.length; i++){
            if(targets[i][0] >= end){
                System.out.println(Arrays.toString(targets[i]));
                answer++;
                end = targets[i][1];
            }
        }
        return answer+1;
    }

    public static void main(String[] args) {
        int[][] targets = {{4,5}, {4,8}, {10,14}, {11,13}, {5,12}, {3,7}, {1,4}};
        int[][] targets2 = {{650,750},{650,750},{650,750}};
        System.out.println(solution(targets));
    }
}
