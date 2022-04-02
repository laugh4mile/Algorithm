package com.codingtest.sk.skt.second;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String arr[] = {"1","2","4","3","3","4","1","5"};
        String strArr = Arrays.stream(arr).collect(Collectors.joining());
        System.out.println(strArr);
    }
}
