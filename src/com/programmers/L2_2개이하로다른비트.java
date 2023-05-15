package com.programmers;

import java.util.Arrays;

class L2_2개이하로다른비트 {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] < 2){
                answer[i] = numbers[i]+1;
                continue;
            }
            String binaryNum = Long.toString(numbers[i],2);
            if(!binaryNum.substring(binaryNum.length()-2).equals("11")){
                answer[i] = numbers[i]+1;
            }else{
                double a = Math.log10(numbers[i]+1)/Math.log10(2);
                if(a%1 == 0){
                    answer[i] = (long) (Math.pow(2, a) + Math.pow(2, a-1) -1);
                    continue;
                }
                int cnt = 0;
                for(int j=binaryNum.length()-1; j>=0; j--){
                    if(binaryNum.charAt(j) != '1'){
                        break;
                    }
                    cnt++;
                }
                answer[i] = (long) (numbers[i] + Math.pow(2, cnt) - Math.pow(2,cnt-1));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        long[] numbers = {17179869184l, 137438953472l, 1099511627776l, 17592186044416l, 140737488355328l};
//        long[] numbers = {140737488355328l, 281474976710656l, 562949953421312l};
        long[] numbers = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        System.out.println(Arrays.toString(solution(numbers)));
    }
}