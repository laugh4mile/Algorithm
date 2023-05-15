package com.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class L2_영어끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        int a = 0;
        int b = 0;
        String preWord = words[0];
        set.add(preWord);
        boolean flag = false;
        for(int i=1; i<words.length; i++){
            a = i%n;
            b = i/n+1;
            String word = words[i];
            if(set.contains(word) || preWord.charAt(preWord.length()-1) != word.charAt(0)){
                flag = true;
                break;
            }else{
                preWord = word;
                set.add(word);
            }
        }

        if(flag){
            answer[0] = a+1;
            answer[1] = b;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(3, words)));
    }
}