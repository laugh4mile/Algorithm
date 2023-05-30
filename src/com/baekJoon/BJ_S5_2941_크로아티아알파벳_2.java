package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_S5_2941_크로아티아알파벳_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        String word = input.readLine();

        List<String> list = new ArrayList<>();
        list.add("c=");
        list.add("c-");
        list.add("dz=");
        list.add("d-");
        list.add("lj");
        list.add("nj");
        list.add("s=");
        list.add("z=");

        for(int i=0; i<list.size(); i++){
            if(word.contains(list.get(i))){
                word = word.replaceAll(list.get(i), "0");
            }
        }

        System.out.println(word.length());
    }

    static String src =
            "dz=ak";
}
