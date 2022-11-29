package com.programmers;

import java.util.ArrayList;
import java.util.List;

class L2_모음사전 {
    static List<String> list;
    static char[] arr = {'A','E','I','O','U'};
    public static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            dfs(0, arr[i], "");
        }
//        System.out.println(list);
        answer = list.indexOf(word);
        return answer;
    }

    private static void dfs(int cnt, char ch, String word) {
        list.add(word);
        if(cnt == 5){
            return;
        }
        for(int i=0; i<arr.length; i++){
//            word = word+arr[i];
            dfs(cnt+1, arr[i], word+arr[i]);
//            word = word.substring(0,word.length()-1);
        }
    }

    public static void main(String[] args) {
        String word = "I";
        System.out.println(solution(word));
    }
}