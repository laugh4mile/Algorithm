package com.codingtest.line.fintechIntern;

public class Q3 {
    static String[] pixels = {
            "111111111111111111111111110111111111",
            "001101001101101100101101010101001100",
            "111101111101101111101111010111111111",
            "100101100101101101101001010101001001",
            "111111111111111111111111111111111111"
    };
    static String[] pixels2 = {
            "110",
            "010",
            "010",
            "010",
            "111",
    };
    public static void main(String[] args) {
        System.out.println(solution(pixels2));
    }
    public static String solution(String[] pixels) {
        int map[][] = new int[5][pixels[0].length()];
        for(int r=0; r<5; r++){
            for(int c=0; c<pixels[0].length(); c++){
                map[r][c] = pixels[r].charAt(c) - '0';
            }
        }
        int N = pixels[0].length()/3;
        for(int n=0; n<N; n++){
            check(map, n);
        }
        return sb.toString();
    }
    static StringBuilder sb = new StringBuilder();

    private static void check(int[][] map, int n) {
        outer: for(int i=0; i<=9; i++){
            for(int r=0; r<5; r++){
                for(int c=n*3; c<n*3+3; c++){
                    if(map[r][c] != nums[i][r][c-n*3]){ // 하나라도 다르면 안됨
                        continue outer;
                    }
                }
            }
            sb.append(i+"");
        }
    }

    static int[][][] nums = {
            {
                    {1,1,1},
                    {1,0,1},
                    {1,0,1},
                    {1,0,1},
                    {1,1,1},
            },
            {
                    {1,1,0},
                    {0,1,0},
                    {0,1,0},
                    {0,1,0},
                    {1,1,1},
            },
            {
                    {1,1,1},
                    {0,0,1},
                    {1,1,1},
                    {1,0,0},
                    {1,1,1},
            },
            {
                    {1,1,1},
                    {0,0,1},
                    {1,1,1},
                    {0,0,1},
                    {1,1,1},
            },
            {
                    {1,0,1},
                    {1,0,1},
                    {1,1,1},
                    {0,0,1},
                    {0,0,1},
            },
            {
                    {1,1,1},
                    {1,0,0},
                    {1,1,1},
                    {0,0,1},
                    {1,1,1},
            },
            {
                    {1,1,1},
                    {1,0,0},
                    {1,1,1},
                    {1,0,1},
                    {1,1,1},
            },
            {
                    {1,1,1},
                    {1,0,1},
                    {0,0,1},
                    {0,0,1},
                    {0,0,1},
            },
            {
                    {1,1,1},
                    {1,0,1},
                    {1,1,1},
                    {1,0,1},
                    {1,1,1},
            },
            {
                    {1,1,1},
                    {1,0,1},
                    {1,1,1},
                    {0,0,1},
                    {1,1,1},
            },
    };
}
