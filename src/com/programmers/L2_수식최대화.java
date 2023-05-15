package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Long.parseLong;

class L2_수식최대화 {
    static String result[] = new String[3];
    static String opers[] = {"+","-","*"};
    static long answer;
    static boolean isSelected[] = new boolean[3];
    static List<String> original = new ArrayList<>();
    public static long solution(String expression) {

        original = convertToList(expression);
        permutation(0);
        return answer;
    }

    private static List<String> convertToList(String expression) {
        int startIdx = 0;
        for(int i=0; i<expression.length(); i++){
            if(!Character.isDigit(expression.charAt(i))){
               original.add(expression.substring(startIdx,i));
               original.add(expression.charAt(i)+"");
               startIdx = i+1;
            }
        }
        original.add(expression.substring(startIdx));
        return original;
    }

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }

    static void permutation(int cnt){
        if(cnt == 3){
            getMaxAnswer(result);
            return;
        }
        for(int i=0; i<3; i++){
            if(isSelected[i]) continue;
            result[cnt] = opers[i];
            isSelected[i] = true;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }

    private static void getMaxAnswer(String[] opers) {
        List<String> copy = new ArrayList<>();
        for(int i=0; i< original.size(); i++){
            copy.add(original.get(i));
        }
        for(int i=0; i<opers.length; i++){
            for(int j=0; j<copy.size(); j++){
                if(opers[i].equals(copy.get(j))){
                    String temp = calculate(copy.get(j-1), opers[i], copy.get(j+1));
                    copy.remove(--j);
                    copy.remove(j);
                    copy.set(j,temp);
                }
            }
        }

        if(Math.abs(Long.parseLong(copy.get(0))) > answer){
            answer = Math.abs(Long.parseLong(copy.get(0)));
        }
    }

    private static String calculate(String num1, String oper, String num2) {
        Long longNum1 = Long.parseLong(num1);
        Long longNum2 = Long.parseLong(num2);
        Long result = 0l;
        if(oper.equals("+")){
            result = longNum1+longNum2;
        }else if(oper.equals("-")){
            result = longNum1-longNum2;
        }else{
            result = longNum1*longNum2;
        }

        return Long.toString(result);
    }
}