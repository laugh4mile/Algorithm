package com.codingtest.junho.woowahan;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    static int[] A = {3,2,-2,5,-3};
    public static void main(String[] args) {
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<A.length; i++){
            set.add(A[i]);
        }
        int max = 0;
        for(int i=0; i<A.length; i++){
            if(set.contains(A[i]*(-1)) && Math.abs(A[i]) > max){
                max = A[i];
            }
        }

        return max;
    }
}
