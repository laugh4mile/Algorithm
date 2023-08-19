package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_S5_1251_단어나누기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        String word = input.readLine();
        int N = word.length();
        List<String> words = new ArrayList<>();
        for(int i=1; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                StringBuilder sb = new StringBuilder();

                String header = reverse(word.substring(0, i));
                String body = reverse(word.substring(i, j));
                String footer = reverse(word.substring(j));

                sb.append(header);
                sb.append(body);
                sb.append(footer);
                words.add(sb.toString());
            }
        }
        Collections.sort(words);
        System.out.println(words.get(0));
    }

    public static String reverse(String origin){
        StringBuilder sb = new StringBuilder();
        for(int i=origin.length()-1; i>=0; i--){
            sb.append(origin.charAt(i));
        }
        return sb.toString();
    }

    static String src =
            "mobitel";
}
