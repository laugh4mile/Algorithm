// PGM - 43238 L3_입국심사
// 이분탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java
package com.programmers;

import java.util.Arrays;

public class L3_입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;

        long temp = (long)n * times[0]; // 일단 얘보단 작거나 같을거임.

        long left  = 0;
        long right = temp;
        long mid   = 0;

        while(left<right){
            mid = (left+right)/2;
            // System.out.println(left+" "+mid+" "+right);

            if(isPosible(mid, n, times)){ // 쌉가능이면 right 줄이기.
                right = mid;
            }else{ // 불가능이면 left 늘리기
                left = mid+1;
            }
        }
        // System.out.println(left+" "+mid+" "+right);

        answer = right;

        return answer;
    }

    boolean isPosible(long mid, int n, int[] times){
        long sum = 0;

        for(int i=0; i<times.length; i++){
            sum += mid / times[i]; // 각 감독관이 mid 시간 안에 심사할수 있는 사람의 수
        }

        if(sum >= n){
            return true;
        }else{
            return false;
        }
    }
}
