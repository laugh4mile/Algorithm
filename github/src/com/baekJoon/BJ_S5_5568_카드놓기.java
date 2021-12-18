package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_5568_카드놓기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, K,arr[], result[];
    static boolean isSelected[];
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
        System.out.println(Arrays.toString(arr));
        permutation(0);

    }

    private static void permutation(int cnt) {
        if(cnt == K){
            System.out.println(Arrays.toString(result));
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
            "4\n" +
            "2\n" +
            "1\n" +
            "2\n" +
            "12\n" +
            "1";
}
