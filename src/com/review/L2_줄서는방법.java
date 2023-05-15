package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2_줄서는방법 {
    public static int[] solution(int n, long k) {
        int answer[] = new int[n];
        long factorial[] = new long[n];

        factorial[0] = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<n; i++){
            list.add(i);
            factorial[i] = factorial[i-1] * (i+1);
        }
        list.add(n);
        k--;
        n--;

        List<Integer> answerList = new ArrayList<>();
        while(n>0){
            long idx = k / factorial[--n];
            k = k % factorial[n];
            answerList.add(list.get((int)idx));
            list.remove((int)idx);
        }
        answerList.add(list.get(0));
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        System.out.println(Arrays.toString(solution(n,k)));
    }
}
