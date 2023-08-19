package com.programmers;

import java.util.Arrays;

public class L3_입국심사 {
    public static long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        Arrays.sort(times);
        long right = (long)n * times[0];
        long mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(checkPass(n, times, mid)){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }

    private static boolean checkPass(int n, int[] times, long mid) {
        long cnt = 0;
        for(int i=0; i<times.length; i++){
            cnt += mid / times[i];
            if(cnt >= n){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10,21};
        System.out.println(solution(n, times));
    }
}
