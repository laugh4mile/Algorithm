package com.baekJoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_S5_5568_카드놓기_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, K,arr[], result[];
    static boolean isSelected[];
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        K = Integer.parseInt(input.readLine());
        arr = new int[N];
        isSelected = new boolean[N];
        result = new int[K];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(input.readLine());
        }
//        System.out.println(Arrays.toString(arr));
        permutation(0);
        System.out.println(set.size());

    }

    private static void permutation(int cnt) {
        if(cnt == K){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<K; i++){
                sb.append(result[i]);
            }
            set.add(sb.toString());
            return;
        }
        for(int i=0; i<N; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            result[cnt] = arr[i];
            permutation(cnt+1);
            isSelected[i] = false;

        }
    }

    static String src =
            "6\n" +
                    "3\n" +
                    "72\n" +
                    "2\n" +
                    "12\n" +
                    "7\n" +
                    "2\n" +
                    "1";
}
