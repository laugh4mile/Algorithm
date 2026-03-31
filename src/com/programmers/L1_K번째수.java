package com.programmers;

import java.util.Arrays;

public class L1_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            int start = commands[i][0];
            int end   = commands[i][1];
            int idx   = commands[i][2];

            int[] arr = new int[end - start + 1];

            for(int j=0; j<arr.length; j++){
                arr[j] = array[j+start-1];
            }
            Arrays.sort(arr);
            answer[i] = arr[idx-1];
        }

        return answer;
    }
}
