package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G2_17136_색종이붙이기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int map[][], N, answer;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = 10;
        map = new int[N][N];
        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }

//        asd
//        for(int i=5; i>0; i--){
//            check_NxN(i);
//        }
        check_NxN(5, 0);
        if(!lastCheck()){
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    private static boolean lastCheck() {
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(map[r][c] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    private static void check_NxN(int size, int count) {
//        for(int x[] : map){
//            System.out.println(Arrays.toString(x));
//        }
//        System.out.println();
        if(size == 0){
            return;
        }
        if(count < 5){
            for(int r=0; r<N-size+1; r++){
                for(int c=0; c<N-size+1; c++){
                    if(canFill(r,c,size)){
                        fillMap(r,c,size, 0);

                        check_NxN(size, count+1);
                        fillMap(r,c,size,1);
                        answer++;
                    }else{
                        check_NxN(size-1, 0);
                    }
                }
            }
        }else{
            check_NxN(size-1, 0);
        }
    }

    private static void fillMap(int sr, int sc, int size, int num) {
        for(int r=sr; r<sr+size; r++){
            for(int c=sc; c<sc+size; c++){
                map[r][c] = num;
            }
        }
    }

    private static boolean canFill(int sr, int sc, int size) {
        for(int r=sr; r<sr+size; r++){
            for(int c=sc; c<sc+size; c++){
                if(map[r][c] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    static String src =
            "1 1 1 1 1 1 1 0 0 0\n" +
            "1 1 1 1 1 1 1 0 0 0\n" +
            "1 1 1 1 1 1 1 0 0 0\n" +
            "1 1 1 1 1 1 1 0 0 0\n" +
            "1 1 1 1 1 1 1 0 0 0\n" +
            "1 1 1 1 1 0 0 0 0 0\n" +
            "1 1 1 1 1 0 0 0 0 0\n" +
            "1 1 1 1 1 0 0 0 0 0\n" +
            "1 1 1 1 1 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0";
}
