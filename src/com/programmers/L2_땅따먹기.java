package com.programmers;

import java.util.Arrays;

class L2_땅따먹기 {
    static int solution(int[][] land) {
        int answer = 0;
        for(int r=1; r<land.length; r++){
            for(int c=0; c<land[0].length; c++){
                int preMax = 0;
                for(int i=0; i<land[0].length; i++){
                    if(c == i) continue;
                    if(preMax < land[r-1][i]) preMax = land[r-1][i];
                }
                land[r][c] += preMax;
            }
        }
        for(int i=0; i<land[0].length; i++){
            if(land[land.length-1][i] > answer) answer = land[land.length-1][i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(solution(land));
    }
}