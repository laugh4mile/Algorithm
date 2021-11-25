package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_16935_배열돌리기3 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int N, M, rotate[][];
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken()); // R , C 는 짝수 이다.
        M = Integer.parseInt(tokens.nextToken());
        int ops = Integer.parseInt(tokens.nextToken());

        int map[][] = new int[N][M];
        for(int r = 0; r< N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c = 0; c< M; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }

        tokens = new StringTokenizer(input.readLine());

        for(int i=0; i<ops; i++){
            switch (Integer.parseInt(tokens.nextToken())) {
                case 1:
                    map = operation1(map);
                    break;
                case 2:
                    map = operation2(map);
                    break;
                case 3:
                    map = operation3(map);
                    break;
                case 4:
                    map = operation4(map);
                    break;
                case 5:
                    map = operation5(map);
                    break;
                case 6:
                    map = operation6(map);
                    break;
            }
            for(int x[] : map){
                System.out.println(Arrays.toString(x));
            }
            System.out.println();
        }

        for(int r=0; r<map.length; r++){
            for(int c=0; c<map[0].length; c++){
                output.append(map[r][c]+" ");
            }
            output.append("\n");
        }

        output.close();
    }

    private static int[][] operation1(int[][] map) { // 상하 반전
        int n = map.length;
        int m = map[0].length;
        int temp = 0;
        for(int c = 0; c< m; c++){
            // 0일때 R-1, 1일때 R-2, ...., n일때 R-n-1
            for(int r = 0; r< n /2; r++){
                temp = map[r][c];
                map[r][c] = map[n -r-1][c];
                map[n -r-1][c] = temp;
            }
        }
        return map;
    }
    private static int[][] operation2(int[][] map) { // 좌우 반전
        int n = map.length;
        int m = map[0].length;
        int temp = 0;
        for(int r = 0; r< n; r++){
            for(int c = 0; c< m /2; c++){
                // 0일때 C-1, 1일때 C-2, ...., n일때 C-n-1
                temp = map[r][c];
                map[r][c] = map[r][m -c-1];
                map[r][m -c-1] = temp;
            }
        }
        return map;
    }
    private static int[][] operation3(int[][] map) { // 오른쪽으로 90도 회전
        int n = map.length;
        int m = map[0].length;
        int rotate[][] = new int[m][n];
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                rotate[r][c] = map[n -1-c][r];
            }
        }
        return rotate;
    }
    private static int[][] operation4(int[][] map) { // 왼쪽으로 90도
        int n = map.length;
        int m = map[0].length;
        int rotate[][] = new int[m][n];
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                rotate[r][c] = map[c][m -1-r];
            }
        }
        return rotate;
    }
    private static int[][] operation5(int[][] map) { // 4분할하여 시계방향으로 회전
        int n = map.length;
        int m = map[0].length;
        int rotate[][] = new int[n][m];

        for(int r=0; r<n/2; r++){
            for(int c=0; c<m/2; c++){
                rotate[r][c] = map[r+n/2][c];
            }
        }
        for(int r=0; r<n/2; r++){
            for(int c=m/2; c<m; c++){
                rotate[r][c] = map[r][c-m/2];
            }
        }
        for(int r=n/2; r<n; r++){
            for(int c=m/2; c<m; c++){
                rotate[r][c] = map[r-n/2][c];
            }
        }
        for(int r=n/2; r<n; r++){
            for(int c=0; c<m/2; c++){
                rotate[r][c] = map[r][c+m/2];
            }
        }
        return rotate;
    }
    private static int[][] operation6(int[][] map) { // 4분할하여 반시계방향으로 회전
        int n = map.length;
        int m = map[0].length;
        int rotate[][] = new int[n][m];

        for(int r=0; r<n/2; r++){
            for(int c=0; c<m/2; c++){
                rotate[r][c] = map[r][c+m/2];
            }
        }
        for(int r=0; r<n/2; r++){
            for(int c=m/2; c<m; c++){
                rotate[r][c] = map[r+n/2][c];
            }
        }
        for(int r=n/2; r<n; r++){
            for(int c=m/2; c<m; c++){
                rotate[r][c] = map[r][c-m/2];
            }
        }
        for(int r=n/2; r<n; r++){
            for(int c=0; c<m/2; c++){
                rotate[r][c] = map[r-n/2][c];
            }
        }
        return rotate;
    }

    static String src =
            "6 8 5\n" +
                    "3 2 6 3 1 2 9 7\n" +
                    "9 7 8 2 1 4 5 3\n" +
                    "5 9 2 1 9 6 1 8\n" +
                    "2 1 3 8 6 3 9 2\n" +
                    "1 3 2 8 7 9 2 1\n" +
                    "4 5 1 9 8 2 1 3\n" +
                    "5 2 1 3 5";
}
