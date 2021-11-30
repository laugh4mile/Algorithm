package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_G5_2140_지뢰찾기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        map = new char[N][N];
        for(int r=0; r<N; r++){
            String line = input.readLine();
            for(int c=0; c<N; c++){
                map[r][c] = line.charAt(c);
            }
        }
        if(N <= 2){
            System.out.println(0);
            return;
        }
        char flag = 'f';
        // 1. 4 꼭지점 채우기
        if(map[0][0] == '0'){
            map[1][1] = flag;
        }else{
            map[1][1] = '*';
        }
        if(map[0][N-1] == '0'){
            map[1][N-2] = flag;
        }else{
            map[1][N-2] = '*';
        }
        if(map[N-1][N-1] == '0'){
            map[N-2][N-2] = flag;
        }else{
            map[N-2][N-2] = '*';
        }
        if(map[N-1][0] == '0'){
            map[N-2][1] = flag;
        }else{
            map[N-2][1] = '*';
        }

        // 2. 모서리 채우기
        int r = 0;
        int c = 0;
        for(int i=1; i<N-2; i++){ // 위
            int mine = 0;
            c = i;
            for(int d=4; d<7; d++){
                if(map[r+dr[d]][c+dc[d]] == '*'){
                    mine++;
                }
            }
            if(map[r][c] == mine + '0'){
                for(int d=4; d<7; d++){
                    if(map[r+dr[d]][c+dc[d]] == '#'){
                        map[r+dr[d]][c+dc[d]] = flag;
                    }
                }
            }else{
                map[r+dr[4]][c+dc[4]] = '*';
            }
        }

        c = N-1;
        for(int i=1; i<N-2; i++){ // 오른쪽
            int mine = 0;
            r = i;
            for(int d=6; d<9; d++){
                if(map[r+dr[d]][c+dc[d]] == '*'){
                    mine++;
                }
            }
            if(map[r][c] == mine + '0'){
                for(int d=6; d<9; d++){
                    if(map[r+dr[d]][c+dc[d]] == '#'){
                        map[r+dr[d]][c+dc[d]] = flag;
                    }
                }
            }else{
                map[r+dr[6]][c+dc[6]] = '*';
            }
        }

        r = N-1;
        for(int i=1; i<N-2; i++){ // 아래
            int mine = 0;
            c = i;
            for(int d=0; d<3; d++){
                if(map[r+dr[d]][c+dc[d]] == '*'){
                    mine++;
                }
            }
            if(map[r][c] == mine + '0'){
                for(int d=0; d<3; d++){
                    if(map[r+dr[d]][c+dc[d]] == '#'){
                        map[r+dr[d]][c+dc[d]] = flag;
                    }
                }
            }else{
                map[r+dr[2]][c+dc[2]] = '*';
            }
        }
        c = 0;
        for(int i=1; i<N-2; i++){ // 왼쪽
            int mine = 0;
            r = i;
            for(int d=2; d<5; d++){
                if(map[r+dr[d]][c+dc[d]] == '*'){
                    mine++;
                }
            }
            if(map[r][c] == mine + '0'){
                for(int d=2; d<5; d++){
                    if(map[r+dr[d]][c+dc[d]] == '#'){
                        map[r+dr[d]][c+dc[d]] = flag;
                    }
                }
            }else{
                map[r+dr[4]][c+dc[4]] = '*';
            }
        }

        int answer = 0;
        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                if(map[i][j] == '*' || map[i][j] == '#'){
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    static int dr[] = {-1,-1,-1,0,1,1,1,0,-1};
    static int dc[] = {-1,0,1,1,1,0,-1,-1,-1};

    static String src =
            "5\n" +
                    "11100\n" +
                    "2###1\n" +
                    "3###1\n" +
                    "2###1\n" +
                    "12210";
}
