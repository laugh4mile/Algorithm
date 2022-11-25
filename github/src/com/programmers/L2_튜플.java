package com.programmers;

import java.util.*;

class L2_튜플 {
    public static int[] solution(String s) {
        s = s.substring(1,s.length()-2);
        s = s.replace("{","");
        s = s.replace("},"," ");
        String arr[] = s.split(" ");
        int[] answer = new int[arr.length];

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        Set<String> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            String arr2[] = arr[i].split(",");
            for(int j=0; j<arr2.length; j++){
                if(!set.contains(arr2[j])){
                    set.add(arr2[j]);
                    answer[i] = Integer.parseInt(arr2[j]);
                }
            }
        }

//        System.out.println(s);
//        System.out.println(Arrays.toString(arr));
        return answer;
    }

    public static void main(String[] args) {
        String s = "{{2},{2,1,3,4},{2,1},{2,1,3}}";
        System.out.println(Arrays.toString(solution(s)));
    }
}