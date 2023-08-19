package com.programmers;

import java.util.Arrays;

class L2_n2배열자르기 {
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int cnt = 0;
        long r=0, c=0;
        for(long i=left; i<=right; i++){
            r = i/n;
            c = i%n;
            if(r >= c){
                answer[cnt++] = (int)r+1;
            }else{
                answer[cnt++] = (int)c+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,2,5)));
    }
}