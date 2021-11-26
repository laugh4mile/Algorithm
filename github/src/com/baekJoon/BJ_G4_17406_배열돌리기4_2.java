package com.baekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_17406_배열돌리기4_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    static int per[],N,M, K, map[][],temp[][],answer=Integer.MAX_VALUE;
    static boolean isSelected[];
    static List<Oper> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        map = new int[N][M];
        temp = new int[N][M];
        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<M; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }

        for(int k=0; k<K; k++){
            tokens = new StringTokenizer(input.readLine());
            int mr = Integer.parseInt(tokens.nextToken())-1;
            int mc = Integer.parseInt(tokens.nextToken())-1;
            int d = Integer.parseInt(tokens.nextToken());

            int sr = mr-d;
            int sc = mc-d;
            int er = mr+d;
            int ec = mc+d;
            list.add(new Oper(sr,sc,er,ec));
//            map = rotate(map, sr, sc, er, ec, 1);
        }
        isSelected = new boolean[K];
        per = new int[K];
        permutation(0);

        System.out.println(answer);
    }

    static void copyMap(){
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                temp[r][c] = map[r][c];
            }
        }
    }

    static void getMinAnswer(){
        for(int r=0; r<N; r++){
            int sum = 0;
            for(int c=0; c<M; c++){
                sum+=temp[r][c];
            }
            answer = Math.min(answer, sum);
        }
    }

    private static void permutation(int cnt) {
        if(cnt == K){
            copyMap();
            for(int i=0; i<K; i++){
                Oper oper = list.get(per[i]);
                temp = rotate(temp, oper.sr,oper.sc,oper.er,oper.ec,1);
            }
            getMinAnswer();

            return;
        }
        for(int i=0; i<K; i++){
            if(isSelected[i]) continue;
            per[cnt] = i;
            isSelected[i] = true;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }


    private static class Oper {
        int sr;
        int sc;
        int er;
        int ec;

        public Oper(int sr, int sc, int er, int ec) {
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
        }
    }

    private static int[][] rotate(int[][] map, int sr, int sc, int er, int ec, int move) { // (sr,sc)~(er,ec)영역을 반시계 방향으로 move칸 만큼 회전
        while(true){
            if(sr>=er || sc>=ec){
                break;
            }
            int size = 2*(er-sr)+2*(ec-sc);
            int edge[] = new int[size];
            int result[] = new int[size];
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

            for(int i=0; i<size; i++){
                result[i] = edge[(i+size-move) % size];
            }

            idx = 0;
            for(int c=sc; c<ec; c++){
                map[sr][c] = result[idx++];
            }
            for(int r=sr; r<er; r++){
                map[r][ec] = result[idx++];
            }
            for(int c=ec; c>=sc+1; c--){
                map[er][c] = result[idx++];
            }
            for(int r=er; r>=sr+1; r--){
                map[r][sc] = result[idx++];
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
        return map;
    }

    static String src =
            "5 6 2\n" +
                    "1 2 3 2 5 6\n" +
                    "3 8 7 2 1 3\n" +
                    "8 2 3 1 4 5\n" +
                    "3 4 5 1 1 1\n" +
                    "9 3 2 1 4 3\n" +
                    "3 4 2\n" +
                    "4 2 1";
}
