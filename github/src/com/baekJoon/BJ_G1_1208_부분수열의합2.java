package com.baekJoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_G1_1208_부분수열의합2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, S, arr[];
    static long answer;
    static boolean flag;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        S = Integer.parseInt(tokens.nextToken());
        arr = new int[N];
        int mid = N/2;
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        dfs(mid, N,0);
        flag = true;
        dfs(0, mid,0);

//        System.out.println(map);
        if(S == 0){
            System.out.println(answer-1);
        }else{
            System.out.println(answer);
        }
    }

    private static void dfs(int i, int end, int sum) {
        if(i == end){
            if(!flag){ // 이런 1회용성 변수는 파라미터로 넣는것과 static으로 하는것 중 뭐가 더 나은지 궁금함.
                if(map.get(sum) == null){
                    map.put(sum,1);
                }else{
                    map.replace(sum, map.get(sum)+1);
                }
            }else{
                if(map.get(S-sum) != null){
                    answer += map.get(S-sum);
                }
            }
            return;
        }
        dfs(i+1, end, sum);
        dfs(i+1, end, sum+arr[i]);
    }

    static String src =
            "40 0\n" +
            "100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000";
}
