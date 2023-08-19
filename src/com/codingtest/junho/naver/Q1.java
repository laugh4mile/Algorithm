package com.codingtest.junho.naver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1 {
    static String S = "ACAX";
    public static void main(String[] args) {
        System.out.println(solution(S));
    }

    public static int solution(String S){
        Map<Character, Integer> map = new HashMap<>();

        int left[] = new int[S.length()];
        int right[] = new int[S.length()];

        for(int i=0; i<S.length(); i++){ // 왼쪽에서 오른쪽
            char cur = S.charAt(i);

            if(map.get(cur) == null){ // 없으면
                left[i] = i+1;
            }else{
                left[i] = i - map.get(cur) + 1;
            }
            map.put(cur, i+1); // 현재 cur이 나온 최신 위치를 계속 갱신
        }

        map.clear();

        for(int i=S.length()-1; i>=0; i--){ // 오른쪽에서 왼쪽
            char cur = S.charAt(i);

            if(map.get(cur) == null){
                right[i] = S.length() - i;
            }else{
                right[i] = S.length() - i - map.get(cur) ;
            }
            map.put(cur, S.length() - i);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int answer = 0;

        for(int i=0; i<left.length; i++){
            answer += (left[i] * right[i]) %1000;
        }

        return answer;
    }
}
