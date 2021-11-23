package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_10836_여왕벌_3 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int M = Integer.parseInt(tokens.nextToken());
        int N = Integer.parseInt(tokens.nextToken());

        int map[][] = new int[M][M];
        for(int i=0; i<M; i++){
            Arrays.fill(map[i],1);
        }

        Queue<Integer> oneTwoThree = new LinkedList<>();
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<3; j++){
                int cnt = Integer.parseInt(tokens.nextToken());
                for(int k=0; k<cnt; k++){
                    oneTwoThree.offer(j);
                }
            }
            for(int r=M-1; r>=0; r--){
                int num = oneTwoThree.poll();
                if(num>=1){
                    map[r][0] += num;
                }
            }
            for(int c=1; c<M; c++){
                int num = oneTwoThree.poll();
                if(num>=1){
                    map[0][c] += num;
                }
            }
        }
        for(int c=1; c<M; c++){
            if(map[0][c] != 1){
                for(int r=1; r<M; r++){
                    map[r][c] = map[0][c];
                }
            }
        }
        for(int r=0; r<M; r++){
            for(int c=0; c<M; c++){
                output.append(map[r][c]+" ");
            }
            output.append("\n");
        }
        output.close();
    }


    static String src =
            "4 2\n" +
                    "2 3 2\n" +
                    "0 6 1";
}
