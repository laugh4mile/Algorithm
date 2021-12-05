package com.codingtest.kakao.recommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3 {
    static List<Integer> arr = new ArrayList<>();
    static int x = 3;
    public static void main(String[] args) {
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(0);
        arr.add(0);
        arr.add(10);
        solution(arr, x);
    }

    public static int solution(List<Integer> arr, int x) {

        if(x == 1)return arr.size(); // x가 1이면 뭐든 가능함. 이게 tc11이었군!

        boolean isSelected[] = new boolean[100002]; // 0~100001

        int mods[] = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            mods[i] = arr.get(i) % x;
        }
        Arrays.sort(mods);
        for(int i=0; i<mods.length; i++){
            int idx = mods[i];
            while(idx < 100002 && isSelected[idx]){
                idx += x;
            }
            if(idx < 100002){
                isSelected[idx] = true;
            }
        }

        for(int i=0; i<100002; i++){
            if(!isSelected[i]){
                return i;
            }
        }

        return -1;
    }
}
