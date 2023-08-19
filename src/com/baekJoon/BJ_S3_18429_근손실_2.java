package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S3_18429_근손실_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, K, kits[], result[], answer;
    static boolean isSelected[];

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());

        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        kits = new int[N];
        result = new int[N];
        isSelected = new boolean[N];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            kits[i] = Integer.parseInt(tokens.nextToken());
        }

//        System.out.println(Arrays.toString(kits));

        permutation(0);
        System.out.println(answer);
    }

    private static void permutation(int cnt) {
        if(cnt == N){
            if(!isMuscleLoss()){
                answer++;
            }

            return;
        }
        for(int i=0; i<N; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            result[cnt] = kits[i];
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }

    private static boolean isMuscleLoss() {
        int cur = 500;
        for(int i=0; i<N; i++){
            cur += result[i] - K;
            if(cur < 500) return true;
        }
        return false;
    }

    static String src =
            "3 4\n" +
            "3 7 5";
}
