// https://school.programmers.co.kr/learn/courses/30/lessons/131701?language=java
package com.programmers;

import java.util.HashSet;
import java.util.Set;

class L2_연속부분수열합의개수 {
    public int solution(int[] elements) {
        int answer = 0;

        int size = elements.length;
        int[] temp = new int[size*2];
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<size; i++){
            temp[i] = elements[i];
            temp[i+size] = elements[i];
            set.add(elements[i]);
        }

        // System.out.println(Arrays.toString(temp));

        int[] sum = new int[size*2];

        sum[0] = temp[0];
        for(int i=1; i<size*2; i++){
            sum[i] = sum[i-1] + temp[i];
        }
        // System.out.println(Arrays.toString(sum));

        for(int i=0; i<size; i++){
            for(int j=1; j<=size; j++){
                set.add(sum[i+j]-sum[i]);
            }
        }

        answer = set.size();


        return answer;
    }
}