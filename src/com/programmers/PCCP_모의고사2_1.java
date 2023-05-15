package com.programmers;

import java.util.Arrays;

public class PCCP_모의고사2_1 {
    public static int[] solution(String command) {
        int[] answer = new int[2];

        int d = 0; // 0,1,2,3 상우하좌
        for(int i=0; i<command.length(); i++){
            char cmd = command.charAt(i);
            d = rotate(cmd, d);
            System.out.println(d);
            answer = move(answer, d, cmd);
        }

        return answer;
    }

    private static int rotate(char cmd, int d) {
        if(cmd == 'R'){
            d = (d+1) % 4;
        }else if(cmd == 'L'){
            d = (d+3) % 4;
        }
        return d;
    }

    private static int[] move(int[] cur, int d, char cmd) {
        int x = cur[0];
        int y = cur[1];

        if(cmd == 'G'){
            cur[0] = x + dx[d];
            cur[1] = y + dy[d];
        }else if(cmd == 'B'){
            cur[0] = x - dx[d];
            cur[1] = y - dy[d];
        }

        return cur;
    }

    static int dx[] = {0,1,0,-1}; // 상우하좌
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) {
        String command = "GRGLGRG";
        System.out.println(Arrays.toString(solution(command)));
    }
}
