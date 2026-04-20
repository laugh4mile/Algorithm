package com.programmers;

import java.util.HashMap;
import java.util.Map;

public class L1_공원산책 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        int R = park.length;
        int C = park[0].length();
        int sr = 0;
        int sc = 0;

        Map<Character, Integer> dir = new HashMap<>();
        dir.put('E', 0);
        dir.put('W', 1);
        dir.put('S', 2);
        dir.put('N', 3);

        char[][] map = new char[R][C];

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                map[r][c] = park[r].charAt(c);
                if(map[r][c] == 'S'){
                    sr = r;
                    sc = c;
                }
            }
        }

        for(int i=0; i<routes.length; i++){
            int d = dir.get(routes[i].charAt(0));
            int m = routes[i].charAt(2) - '0';
            int r = sr;
            int c = sc;

            boolean canMove = true;
            for(int j=0; j<m; j++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(isIn(nr, nc, R, C) && map[nr][nc] != 'X'){
                    r = nr;
                    c = nc;
                }else{
                    canMove = false;
                    break;
                }
            }

            if(canMove){
                sr = r;
                sc = c;
            }
        }
        answer[0] = sr;
        answer[1] = sc;

        return answer;
    }

    boolean isIn(int r, int c, int R, int C){
        return (r>=0 && c>=0 && r<R && c<C);
    }

    int dr[] = {0, 0, 1, -1}; // 동서남북
    int dc[] = {1, -1, 0, 0};
}
