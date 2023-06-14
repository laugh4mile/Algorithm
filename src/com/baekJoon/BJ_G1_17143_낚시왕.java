package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G1_17143_낚시왕 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static List<Shark> list;
    static int R,C,M, map_idx[][], map_z[][];

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());

        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        map_idx = new int [R][C];
        map_z = new int [R][C];
        list = new ArrayList<>();
        list.add(new Shark(0,0,0,0,0,true)); // 1번 부터 시작하기 위해 0번 상어를 임의로 넣음
        for(int i=1; i<M+1; i++){
            tokens = new StringTokenizer(input.readLine());
            int r = Integer.parseInt(tokens.nextToken())-1;
            int c = Integer.parseInt(tokens.nextToken())-1;
            int s = Integer.parseInt(tokens.nextToken());
            int d = Integer.parseInt(tokens.nextToken())-1;
            int z = Integer.parseInt(tokens.nextToken());

            map_idx[r][c] = i;
            map_z[r][c] = z;
            list.add(new Shark(r,c,s,d,z,false));
        }

        int answer = 0;

        for(int c=0; c<C; c++){
            for(int r=0; r<R; r++){
                if(map_idx[r][c] != 0){
                    answer += map_z[r][c];
                    list.get(map_idx[r][c]).isDead = true;
                    map_idx[r][c] = 0;
                    map_z[r][c] = 0;
                    break;
                }
            }
            moveShark();
        }
        System.out.println(answer);
    }

    private static void moveShark() {
        for(int i=1; i<M+1; i++){
            if(!list.get(i).isDead){
                map_idx[list.get(i).r][list.get(i).c] = 0;
                map_z[list.get(i).r][list.get(i).c] = 0;
                int nr = 0, nc = 0;
                for(int s=0; s<list.get(i).s; s++){
                    nr = list.get(i).r + dr[list.get(i).d];
                    nc = list.get(i).c + dc[list.get(i).d];
                    if(isIn(nr,nc)){
                        list.get(i).r = nr;
                        list.get(i).c = nc;
                    }else{
                        if(list.get(i).d == 0){
                            list.get(i).d = 1;
                        }else if(list.get(i).d == 1){
                            list.get(i).d = 0;
                        }else if(list.get(i).d == 2){
                            list.get(i).d = 3;
                        }else{
                            list.get(i).d = 2;
                        }
                        s--;
                    }
                }
            }
        }
        for(int i=1; i<M+1; i++){
            if(!list.get(i).isDead){
                if(map_z[list.get(i).r][list.get(i).c] < list.get(i).z){
                    list.get(map_idx[list.get(i).r][list.get(i).c]).isDead = true;
                    map_z[list.get(i).r][list.get(i).c] = list.get(i).z;
                    map_idx[list.get(i).r][list.get(i).c] = i;
                }else{
                    list.get(i).isDead = true;
                }
            }
        }
    }


    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<R && c<C);
    }

    static class Shark{
        int r;
        int c;
        int s;
        int d;
        int z;
        boolean isDead;

        public Shark(int r, int c, int s, int d, int z, boolean isDead) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.isDead = isDead;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    ", isDead=" + isDead +
                    '}';
        }
    }

    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,1,-1};


    static String src =
            "2 2 4\n" +
            "1 1 1 1 1\n" +
            "2 2 2 2 2\n" +
            "1 2 1 2 3\n" +
            "2 1 2 1 4";
}
