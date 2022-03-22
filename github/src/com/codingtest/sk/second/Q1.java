package com.codingtest.sk.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1 {
//    static String[] goods = {"pencil","cilicon","contrabase","picturelist"};
    static String[] goods = {"abcdeabcd","cdabe","abce","bcdeab"};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(goods)));
    }
    public static String[] solution(String[] goods) {
        String[] answer = new String[goods.length];
        for(int i=0; i<goods.length; i++){
            String good = goods[i];
            String subString;
            List<String> list = new ArrayList<>();
            int min = 10000; // goods 원소의 길이보다 커야함.
            boolean flag = false;
            for(int j=1; j<=good.length(); j++){ // j 는 subString의 길이
                for(int k=0; k<good.length()-j+1; k++){
                    subString = good.substring(k,j+k);
                    if(isUnique(subString, i, goods)) {
                        if(min > j){
                            flag = true;
                            min = j;
                            list.add(subString);
                        }else if(min == j){
                            if(!list.contains(subString)){
                                list.add(subString);
                            }
                        }
                    }
//                    System.out.println(j+" "+subString);
                }
                if(flag){
                    break;
                }
            }
            Collections.sort(list);
//            System.out.println(list);
            StringBuilder sb = new StringBuilder();
            if(list.size() > 0){
                for(int j=0; j<list.size(); j++){
                    if(j==0){
                        sb.append(list.get(j));
                    }else{
                        sb.append(" "+list.get(j));
                    }
                }
            }else{
                sb.append("None");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    private static boolean isUnique(String el, int cur, String[] goods) {
        for(int i=0; i<goods.length; i++){
            if(i == cur) continue;
            if(goods[i].contains(el)){
                return false;
            }
        }
        // el이 나만 가지고 있는 문자열인경우
        return true;
    }
}
