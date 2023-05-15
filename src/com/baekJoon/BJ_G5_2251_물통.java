package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G5_2251_물통 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int bottles[];
    static boolean isVisited[][][];
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        bottles = new int[3];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<3; i++){
            bottles[i] = Integer.parseInt(tokens.nextToken());
        }
        isVisited = new boolean[201][201][201];

        dfs(0,0,bottles[2]);
        List<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer);
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
    }

    private static void dfs(int A, int B, int C) {
        if(isVisited[A][B][C]){
            return;
        }
        isVisited[A][B][C] = true;
        if(A == 0){
            set.add(C);
        }

        // A에서 B로 옮기는 경우
        if(A > 0 && B < bottles[1]){
            if(B+A <= bottles[1]){
                dfs(0, B+A, C);
            }else{
                dfs(B+A - bottles[1],bottles[1], C);
            }
        }
        // A에서 C로 옮기는 경우
        if(A > 0 && C < bottles[2]){
            if(C+A <= bottles[2]){
                dfs(0, B, C+A);
            }else{
                dfs(C+A - bottles[2], B,bottles[2]);
            }
        }
        // B에서 A 로 옮기는 경우
        if(B > 0 && A < bottles[0]){
            if(A+B <= bottles[0]){
                dfs(A+B, 0, C);
            }else{
                dfs(bottles[0],A+B - bottles[0], C);
            }
        }
        // B에서 C 로 옮기는 경우
        if(B > 0 && C < bottles[2]){
            if(C+B <= bottles[2]){
                dfs(A, 0, C+B);
            }else{
                dfs(A,C+B - bottles[2], bottles[2]);
            }
        }
        // C에서 A 로 옮기는 경우
        if(C > 0 && A < bottles[0]){
            if(A+C <= bottles[0]){
                dfs(A+C, B, 0);
            }else{
                dfs(bottles[0], B,A+C - bottles[0]);
            }
        }
        // C에서 B 로 옮기는 경우
        if(C > 0 && B < bottles[1]){
            if(B+C <= bottles[1]){
                dfs(A, B+C, 0);
            }else{
                dfs(A, bottles[1], B+C - bottles[1]);
            }
        }
    }
    static String src = "1 3 6";
}
