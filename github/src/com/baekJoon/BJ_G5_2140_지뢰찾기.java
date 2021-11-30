package com.baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_G5_2140_지뢰찾기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        map = new char[N][N];
        for(int r=0; r<N; r++){
            String line = input.readLine();
            for(int c=0; c<N; c++){
                map[r][c] = line.charAt(c);
            }
        }
    }

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    static int dr[] = {0, 0, 1, 1, 1,-1,-1,-1};
    static int dc[] = {1,-1, 0,-1, 1, 0, 1,-1};

    static String src =
            "5\n" +
            "11100\n" +
            "2###1\n" +
            "3###1\n" +
            "2###1\n" +
            "12210";
}
