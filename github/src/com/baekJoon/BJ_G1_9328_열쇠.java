package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_G1_9328_열쇠 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int R, C, answer;
    static char map[][];
    static boolean isVisited[][][]; // r, c, 개수(26)
    static Set<Character> set;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(input.readLine());
        for(int t=0; t<T; t++){
            answer = 0;
            tokens = new StringTokenizer(input.readLine());
            R = Integer.parseInt(tokens.nextToken()) + 2;
            C = Integer.parseInt(tokens.nextToken()) + 2;
            map = new char[R][C];
            isVisited = new boolean[R][C][27]; // 알파벳 26개
            set = new HashSet<>();
            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    if(r == 0 || c==0 || r == R-1 || c == C-1){
                        map[r][c] = '.';
                    }
                }
            }

            for(int r=1; r<R-1; r++){
                String line = input.readLine();
                for(int c=1; c<C-1; c++){
                    map[r][c] = line.charAt(c-1);
                }
            }
//            System.out.println();
//            for(char[] x : map){
//                System.out.println(Arrays.toString(x));
//            }
//            System.out.println();

            String keys = input.readLine();
            if(!keys.equals("0")){
                for(int i=0; i<keys.length(); i++){
                    set.add(keys.charAt(i));
                    eraseDoor(keys.charAt(i));
                }
                dfs(0,0,set.size());
            }else{
                dfs(0,0, 0);
            }

//            for(char[] x : map){
//                System.out.println(Arrays.toString(x));
//            }
            System.out.println(answer);
        }
    }

    private static void eraseDoor(char key) { // 이건 개선할 방법이 있을듯하다.
        for(int r=1; r<R-1; r++){
            for(int c=1; c<C-1; c++){
                if(map[r][c] == Character.toUpperCase(key)){
//                    System.out.println(map[r][c]);
                    map[r][c] = '.';
                }
            }
        }
    }

    private static void dfs(int r, int c, int keys) {
        isVisited[r][c][keys] = true;
        if(map[r][c] == '$'){
            answer++;
            map[r][c] = '.';
        }
        if(Character.isLowerCase(map[r][c])){
            if(set.contains(map[r][c])){
                map[r][c] = '.';
            }else{
                set.add(map[r][c]);
                eraseDoor(map[r][c]);
                keys++;

                map[r][c] = '.';
            }
        }
        for(int d=0; d<4; d++){
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(isIn(nr,nc) && !isVisited[nr][nc][keys] && map[nr][nc] != '*' && !Character.isUpperCase(map[nr][nc])){
                dfs(nr, nc, keys);
            }
        }
    }

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<R && c<C);
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static String src =
            "3\n" +
            "5 17\n" +
            "*****************\n" +
            ".............**$*\n" +
            "*B*A*P*C**X*Y*.X.\n" +
            "*y*x*a*p**$*$**$*\n" +
            "*****************\n" +
            "cz\n" +
            "5 11\n" +
            "*.*********\n" +
            "*...*...*x*\n" +
            "*X*.*.*.*.*\n" +
            "*$*...*...*\n" +
            "***********\n" +
            "0\n" +
            "7 7\n" +
            "*ABCDE*\n" +
            "X.....F\n" +
            "W.$$$.G\n" +
            "V.$$$.H\n" +
            "U.$$$.J\n" +
            "T.....K\n" +
            "*SQPML*\n" +
            "irony";
}
