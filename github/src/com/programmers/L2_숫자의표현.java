package com.programmers;

class L2_숫자의표현 {
    public static int solution(int n) {
        int answer = 0;

        for(int i=1; i<n+1; i++){
            int sum = 0;
            for(int j=i; j<n+1; j++){
                sum += j;
                if(sum == n){
                    answer++;
                }else if(sum > n){
                    sum = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}