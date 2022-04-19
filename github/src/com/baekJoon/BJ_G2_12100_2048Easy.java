package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G2_12100_2048Easy {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, map[][], max;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        map = new int[N][N];

        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }

        dfs(0, map);

        System.out.println(max);
    }

    private static void dfs(int cnt, int[][] map) {
        if (cnt == 5){
            // 가장큰 값 초기화
//            for(int[] x: map){
//                System.out.println(Arrays.toString(x));
//            }
//            System.out.println();
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(map[r][c] > max){
                        max = map[r][c];
                    }
                }
            }
            return;
        }

        for(int d=0; d<4; d++){
            dfs(cnt+1, move(d, map));
        }

    }

    private static int[][] move(int d, int map[][]) {
        int temp[][] = new int[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                temp[r][c] = map[r][c];
            }
        }

        Deque<Block> deque = new LinkedList<>();
        int size = 0;
        if(d==0){ // 상
            for(int c=0; c<N; c++){
                for(int r=0; r<N; r++){
                    if(temp[r][c] == 0) continue;
                    if(deque.isEmpty()){
                        deque.offer(new Block(temp[r][c], false));
                    }else{
                        if(!deque.peekLast().isUsed && deque.peekLast().num == temp[r][c]){
                            deque.offer(new Block(deque.pollLast().num + temp[r][c], true));
                        }else{
                            deque.offer(new Block(temp[r][c], false));
                        }
                    }
                    temp[r][c] = 0;
                }
                size = deque.size();
                for(int r=0; r<size; r++){
                    temp[r][c] = deque.poll().num;
                }
            }
        }else if(d==1){ // 하
            for(int c=0; c<N; c++){
                for(int r=N-1; r>=0; r--){
                    if(temp[r][c] == 0) continue;
                    if(deque.isEmpty()){
                        deque.offer(new Block(temp[r][c], false));
                    }else{
                        if(!deque.peekLast().isUsed && deque.peekLast().num == temp[r][c]){
                            deque.offer(new Block(deque.pollLast().num + temp[r][c], true));
                        }else{
                            deque.offer(new Block(temp[r][c], false));
                        }
                    }
                    temp[r][c] = 0;
                }
                size = deque.size();
                for(int r=N-1; r> N-1-size; r--){
                    temp[r][c] = deque.poll().num;
                }
            }
        }else if(d==2){ // 좌
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(temp[r][c] == 0) continue;
                    if(deque.isEmpty()){
                        deque.offer(new Block(temp[r][c], false));
                    }else{
                        if(!deque.peekLast().isUsed && deque.peekLast().num == temp[r][c]){
                            deque.offer(new Block(deque.pollLast().num + temp[r][c], true));
                        }else{
                            deque.offer(new Block(temp[r][c], false));
                        }
                    }
                    temp[r][c] = 0;
                }
                size = deque.size();
                for(int c=0; c<size; c++){
                    temp[r][c] = deque.poll().num;
                }
            }
        }else { // 우
            for(int r=0; r<N; r++){
                for(int c=N-1; c>=0; c--){
                    if(temp[r][c] == 0) continue;
                    if(deque.isEmpty()){
                        deque.offer(new Block(temp[r][c], false));
                    }else{
                        if(!deque.peekLast().isUsed && deque.peekLast().num == temp[r][c]){
                            deque.offer(new Block(deque.pollLast().num + temp[r][c], true));
                        }else{
                            deque.offer(new Block(temp[r][c], false));
                        }
                    }
                    temp[r][c] = 0;
                }
                size = deque.size();
                for(int c=N-1; c> N-1-size; c--){
                    temp[r][c] = deque.poll().num;
                }
            }
        }
        return temp;
    }
    static class Block{
        int num;
        boolean isUsed;

        public Block(int num, boolean isUsed) {
            this.num = num;
            this.isUsed = isUsed;
        }
    }
    static String src =
            "5\n" +
            "2 0 0 0 0\n" +
            "2 0 0 0 0\n" +
            "4 0 0 0 0\n" +
            "2 0 0 0 0\n" +
            "2 0 0 0 0";
}
