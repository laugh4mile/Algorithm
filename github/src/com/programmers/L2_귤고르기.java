package com.programmers;

import java.util.*;

class L2_귤고르기 {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            if(map.get(tangerine[i]) == null){
                map.put(tangerine[i], 1);
            }else{
                map.replace(tangerine[i], map.get(tangerine[i])+1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            list.add(map.get(integer));
        }
        Collections.sort(list, Collections.reverseOrder());

        for(int i=0; i<list.size(); i++){
            k -= list.get(i);
            if(k <= 0){
                return i+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k,tangerine));
    }
}