package com.programmers;

import java.util.HashSet;
import java.util.Set;

public class L2_롤케이크자르기 {
    public static int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int[] count = new int[topping.length];
        int[] countReverse = new int[topping.length];

        for(int i=0; i<topping.length; i++){
            set.add(topping[i]);
            count[i] = set.size();
        }
        set.clear();
        for(int i=topping.length-1; i>=0; i--){
            set.add(topping[i]);
            countReverse[i] = set.size();
        }

        for(int i=0; i<topping.length-1; i++){
            if(count[i] == countReverse[i+1]) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
//        int[] topping = {1, 2, 3, 1, 4};
        System.out.println(solution(topping));
    }
}
