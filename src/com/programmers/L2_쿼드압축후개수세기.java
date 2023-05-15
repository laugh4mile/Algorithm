package com.programmers;

import java.util.Arrays;

class L2_쿼드압축후개수세기 {
    static int[] answer = new int[2];
    public static int[] solution(int[][] arr) {

//        for (int []x : arr){
//            System.out.println(Arrays.toString(x));
//        }
        int N = arr.length;

        divide(arr,0,0,N,N,N);

        return answer;
    }

    private static void divide(int[][] arr, int sR, int sC, int eR, int eC, int N) {
        boolean isEqual = true;
        int val = arr[sR][sC];
        outer:for(int r=sR; r<eR; r++){
            for(int c=sC; c<eC; c++){
                if(arr[r][c] != val) {
                    isEqual = false;
                    break outer;
                }
            }
        }
        if(isEqual){
            if(val == 0){
                answer[0]++;
            }else{
                answer[1]++;
            }
            return;
        }

        divide(arr,sR,sC,sR+N/2,sC+N/2, N/2);
        divide(arr, sR,sC+N/2,sR+N/2, eC,N/2);
        divide(arr, sR+N/2,sC,eR, sC+N/2,N/2);
        divide(arr, sR+N/2,sC+N/2,eR, eC,N/2);
    }


    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr)));
    }
}