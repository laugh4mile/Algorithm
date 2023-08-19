package com.programmers;

public class L2_멀쩡한사각형 {
    public static long solution(int w, int h) {
        if(w == 1 || h == 1){
            return 0;
        }
        long answer = (long)w*h;

        if(w == h) {
            answer -= w;
            return answer;
        }

        int gcd = getGCD(w, h);
        int miniW = w/gcd;
        int miniH = h/gcd;

        int unUseableSquare = miniH + miniW - 1;

        return answer - unUseableSquare*gcd;
    }

    private static int getGCD(int a, int b) {
        if(b == 0){
            return a;
        }else{
            return getGCD(b, a%b);
        }
    }


    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w,h));
    }
}
