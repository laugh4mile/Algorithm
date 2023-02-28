package com.programmers;

import java.util.Arrays;

public class L2_행렬테두리회전하기 {
    static int[] answer;
    public static int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        int[][] map = new int [rows][columns];
        int cnt = 1;
        for(int r=0; r<rows; r++){
            for(int c=0; c<columns; c++){
                map[r][c] = cnt++;
            }
        }
        for(int i=0; i<queries.length; i++){
            map = rotateMap(map, queries, i);
        }
//        printMap(map);
        return answer;
    }

    static void printMap(int[][] map){
        for(int r=0; r<map.length; r++){
            for(int c=0; c<map[0].length; c++){
                System.out.printf("%3d",map[r][c]);
            }
            System.out.println();
        }
    }
    private static int[][] rotateMap(int[][] map, int[][] queries, int idx) {
        int r1 = queries[idx][0]-1;
        int c1 = queries[idx][1]-1;
        int r2 = queries[idx][2]-1;
        int c2 = queries[idx][3]-1;
        int[][] tempMap = new int[map.length][map[0].length];
        int min = Integer.MAX_VALUE;
        for(int r=0; r<map.length; r++){
            for(int c=0; c<map[0].length; c++){
                tempMap[r][c] = map[r][c];
            }
        }

        for(int i=c1+1; i<=c2; i++){
            map[r1][i] = tempMap[r1][i-1];
            min = Integer.min(min, map[r1][i]);
        }
        for(int i=r1+1; i<=r2; i++){
            map[i][c2] = tempMap[i-1][c2];
            min = Integer.min(min, map[i][c2]);
        }
        for(int i=c2-1; i>=c1; i--){
            map[r2][i] = tempMap[r2][i+1];
            min = Integer.min(min, map[r2][i]);
        }
        for(int i=r2-1; i>=r1; i--){
            map[i][c1] = tempMap[i+1][c1];
            min = Integer.min(min, map[i][c1]);
        }
        answer[idx] = min;

        return map;
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(solution(rows,columns,queries)));
    }
}
