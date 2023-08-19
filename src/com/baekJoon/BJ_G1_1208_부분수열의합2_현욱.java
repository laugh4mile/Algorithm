package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_G1_1208_부분수열의합2_현욱 {
    static int N, S, arr[];
    static long answer;
    static Map<Integer, Integer> seq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        seq = new HashMap<>();
        powerSet(0, true, 0);
        powerSet(N/2, false, 0);
        if(S==0)
            answer--;
        System.out.println(answer);
    }
    static void powerSet(int index, boolean dir, int sum) {
        if(dir && index==N/2) {
            seq.put(sum, seq.getOrDefault(sum, 0)+1);
        } else if(!dir && index==N) {
            answer += seq.getOrDefault(S-sum, 0);
        } else {
            powerSet(index+1, dir, sum);
            powerSet(index+1, dir, sum+arr[index]);
        }
    }
}
