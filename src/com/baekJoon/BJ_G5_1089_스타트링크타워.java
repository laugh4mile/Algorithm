package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_G5_1089_스타트링크타워 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> list[];
    static boolean isSelected[];
    static int N, result[];
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());

        char map[][] = new char[5][4*N-1];
        isSelected = new boolean[N];
        result = new int[N];

        for(int r=0; r<5; r++){
            String line = input.readLine();
            for(int c=0; c<N*4-1; c++){
                map[r][c] = line.charAt(c);
            }
        }

        list = new List[N];
        for(int n=0; n<N; n++){ // 자리수
            list[n] = new ArrayList<>();
            check(map, n);
        }

        long sum = 0;
        int cnt = 1;
        int total = 0;
        int arr[] = new int[N];
        Arrays.fill(arr,1);
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                arr[i] *= list[j].size();
            }
            for(int j=i+1; j<N; j++){
                arr[i] *= list[j].size();
            }
        }
        for(int i=N-1; i>=0; i--){
            if(list[i].size() == 0){
                System.out.println(-1);
                return;
            }
            for(int j=0; j<list[i].size(); j++){
                sum += list[i].get(j) * Math.pow(10, N-1-i) * arr[i];
            }
            cnt *= list[i].size();
        }
        System.out.println((double) sum/cnt);

    }



    private static void check(char[][] map, int n) {
        outer: for(int i=0; i<=9; i++){
            for(int r=0; r<5; r++){
                for(int c=n*4; c<n*4+3; c++){
                    if(map[r][c] == '#' && nums[i][r][c-n*4] == '.'){
                        continue outer;
                    }
                }
            }
            list[n].add(i);
        }
    }

    static char[][][] nums = {
            {
                    {'#','#','#'},
                    {'#','.','#'},
                    {'#','.','#'},
                    {'#','.','#'},
                    {'#','#','#'},
            },
            {
                    {'.','.','#'},
                    {'.','.','#'},
                    {'.','.','#'},
                    {'.','.','#'},
                    {'.','.','#'},
            },
            {
                    {'#','#','#'},
                    {'.','.','#'},
                    {'#','#','#'},
                    {'#','.','.'},
                    {'#','#','#'},
            },
            {
                    {'#','#','#'},
                    {'.','.','#'},
                    {'#','#','#'},
                    {'.','.','#'},
                    {'#','#','#'},
            },
            {
                    {'#','.','#'},
                    {'#','.','#'},
                    {'#','#','#'},
                    {'.','.','#'},
                    {'.','.','#'},
            },
            {
                    {'#','#','#'},
                    {'#','.','.'},
                    {'#','#','#'},
                    {'.','.','#'},
                    {'#','#','#'},
            },
            {
                    {'#','#','#'},
                    {'#','.','.'},
                    {'#','#','#'},
                    {'#','.','#'},
                    {'#','#','#'},
            },
            {
                    {'#','#','#'},
                    {'.','.','#'},
                    {'.','.','#'},
                    {'.','.','#'},
                    {'.','.','#'},
            },
            {
                    {'#','#','#'},
                    {'#','.','#'},
                    {'#','#','#'},
                    {'#','.','#'},
                    {'#','#','#'},
            },
            {
                    {'#','#','#'},
                    {'#','.','#'},
                    {'#','#','#'},
                    {'.','.','#'},
                    {'#','#','#'},
            },
    };

    static String src =
            "9\n" +
                    "###...#.###.###.#.#.###.###.###.###\n" +
                    "#.#...#...#...#.#.#.#...#.....#.#.#\n" +
                    "#.#...#.###.###.###.###.###...#.###\n" +
                    "#.#...#.#.....#...#...#.#.#...#.#.#\n" +
                    "###...#.###.###...#.###.###...#.###";
}
