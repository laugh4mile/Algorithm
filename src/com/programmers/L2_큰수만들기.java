package com.programmers;

class L2_큰수만들기 {

    static int temp;

    public static String solution(String number, int k) {
        String answer = "";

        int max = -1;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<number.length(); i++){
            System.out.println(i+" "+k);
            max = -1;
            if(k == number.length()-i) break;
            for(int j=i; j<i+k+1; j++){
                if(number.charAt(j) - '0'> max){
                    max = number.charAt(j)  - '0';
                    idx = j;
                }
            }
            k-= idx - i;
            i = idx;
            System.out.println(idx+" --- "+number.charAt(i));
            sb.append(number.charAt(i));
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        String number = "535501";
        int k = 3;
        System.out.println(solution(number,k));
    }
}