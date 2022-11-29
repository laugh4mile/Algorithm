package com.programmers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class L2_할인행사 {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wantMap.put(want[i],number[i]);
        }
//        System.out.println(wantMap);
        Map<String, Integer> map = new HashMap<>();

        String head;
        boolean flag = false;
        head = discount[0];
        for(int i=0; i<9; i++){ // 9개를 넣고 시작하자
            if(map.get(discount[i]) == null){
                map.put(discount[i],1);
            }else{
                map.replace(discount[i],map.get(discount[i])+1);
            }
        }
        outer : for(int i=9; i<discount.length; i++){
            if(map.get(discount[i]) == null){
                map.put(discount[i],1);
            }else{
                map.replace(discount[i],map.get(discount[i])+1);
            }
            for(int j=0; j<want.length; j++){
                if(map.get(want[j]) == null || map.get(want[j]) < wantMap.get(want[j])){
                    map.replace(head, map.get(head)-1);
                    head = discount[i-8];
                    continue outer;
                }
            }
            map.replace(head, map.get(head)-1);
            head = discount[i-8];
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want,number,discount));
    }
}