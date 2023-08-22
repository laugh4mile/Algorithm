package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G5_9519_졸려 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int X = Integer.parseInt(input.readLine());
        String word = input.readLine();
        Set<String> set = new HashSet<>();
        int len = word.length();
        List<Character> list = new ArrayList<>();
        List<String> pattern = new ArrayList<>();
        for(int i=0; i<len; i++){
            list.add(word.charAt(i));
        }
        set.add(list.toString());
        pattern.add(list.toString());
        int cycle = 1;
        while(cycle <= X){
            for(int i=len-1; i>=1; i--){
                if(i%2 == 1){
                    char c = list.get(i);
                    list.remove(i);
                    list.add(c);
                }
            }
            if(!set.contains(list.toString())){
                set.add(list.toString());
                pattern.add(list.toString());
            }else{
                break;
            }
            cycle++;
        }
        String answer = pattern.get(X%cycle);
        answer = answer.substring(1,answer.length()-1);
        answer = answer.replace(",","");
        answer = answer.replace(" ","");
        System.out.println(answer);
    }

    static String src =
            "11\n" +
                    "srama";
}
