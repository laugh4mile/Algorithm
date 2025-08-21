package com.review;

import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, Collections.reverseOrder());

        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[col] == o2[col]){
                    return Integer.compare(o2[0], o1[0]);
                }
                return Integer.compare(o1[col], o2[col]);
            }
        });

        for(int[] x: data){
            System.out.println(Arrays.toString(x));
        }


        for(int i=row_begin; i<=row_end; i++){
            long S_i = 0;
        }

        return answer;
    }
}