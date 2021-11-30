package com.codingtest.snow;

public class Q2 {
    static int num = 42940124;
    public static void main(String[] args) {
        System.out.println(solution(num));
    }
    public static int solution(int num) {
        while (true){
            if(((int)Math.log10(num)+1) % 2 == 1){ // num이 2의 배수여야만 함
                num++;
            }else if(compare(num)){ // num이 조건을 만족하면 종료
                break;
            }else{ // 2의 배수이면서 조건을 만족하지 못하면 +1
                num++;
            }
        }
        return num;
    }

    private static boolean compare(int num) {
        int len = (int)Math.log10(num)+1;
        int prefix = 1;
        int idx = 0;
        for(int i=0; i<len/2; i++){
            prefix *= (int)((num % Math.pow(10, len-i)) / Math.pow(10, len-1-i));
        }
        int suffix = 1;
        for(int i=len/2; i<len; i++){
            suffix *= (int)((num % Math.pow(10, len-i)) / Math.pow(10, len-1-i));
        }
        if(prefix == suffix) return true;
        return false;
    }
}
