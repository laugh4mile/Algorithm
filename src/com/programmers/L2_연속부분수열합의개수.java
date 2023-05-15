package com.programmers;

import java.util.HashSet;
import java.util.Set;

class L2_연속부분수열합의개수 {
    public static int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int[] temp = new int[elements.length*2-1];
        for(int i=0; i<temp.length; i++){
            temp[i] = elements[i%elements.length];
        }
//        System.out.println(Arrays.toString(temp));
        for(int size=1; size<elements.length; size++){ // 부분수열의 길이가 i 일때 합. 총길이는 1개 라서 필요없을듯
            for(int i=0; i<elements.length; i++){ // 시작 idx
                int sum = 0;
                for(int j=i; j<i+size; j++){
                    sum += temp[j];
                }
                set.add(sum);
            }
        }
        return set.size()+1;
    }

    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        System.out.println(solution(elements));
    }
}