package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_G2_1525_퍼즐 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N;
    static Set<String> set = new HashSet<>();
    static char map[][];
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int zr = 0, zc = 0;
        N = 3;
        map = new char[N][N];
        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = tokens.nextToken().charAt(0);
                if(map[r][c] == '0'){
                    zr = r;
                    zc = c;
                }
            }
        }
        System.out.println(bfs(zr, zc, map));
    }

    static String arrToStr(char[][] arr){
        return String.valueOf(arr[0])+String.valueOf(arr[1])+String.valueOf(arr[2]);
    }

    static int dr[] = {0,0,1,-1};
    static int dc[] = {1,-1,0,0};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    private static int bfs(int zr, int zc, char[][] map) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(zr, zc, map, 0));
        set.add(arrToStr(map));
//        int test = 0;
        while (!queue.isEmpty()) {
//            if(test++ > 10) break;
            Node front = queue.poll();
//            System.out.println(arrToStr(front.map) + " " + front.r + " " + front.c+" "+front.cnt);
            if(arrToStr(front.map).equals("123456780")){
                return front.cnt;
            }
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];
                if(isIn(nr, nc)){
                    char[][] tmpMap = new char[N][N];
                    for(int r=0; r<N; r++){
                        for(int c=0; c<N; c++){
                            tmpMap[r][c] = front.map[r][c];
                        }
                    }
                    char tmp = tmpMap[front.r][front.c];
                    tmpMap[front.r][front.c] = tmpMap[nr][nc];
                    tmpMap[nr][nc] = tmp;
                    String strMap = arrToStr(tmpMap);
                    if(!set.contains(strMap)){
                        set.add(strMap);
                        queue.offer(new Node(nr, nc, tmpMap, front.cnt+1));
                    }
                }
            }
        }
        return -1;
    }

    static class Node{
        int r;
        int c;
        char[][] map;

        int cnt;

        public Node(int r, int c, char[][] map, int cnt) {
            this.r = r;
            this.c = c;
            this.map = map;
            this.cnt = cnt;
        }
    }

    static String src =
            "3 6 0\n" +
                    "8 1 2\n" +
                    "7 4 5";
}
