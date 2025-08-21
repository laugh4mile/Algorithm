package com.review;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
//        System.out.println(Arrays.toString(new int[]{1,2}));

        Integer[] answer = list.toArray(new Integer[2]);
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        List<String> temp1 = new ArrayList<>(list2);
        System.out.println(temp1.get(0));
        temp1.set(0, "zz");
        System.out.println(list2);
        System.out.println(temp1);
        System.out.println(Arrays.toString(answer));
    }
}