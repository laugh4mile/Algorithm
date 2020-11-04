package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int T,N,X,map[][],cnt;
    static boolean isVisited[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        input = new BufferedReader(new StringReader(src));
        T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++) {
            tokens = new StringTokenizer(input.readLine());
            N = Integer.parseInt(tokens.nextToken());
            X = Integer.parseInt(tokens.nextToken());
            map = new int[N][N];
            isVisited = new boolean[N][N];

            for(int r=0; r<N; r++) {
                tokens= new StringTokenizer(input.readLine());
                for(int c=0; c<N; c++) {
                    map[r][c] = Integer.parseInt(tokens.nextToken());
                }    
            } // 입력 끝
            
            outer : for(int r=0; r<N; r++) {
                for(int c=0; c<N-1; c++) {
                    if(map[r][c] != map[r][c+1]) { // 층이 생겼다! 
                        if(Math.abs(map[r][c] - map[r][c+1]) > 1) { // 2층 이상이면 ㅃ2
                            continue outer;
                        }else if(map[r][c] > map[r][c+1]) { // 내려가는 경우
                            for(int i=c+2; i<=c+1+X; i++) {
                                if(isIn(r, i) && !isVisited[r][i] && map[r][c+1] != map[r][i]) {
                                    continue outer;
                                }
                            }
                        }
                    }
                }
                cnt++;
            }



            System.out.println("#"+t+" "+cnt);
            cnt = 0;
        }
    }

    static boolean isIn(int r, int c) {
        return (r>=0 && c>=0 && r<N && c<N);
    }

    static String src =
            "10\r\n" + 
            "6 2\r\n" + 
            "3 3 3 2 1 1\r\n" + 
            "3 3 3 2 2 1\r\n" + 
            "3 3 3 3 3 2\r\n" + 
            "2 2 3 2 2 2\r\n" + 
            "2 2 3 2 2 2\r\n" + 
            "2 2 2 2 2 2\r\n" + 
            "6 4\r\n" + 
            "3 2 2 2 1 2 \r\n" + 
            "3 2 2 2 1 2 \r\n" + 
            "3 3 3 3 2 2 \r\n" + 
            "3 3 3 3 2 2 \r\n" + 
            "3 2 2 2 2 2 \r\n" + 
            "3 2 2 2 2 2 \r\n" + 
            "7 2\r\n" + 
            "1 1 1 1 2 1 1 \r\n" + 
            "1 1 1 2 2 2 1 \r\n" + 
            "2 2 2 2 2 2 2 \r\n" + 
            "2 2 2 2 2 2 2 \r\n" + 
            "2 2 2 2 2 2 2 \r\n" + 
            "2 2 2 2 2 2 2 \r\n" + 
            "2 2 2 2 2 2 2 \r\n" + 
            "8 3\r\n" + 
            "2 2 2 3 3 4 2 2 \r\n" + 
            "2 2 2 3 3 4 2 2 \r\n" + 
            "2 2 2 2 2 2 2 2 \r\n" + 
            "2 2 2 2 2 2 2 2 \r\n" + 
            "2 2 2 2 1 1 2 2 \r\n" + 
            "2 1 1 1 1 1 1 1 \r\n" + 
            "2 1 1 1 1 1 1 1 \r\n" + 
            "2 1 1 1 1 1 1 1 \r\n" + 
            "8 4\r\n" + 
            "1 1 1 1 1 1 1 1 \r\n" + 
            "1 1 1 1 1 1 1 1 \r\n" + 
            "1 1 1 1 1 1 1 1 \r\n" + 
            "2 1 1 1 1 1 1 1 \r\n" + 
            "2 1 1 1 1 1 1 1 \r\n" + 
            "2 1 1 1 1 1 1 1 \r\n" + 
            "1 1 1 1 1 1 1 2 \r\n" + 
            "1 1 1 1 1 1 1 2 \r\n" + 
            "9 4\r\n" + 
            "4 4 3 3 3 3 2 2 2 \r\n" + 
            "4 4 3 3 1 1 2 2 3 \r\n" + 
            "3 3 2 2 1 1 1 1 2 \r\n" + 
            "1 1 1 1 1 1 1 1 1 \r\n" + 
            "1 1 1 1 1 1 1 1 1 \r\n" + 
            "2 2 1 1 1 1 1 1 1 \r\n" + 
            "2 2 1 1 1 1 1 1 1 \r\n" + 
            "2 2 2 2 2 2 1 1 1 \r\n" + 
            "3 3 3 3 2 2 2 2 1 \r\n" + 
            "10 2\r\n" + 
            "2 2 3 5 3 1 1 1 1 1 \r\n" + 
            "2 2 3 5 3 1 1 1 1 1 \r\n" + 
            "3 3 4 5 4 3 2 1 1 2 \r\n" + 
            "3 3 4 5 4 3 2 1 1 2 \r\n" + 
            "5 5 5 5 5 5 3 1 1 3 \r\n" + 
            "4 4 4 5 5 5 4 3 3 3 \r\n" + 
            "4 4 4 5 5 5 5 5 5 3 \r\n" + 
            "4 4 4 4 4 5 5 5 5 3 \r\n" + 
            "4 4 4 4 4 5 5 5 5 3 \r\n" + 
            "5 5 4 4 4 5 5 5 5 4 \r\n" + 
            "12 4\r\n" + 
            "4 4 4 5 5 4 4 4 4 4 4 4 \r\n" + 
            "5 5 5 5 5 5 5 5 5 5 5 4 \r\n" + 
            "4 4 4 5 5 4 4 4 5 5 5 4 \r\n" + 
            "3 3 4 5 5 4 3 4 5 5 5 4 \r\n" + 
            "3 3 4 5 5 4 3 4 5 5 5 4 \r\n" + 
            "2 2 3 4 4 4 4 4 4 4 4 5 \r\n" + 
            "2 2 3 4 4 4 4 4 4 4 4 5 \r\n" + 
            "2 2 3 3 3 4 5 3 2 2 4 4 \r\n" + 
            "3 3 3 4 4 4 5 4 3 3 4 4 \r\n" + 
            "3 3 4 5 5 5 5 5 5 5 5 4 \r\n" + 
            "3 3 4 5 5 5 5 5 5 5 5 4 \r\n" + 
            "4 4 4 4 4 4 5 5 5 5 5 4 \r\n" + 
            "15 3\r\n" + 
            "5 4 4 3 3 3 2 2 2 3 4 4 4 4 4 \r\n" + 
            "5 4 4 3 3 3 2 2 2 3 4 4 4 4 4 \r\n" + 
            "5 5 5 5 4 4 2 2 3 4 4 4 4 4 5 \r\n" + 
            "5 4 4 3 3 3 2 2 3 4 4 4 4 4 4 \r\n" + 
            "5 3 3 1 2 2 3 3 3 4 4 4 4 4 4 \r\n" + 
            "3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 \r\n" + 
            "3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 \r\n" + 
            "2 3 3 4 3 3 3 3 3 3 3 4 4 4 3 \r\n" + 
            "2 3 3 4 3 3 3 3 3 3 3 4 4 4 3 \r\n" + 
            "3 4 4 4 4 4 3 3 3 3 3 3 4 4 4 \r\n" + 
            "5 5 5 4 4 4 4 4 3 3 3 3 4 4 5 \r\n" + 
            "5 5 5 4 4 4 4 4 3 3 3 3 4 4 5 \r\n" + 
            "5 5 5 5 4 4 4 4 3 3 2 2 3 3 4 \r\n" + 
            "5 5 5 5 5 5 4 4 3 3 2 1 2 2 3 \r\n" + 
            "5 5 5 5 5 5 4 4 3 3 2 1 2 2 3 \r\n" + 
            "20 3\r\n" + 
            "3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 \r\n" + 
            "3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 \r\n" + 
            "5 3 3 2 2 2 2 2 3 3 4 4 4 4 5 5 5 5 5 5 \r\n" + 
            "4 3 3 1 1 1 1 1 2 3 4 4 4 5 5 5 5 5 5 5 \r\n" + 
            "4 2 2 1 1 1 1 1 2 3 4 5 5 5 5 5 5 5 5 5 \r\n" + 
            "4 3 3 2 2 2 2 1 2 3 4 5 5 5 5 5 5 5 5 5 \r\n" + 
            "4 4 4 4 4 3 3 2 3 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
            "4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 \r\n" + 
            "4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 \r\n" + 
            "4 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
            "3 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 \r\n" + 
            "3 3 3 3 3 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 \r\n" + 
            "3 3 3 3 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 \r\n" + 
            "4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 \r\n" + 
            "4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 \r\n" + 
            "5 5 5 5 5 5 5 5 5 5 5 5 4 4 4 4 4 4 4 4 \r\n" + 
            "5 5 5 5 5 5 5 5 5 5 5 5 3 3 3 3 4 4 4 4 \r\n" + 
            "5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 \r\n" + 
            "5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 \r\n" + 
            "5 5 5 5 5 5 5 5 4 4 4 4 3 3 3 3 4 4 4 4";
}