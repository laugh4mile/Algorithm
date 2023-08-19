package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

public class BJ_S5_1316_그룹단어체커_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Set<Character> set;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        int answer = 0;
        for(int i=0; i<N; i++){
            String word = input.readLine();
            set = new HashSet<>();
            if(isGruopWord(word)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isGruopWord(String word) {
        char cur = '0';
        for(int j = 0; j< word.length(); j++){
            if(word.charAt(j) != cur){
                cur = word.charAt(j);
                if(!set.contains(cur)){
                    set.add(cur);
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    static String src =
            "3\n" +
            "happy\n" +
            "new\n" +
            "year";
}
