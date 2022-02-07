package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_22342_계산로봇 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int R,C,map[][], out[][], store[][];
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        map = new int[R][C];
        out = new int[R][C];
        store = new int[R][C];
        for(int r=0; r<R; r++){
            String line = input.readLine();
            for(int c=0; c<C; c++){
                map[r][c] = line.charAt(c) - '0';
            }
        }
        int answer = 0;
        for(int c=0; c<C; c++){
            for(int r=0; r<R; r++){
                int maxStore = 0; // 입력값의 최대값이 저장값임
                for(int d=0; d<3; d++){ // 왼쪽 3개의 출력값이 입력값임
                    int nr = r + dr[d];
                    int nc = c-1;
                    if(isIn(nr, nc)){
                        if(maxStore < out[nr][nc]){
                            maxStore = out[nr][nc];
                        }
                    }
                }

                store[r][c] = maxStore;
                if(answer < maxStore){
                    answer = maxStore;
                }
                out[r][c] = maxStore + map[r][c];
            }
        }
        System.out.println(answer);
        for(int x[] : out){
            System.out.println(Arrays.toString(x));
        }
        System.out.println();
        for(int x[] : store){
            System.out.println(Arrays.toString(x));
        }
    }
    static int dr[] = {-1,0,1};
//    static int dc[] = {-1,-1,-1};
    static boolean isIn(int r, int c){
        return (r>=0 && r<R && c>=0 && c<C);
    }
    static String src =
            "3 4\n" +
                    "1234\n" +
                    "2341\n" +
                    "3412";
}
