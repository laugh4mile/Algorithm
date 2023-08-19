package com.programmers;

class L2_N진수게임 {
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int curNo = 0;
        int tubeCnt = 0;
        int totalCnt = 0;
        while(tubeCnt < t){ // tube가 말한 횟수
            String str = Integer.toString(curNo++, n); // 현재 숫자를 n진수 문자열로 변환
            for(int i=0; i<str.length(); i++){
                if(totalCnt++ % m == p-1){
//                    System.out.println(curNo + " " + str + " " + tubeCnt);
                    sb.append(Character.toUpperCase(str.charAt(i)));
                    tubeCnt++;
                    if(tubeCnt == t){
                        break;
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(16,16,2,1));
    }
}