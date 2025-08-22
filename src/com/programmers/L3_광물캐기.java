package com.programmers;

import java.util.Arrays;

public class L3_광물캐기 {
    static int min;
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int size = minerals.length/5;
        if(minerals.length % 5 > 0){
            size++;
        }

        int arr[][] = new int[size][3];

        for(int i=0; i<minerals.length; i++){
            switch (minerals[i]){
                case "diamond" :
                    arr[i/5][0] += 1;
                    arr[i/5][1] += 5;
                    arr[i/5][2] += 25;
                    break;
                case "iron" :
                    arr[i/5][0] += 1;
                    arr[i/5][1] += 1;
                    arr[i/5][2] += 5;
                    break;
                case "stone" :
                    arr[i/5][0] += 1;
                    arr[i/5][1] += 1;
                    arr[i/5][2] += 1;
                    break;
            }
        }

        for(int[] x : arr){
            System.out.println(Arrays.toString(x));
        }
        min = Integer.MAX_VALUE;
        getMin(arr, picks[0], picks[1], picks[2], 0, 0);
        answer = min;

        return answer;
    }

    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int answer = solution(picks, minerals);
        System.out.println(answer);

        int[] picks2 = {0, 1, 1};
        String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        int answer2 = solution(picks2, minerals2);
        System.out.println(answer2);

    }

    private static void getMin(int[][] arr, int diaPick, int ironPick, int stonePick, int tired, int cnt) {
        if(diaPick == 0 && ironPick == 0 && stonePick == 0){
            if(min > tired){
                min = tired;
            }
            return;
        }

        if(cnt == arr.length){
            if(min > tired){
                min = tired;
            }
            return;
        }

        if(diaPick > 0){
            getMin(arr, diaPick-1, ironPick, stonePick, tired + arr[cnt][0], cnt+1);
        }
        if(ironPick > 0){
            getMin(arr, diaPick, ironPick-1, stonePick, tired + arr[cnt][1], cnt+1);
        }
        if(stonePick > 0){
            getMin(arr, diaPick, ironPick, stonePick-1, tired + arr[cnt][2], cnt+1);
        }

    }
}