package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class L3_미로탈출명령어 {
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        int distance = Math.abs(x-r) + Math.abs(y-c);

        if(k < distance || (k-distance)%2 != 0){
            return "impossible";
        }

        dfs(n, m, x-1, y-1, r-1, c-1, k, 0, "");

        while(nx < r-1){
            nx++;
            word.append("d");
        }
        while(ny > c-1){
            ny--;
            word.append("l");
        }
        while(ny < c-1){
            ny++;
            word.append("r");
        }
        while(nx > r-1){
            nx--;
            word.append("u");
        }

        answer = word.toString();

        return answer;
    }

    static boolean flag;
    static StringBuilder word = new StringBuilder();
    static int nx, ny;
    private static void dfs(int n, int m, int x, int y, int er, int ec, int k, int cnt, String s){
        if(cnt + Math.abs(er - x) + Math.abs(ec - y) == k){
            flag = true;
            word.append(s);
            nx = x;
            ny = y;
            return;
        }

        for(int d=0; d<4; d++){
            int nr = x + dr[d];
            int nc = y + dc[d];

            if(isIn(nr, nc, n, m) && !flag){
                dfs(n, m, nr, nc, er, ec, k, cnt+1, s+str[d]);
            }
        }
    }

    static boolean isIn(int r, int c, int R, int C){
        return (r>=0 && c>=0 && r<R && c<C);
    }

    // d l r u 순서: 아래 왼쪽 오른쪽 위
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static String[] str = {"d", "l", "r", "u"};

    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;

        System.out.println(solution(n, m, x, y, r, c, k)); // answer: dllrl
    }
}
