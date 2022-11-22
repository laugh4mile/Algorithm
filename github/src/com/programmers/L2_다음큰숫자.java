package com.programmers;

class L2_다음큰숫자 {
    public static int solution(int n) {
        int answer = n;
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for(int i=0; i<binaryString.length(); i++){
            if(binaryString.charAt(i) == '1'){
                count++;
            }
        }

        while(true){
            answer++;
            String temp = Integer.toBinaryString(answer);
            int tempCount = 0;
            for(int i=0; i<temp.length(); i++){
                if(temp.charAt(i) == '1'){
                    tempCount++;
                }
            }
            if(tempCount == count){
                return answer;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(78));
    }
}