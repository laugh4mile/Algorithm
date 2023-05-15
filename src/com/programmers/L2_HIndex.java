package com.programmers;

import java.util.Arrays;

class L2_HIndex {
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        for(int h=0; h<n; h++){
            if(citations[n-h-1] >= h+1){
                answer = h+1;
            }
//            0 1 2 3 4

//            1 2 3 4 5
//            0 4 4 5 6
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }
}