package com.programmers;

import java.util.Arrays;

public class L2_혼자서하는틱택토 {
    public static int solution(String[] board) {
        int answer = 0;

        char[][] map = new char[3][3];

        int o = 0;
        int x = 0;
        for(int r=0; r<3; r++){
            String line = board[r];
            for(int c=0; c<3; c++){
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'O'){
                    o++;
                }
                if (map[r][c] == 'X') {
                    x++;
                }
            }
        }

        // X표시가 O표시보다 많으면 안됨, O표시가 X표시보다 2개 이상 많으면 안됨.
        if(x > o || o > x+1){
            return 0;
        }

        if (checkBingo(map, o, x)){
            answer = 1;
        }

        return answer;
    }

    private static boolean checkBingo(char[][] map, int o, int x) {
        boolean flag = true;
        int oBingo = 0;
        int xBingo = 0;

        // 가로빙고
        for(int r=0; r<3; r++){
            if(map[r][0] != '.' && map[r][0] == map[r][1] && map[r][0] == map[r][2]){
                if(map[r][0] == 'O'){
                    oBingo++;
                }else{
                    xBingo++;
                }
            }
        }
        // 세로빙고
        for(int c=0; c<3; c++){
            if(map[0][c] != '.' && map[0][c] == map[1][c] && map[0][c] == map[2][c]){
                if(map[0][c] == 'O'){
                    oBingo++;
                }else{
                    xBingo++;
                }
            }
        }
        // 대각빙고
        if(map[0][0] != '.' && map[0][0] == map[1][1] && map[0][0] == map[2][2]){
            if(map[0][0] == 'O'){
                oBingo++;
            }else{
                xBingo++;
            }
        }
        if(map[0][2] != '.' && map[0][2] == map[1][1] && map[0][2] == map[2][0]){
            if(map[0][2] == 'O'){
                oBingo++;
            }else{
                xBingo++;
            }
        }
        System.out.println(oBingo+" "+xBingo);

        if(oBingo > 0){ // O가 빙고일 경우
            if(o != x+1){ // X의 수는 O보다 1 작야야함
                flag = false;
            }else if (xBingo > 0){ // X빙고랑 동시에 되면 안됨
                flag = false;
            }
        } else if (xBingo > 0) { // X만 빙고일 경우
            if(o != x){ // O의 수는 X와 동일해야함
                flag = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        String[] board2 = {"OOO", "XOX", "XXO"};
        String[] board3 = {"OOO", "OXX", "OXX"};
        String[] board4 = {"OOO", "O..", "XXX"};
        String[] board5 = {"XOO", ".XO", ".OX"};
        String[] board6 = {"XOO", "XOO", "XXX"};
        String[] board7 = {"XXO", ".OX", "O.."};
//        System.out.println(solution(board));
//        System.out.println(solution(board2));
//        System.out.println(solution(board3));
//        System.out.println(solution(board4));
//        System.out.println(solution(board5));
//        System.out.println(solution(board6));
        System.out.println(solution(board7));
    }
}
