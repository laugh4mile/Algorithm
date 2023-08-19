package com.codingtest.junho.woowahan;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4 {
    static int[]A = {1,1,1,4};
    static int[]B = {2,2,3,4,5};
    public static void main(String[] args) {
        System.out.println(solution(A,B));
    }

    static int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            System.out.println(A[k] + " " + B[i]);
            while (i < m - 1 && B[i] < A[k]) {
                i += 1;
            }
            if (A[k] == B[i]) {
                return A[k];
            }
        }
        return -1;
    }
}
