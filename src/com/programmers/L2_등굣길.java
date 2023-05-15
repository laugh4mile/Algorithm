package com.programmers;

import java.util.Arrays;

class L2_등굣길 {
    public static int solution(int m, int n, int[][] puddles) {
        int map[][] = new int[n][m];
        for(int r=0; r<n; r++){
            Arrays.fill(map[r], -1);
        }

        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]-1][puddles[i][0]-1] = 0;
        }
        map[0][0] = 1; // start 초기화
        for(int r=1; r<n; r++){
            if(map[r][0] == 0) continue;
            if(map[r-1][0] == 1){
                map[r][0] = 1;
            }else{
                map[r][0] = 0;
            }
        }
        for(int c=1; c<m; c++){
            if(map[0][c] == 0) continue;
            if(map[0][c-1] == 1){
                map[0][c] = 1;
            }else{
                map[0][c] = 0;
            }
        }
        for(int r=1; r<n; r++){
            for(int c=1; c<m; c++){
                if(map[r][c] == 0) continue;
                map[r][c] = (map[r-1][c]+map[r][c-1]) % 1000000007;
            }
        }

        return map[n-1][m-1];
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        System.out.println(solution(m,n,puddles));
    }
}