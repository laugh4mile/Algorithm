package com.programmers;

import java.util.Arrays;
import java.util.Collections;

class L2_최솟값만들기
{
    public static int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int N = A.length;
        for(int i=0; i<N; i++){
            answer += A[i] + B[N-1-i];
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution());
    }
}