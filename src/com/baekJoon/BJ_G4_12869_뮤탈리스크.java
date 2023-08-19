package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_12869_뮤탈리스크 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int answer = Integer.MAX_VALUE;
    static int scvs[], size;
    static boolean isVisited[][][];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        scvs = new int[3];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            scvs[i] = Integer.parseInt(tokens.nextToken());
        }
        size = 61;
        isVisited = new boolean[size][size][size];

        solve(scvs[0], scvs[1], scvs[2], 0);
        System.out.println(answer);
    }

    private static void solve(int scv1, int scv2, int scv3, int depth) {
        if(depth > answer) return;
        if(scv1 <= 0 && scv2 <= 0 && scv3 <= 0){
            if(depth < answer){
                answer = depth;
            }
            return;
        }
        solve(scv1-9, scv2-3, scv3-1, depth+1);
        solve(scv1-9, scv3-3, scv2-1, depth+1);
        solve(scv2-9, scv1-3, scv3-1, depth+1);
        solve(scv2-9, scv3-3, scv1-1, depth+1);
        solve(scv3-9, scv1-1, scv2-1, depth+1);
        solve(scv3-9, scv2-2, scv1-1, depth+1);
    }

    static String src =
            "3\n" +
            "60 60 60";
}
