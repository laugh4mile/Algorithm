package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_16927_배열돌리기2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int R = Integer.parseInt(tokens.nextToken());
        int C = Integer.parseInt(tokens.nextToken());
        int move = Integer.parseInt(tokens.nextToken());

        int map[][] = new int[R][C];
        for(int r=0; r<R; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<C; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }
        int sr = 0;
        int sc = 0;
        int er = R-1;
        int ec = C-1;

        while(true){
            if(sr>=er || sc>=ec){
                break;
            }
            int size = 2*(er-sr)+2*(ec-sc);
            int edge[] = new int[size];
            int idx=0;
            for(int c=sc; c<ec; c++){
                edge[idx++] = map[sr][c];
            }
            for(int r=sr; r<er; r++){
                edge[idx++] = map[r][ec];
            }
            for(int c=ec; c>=sc+1; c--){
                edge[idx++] = map[er][c];
            }
            for(int r=er; r>=sr+1; r--){
                edge[idx++] = map[r][sc];
            }
            System.out.println(Arrays.toString(edge));

            sr++;
            sc++;
            er--;
            ec--;
        }
    }

    static String src =
            "4 4 2\n" +
            "1 2 3 4\n" +
            "5 6 7 8\n" +
            "9 10 11 12\n" +
            "13 14 15 16";
}
