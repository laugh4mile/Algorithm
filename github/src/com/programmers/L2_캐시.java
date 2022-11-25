package com.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class L2_캐시 {
    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5* cities.length;

        int answer = 0;

        List<String> list = new ArrayList<>();
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();

            if(list.contains(city)){
                list.remove(city);
                list.add(city);
                answer++;
            }else{
                if(list.size() < cacheSize){
                    list.add(city);
                }else{
                    list.remove(0);
                    list.add(city);
                }
                answer+=5;
            }
            System.out.println(list);
        }

        return answer;
    }

    public static void main(String[] args) {
        String arr[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(3, arr));
    }
}