package com.programmers;

import java.util.*;

class L2_메뉴리뉴얼 {
    static Map<String, Integer> map = new HashMap<>();
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        outer : for(int i=0; i<orders.length; i++){
            for(int j=0; j<course.length; j++){
                if(orders[i].length() < course[j]) continue outer;
                char order[] = orders[i].toCharArray();
                Arrays.sort(order);
                addMap(new String(order), "", course[j], 0);
            }
        }
        List<String> list = new ArrayList<>();
        int max[] = new int[11];
        for (String s : map.keySet()) {
            if(map.get(s) > 1 && max[s.length()] < map.get(s)){
                max[s.length()] = map.get(s);
            }
        }
        for (String s : map.keySet()) {
            if(map.get(s) == max[s.length()]){
                list.add(s);
            }
        }
        Collections.sort(list);
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    private static void addMap(String order, String str,  int course, int cnt) {
        if(str.length() == course){
            if(map.get(str) == null){
                map.put(str, 1);
            }else{
                map.replace(str, map.get(str)+1);
            }
            return;
        }
        for(int i=cnt; i<order.length(); i++){
            addMap(order, str+order.charAt(i), course, i+1);
        }

    }

    public static void main(String[] args) {
//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
//        int[] course = {2,3,5};

        System.out.println(Arrays.toString(solution(orders,course)));

    }
}