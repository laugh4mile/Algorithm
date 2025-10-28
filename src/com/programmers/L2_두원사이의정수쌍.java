package com.programmers;

public class L2_두원사이의정수쌍 {
    public static long solution(int r1, int r2) {
        long answer = 0;

        for(int x=0; x<=r2; x++){
            long y = (long) Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            answer += y+1;
        }
        for(int x=0; x<r1; x++){
            long y = (long) Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2));
            if(Math.pow(r1, 2) ==  Math.pow(x, 2) + Math.pow(y, 2)){
                answer -= y;
            }else{
                answer -= y+1;
            }
        }

        answer -= r2-r1+1;

        return answer * 4;
    }

    public static void main(String[] args) {
//        int r1 = 2;
//        int r2 = 3;
        int r1 = 25;
        int r2 = 39;

        System.out.println(solution(r1, r2));
    }
}
