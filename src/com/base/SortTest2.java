package com.base;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortTest2 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        Random rand = new Random();

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                arr[r][c] = rand.nextInt(50);
            }
        }
        System.out.println("before..");
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }

        // 각 행의 총 합에 대해 오름차순 처리하시오.
        // 단 합이 같을 경우 첫 번째 숫자에 대한 내림차순,
        // 그마저 같을 때는 마지막 숫자의 오름차순

        System.out.println("after..");
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < o1.length; i++) {
                    sum1 += o1[i];
                }

                for (int i = 0; i < o2.length; i++) {
                    sum2 += o2[i];
                }

                if (sum1 == sum2) {
                    if (o1[0] == o2[0]) {
                        return Integer.compare(o1[o1.length - 1], o2[o2.length - 1]);
                    } else {
                        return Integer.compare(o1[0], o2[0]) * -1;
                    }
                } else {
                    return Integer.compare(sum1, sum2);
                }
            }
        });
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
