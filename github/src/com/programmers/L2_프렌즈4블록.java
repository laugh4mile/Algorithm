package com.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class L2_프렌즈4블록 {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        char[][] temp = new char[m][n];
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                map[r][c] = board[r].charAt(c);
                temp[r][c] = board[r].charAt(c);
            }
        }
        int cnt = 0;
        boolean isRemain;
        while(true){
            isRemain = false;
            for(int r=0; r<m-1; r++){
                for(int c=0; c<n-1; c++){
                    if(map[r][c] != '0' && map[r][c] == map[r+1][c] && map[r][c] == map[r][c+1] && map[r][c] == map[r+1][c+1]){
                        temp[r][c] = '0';
                        temp[r][c+1] = '0';
                        temp[r+1][c] = '0';
                        temp[r+1][c+1] = '0';
                        isRemain = true;
                    }
                }
            }
            if(!isRemain) break;
            for(int c=0; c<n; c++){ // 아래로 밀착
                Queue<Character> queue = new LinkedList<>();
                for(int r=m-1; r>=0; r--){
                    if(temp[r][c] != '0') {
                        queue.offer(temp[r][c]);
                        temp[r][c] = '0';
                    }
                }
                for(int r=m-1; r>=0; r--){
                    if(!queue.isEmpty()){
                        temp[r][c] = queue.poll();
                    }
                    map[r][c] = temp[r][c];
                }
            }
        }
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(map[r][c] == '0'){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        String[] board = {"TTT","TTT","TTT"};
//        int m = 6;
//        int n = 6;
//        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(m,n,board));
    }
}