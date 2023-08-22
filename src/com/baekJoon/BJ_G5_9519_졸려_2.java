package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G5_9519_졸려_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int X = Integer.parseInt(input.readLine());
        StringBuilder word = new StringBuilder(input.readLine());
        Set<String> set = new HashSet<>();
        int len = word.length();
        set.add(word.toString());
        List<String> list = new ArrayList<>();
        list.add(word.toString());
        int cnt = 1;
        char c;
        while(cnt <= len){
            for(int i=len-1; i>0; i--){
                if(i%2 == 1){
                  c = word.charAt(i);
                  word.deleteCharAt(i);
                  word.append(c);
                }
            }
            if(!set.contains(word.toString())) {
                set.add(word.toString());
                list.add(word.toString());
            }else{
                break;
            }
            cnt++;
        }
        System.out.println(list.get(X%cnt));
    }

    static String src =
            "11\n" +
                    "srama";
}
