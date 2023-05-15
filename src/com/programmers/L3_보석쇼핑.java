package com.programmers;

import java.util.*;

class L3_보석쇼핑 {
    public static int[] solution(String[] gems) {
        int[] answer = {1, gems.length+1};

        Set<String> set = new HashSet<>();

        for(int i=0; i<gems.length; i++){
            set.add(gems[i]);
        }
        int size = set.size();
        set.clear();
        int start = 0;
        int end = gems.length;
        for(int i=0; i<gems.length; i++){
            set.add(gems[i]);
            if (set.size() == size) {
                end = i;
                set.clear();
                for(int j=end; j>=start; j--){
                    set.add(gems[j]);
                    if(set.size() == size){
                        start = j;
                        break;
                    }
                }
                set.clear();
                if(end - start < answer[1] - answer[0]){
                    answer[0] = start+1;
                    answer[1] = end+1;
                }
                if(end - start + 1 == size){
                    answer[0] = start+1;
                    answer[1] = end+1;
                    break;
                }
                i=start;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }
}