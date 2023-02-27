package com.programmers;

import java.util.*;

class L2_가장큰수 {
    public static String solution(int[] numbers) {
        String arr[] = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o2.concat(o1).compareTo(o1.concat(o2));
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        if(sb.toString().charAt(0) == '0') return "0";
        return sb.toString();
    }
    public static void main(String[] args) {
//        int[] numbers = {3, 30, 0, 1000,34, 5, 9};
//        int[] numbers = {3, 30, 199, 19,34, 5, 9};
//        int[] numbers = {19,199,822,82,12,2};
//        int[] numbers = {8,88,81,89,899,891};
        int[] numbers = {979, 97, 1000,978, 81, 818, 817}; //9799797881881817
//        int[] numbers = {2, 21, 22, 23, 221, 222, 223};
        System.out.println(solution(numbers));
    }
}