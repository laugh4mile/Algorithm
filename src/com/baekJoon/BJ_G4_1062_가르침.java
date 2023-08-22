package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_1062_가르침 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, K, answer;
    static char result[];
    static String words[];
    static boolean isTaught[] = new boolean[26];
    static List<Character> chars = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        isTaught['a'-'a'] = true;
        isTaught['n'-'a'] = true;
        isTaught['t'-'a'] = true;
        isTaught['i'-'a'] = true;
        isTaught['c'-'a'] = true;
        if(K<5){
            System.out.println(0);
            return;
        } else if (K == 26){
            System.out.println(N);
            return;
        } else{
            words = new String[N];
            for(int i=0; i<N; i++){
                String word = input.readLine();
                word = word = word.replace("a","");
                word = word.replace("t","");
                word = word.replace("i","");
                word = word.replace("c","");
                word = word.replace("n","");
                words[i] = word;
                for(int j=0; j<words[i].length(); j++){
                    if(!chars.contains(words[i].charAt(j))){
                        chars.add(words[i].charAt(j));
                    }
                }
            }
            if(chars.size() <= K-5){
                System.out.println(N);
                return;
            }
            combination(0,0);
            System.out.println(answer);
        }
    }

    private static void combination(int start, int cnt) {
        if(cnt == K-5){
            int sum = 0;
            for(int i=0; i<N; i++){
                boolean readable = true;
                for(int j=0; j<words[i].length(); j++){
                    if(!isTaught[words[i].charAt(j) - 'a']){
                        readable = false;
                        break;
                    }
                }
                if(readable) sum++;
            }
            answer = Math.max(answer, sum);
            return;
        }
        for(int i=start; i<chars.size(); i++){
            isTaught[chars.get(i)-'a'] = true;
            combination(i+1, cnt+1);
            isTaught[chars.get(i)-'a'] = false;
        }
    }

    static String src =
            "9 8\n" +
                    "antabtica\n" +
                    "antaxtica\n" +
                    "antadtica\n" +
                    "antaetica\n" +
                    "antaftica\n" +
                    "antagtica\n" +
                    "antahtica\n" +
                    "antajtica\n" +
                    "antaktica";
}
