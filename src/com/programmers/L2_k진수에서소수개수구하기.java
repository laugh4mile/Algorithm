package com.programmers;

import java.util.Arrays;
import java.util.StringTokenizer;

class L2_k진수에서소수개수구하기 {
    public static int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n,k);
        StringTokenizer tokens = new StringTokenizer(str,"0");
        while (tokens.hasMoreTokens()) {
            if(isPrime(Long.parseLong(tokens.nextToken()))){
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPrime(long num){
        if(num == 1) return false;
        if(num == 2) return true;
        for(int i=2; i<Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(437674,3));
    }
}