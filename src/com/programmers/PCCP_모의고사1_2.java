package com.programmers;

import java.util.Arrays;

public class PCCP_모의고사1_2 {
    static int N, R, result[], temp[][], max;
    static boolean isSelected[];
    public static int solution(int[][] ability) {
        int answer = 0;
        N = ability.length;
        R = ability[0].length;
        result = new int[R];
        isSelected = new boolean[N];
        temp = new int[N][R];
        for(int i=0; i<N; i++){
            for(int j=0; j<R; j++){
                temp[i][j] = ability[i][j];
            }
        }
        permutation(0);
        answer = max;
        return answer;
    }

    private static void permutation(int cnt) {
        if(cnt == R){
            int sum = 0;
            for(int i=0; i<result.length; i++){
                sum += temp[result[i]][i];
            }
            if(max < sum){
                max = sum;
            }
            return;
        }
        for(int i=0; i<N; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            result[cnt] = i;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }

    private static void combination(int start, int cnt) {
        if(cnt == R){
            System.out.println(Arrays.toString(result));
            int sum = 0;
            for(int i=0; i<result.length; i++){
                sum += temp[result[i]][i];
            }
            System.out.println(sum);
            if(max < sum){
                max = sum;
            }
            return;
        }
        for(int i=start; i<N; i++){
            result[cnt] = i;
            combination(i+1, cnt+1);
        }
    }

    public static void main(String[] args) {
        int[][] ability = {{40, 10, 10},{20, 5, 0},{30, 30, 30},{70, 0, 70},{100, 100, 100}};
        System.out.println(solution(ability));
    }
}
