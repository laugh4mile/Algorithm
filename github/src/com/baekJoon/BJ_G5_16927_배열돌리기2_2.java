package com.baekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_16927_배열돌리기2_2 {
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

        Queue<Integer> queue = new LinkedList<>();
        while(true){
            if(sr>=er || sc>=ec){
                break;
            }
            int size = 2*(er-sr)+2*(ec-sc);

            int idx=0;
            for(int c=sc; c<ec; c++){
                queue.offer(map[sr][c]);
            }
            for(int r=sr; r<er; r++){
                queue.offer(map[r][ec]);
            }
            for(int c=ec; c>=sc+1; c--){
                queue.offer(map[er][c]);
            }
            for(int r=er; r>=sr+1; r--){
                queue.offer(map[r][sc]);
            }
            for(int i=0; i<move%size; i++){
                queue.offer(queue.poll());
            }

            for(int c=sc; c<ec; c++){
                map[sr][c] = queue.poll();
            }
            for(int r=sr; r<er; r++){
                map[r][ec] = queue.poll();
            }
            for(int c=ec; c>=sc+1; c--){
                map[er][c] = queue.poll();
            }
            for(int r=er; r>=sr+1; r--){
                map[r][sc] = queue.poll();
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                output.append(map[r][c] + " ");
            }
            output.append("\n");
        }
        output.close();
    }

    static String src =
            "5 4 7\n" +
                    "1 2 3 4\n" +
                    "7 8 9 10\n" +
                    "13 14 15 16\n" +
                    "19 20 21 22\n" +
                    "25 26 27 28";
}
