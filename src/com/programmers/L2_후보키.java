package com.programmers;

import java.util.*;

public class L2_후보키 {
    static int N, result[];
    static List<int[]> list;
    static String [][] copy;
    public static int solution(String[][] relation) {
        N = relation[0].length;
        list = new ArrayList<int[]>();
        copy = new String[relation.length][relation[0].length];
        for(int i=0; i<relation.length; i++){
            for(int j=0; j<relation[0].length; j++){
                copy[i][j] = relation[i][j];
            }
        }
        for(int r=1; r<=N; r++){
            result = new int[r];
            combination(0, 0, r);
        }

        for(int i=0; i<list.size()-1; i++){
            for(int j=i+1; j<list.size(); j++){
                if(isSubset(list.get(i), list.get(j))){
                    list.remove(j--);
                }
            }
        }
//        for(int i=0; i<list.size(); i++){
//            System.out.println(Arrays.toString(list.get(i)));
//        }

        return list.size();
    }

    private static boolean isSubset(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr1.length; i++){
            if(map.get(arr1[i]) == null){
                map.put(arr1[i],1);
            }else{
                map.replace(arr1[i],map.get(arr1[i])+1);
            }
        }
        for(int i=0; i<arr2.length; i++){
            if(map.get(arr2[i]) == null){
                map.put(arr2[i],1);
            }else{
                map.replace(arr2[i],map.get(arr2[i])+1);
            }
        }
        for(int i=0; i<arr1.length; i++){
            if(map.get(arr1[i]) == 1){
                return false;
            }
        }
        return true;
    }

    private static void combination(int start, int cnt, int r) {
        if(cnt == r){
            if(isKey(result)){
                int[] temp = new int[result.length];
                for(int i=0; i<result.length; i++){
                    temp[i] = result[i];
                }
                list.add(temp);
            }
            return;
        }
        for(int i=start; i<N; i++){
            result[cnt] = i;
            combination(i+1, cnt+1, r);
        }
    }

    private static boolean isKey(int[] result) {
        Map<String, Boolean> map = new HashMap<>();
        for(int i=0; i<copy.length; i++){
            String str = "";
            for(int j=0; j<result.length; j++){
                str += " "+copy[i][result[j]];
            }
            if(map.get(str) == null){
                map.put(str, true);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }
}
