package com.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 좋은아침 {
    static char[] src = {'a', 'b', 'c', 'd'};

    public static void main(String[] args) {
        // 1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
        System.out.println("부분집합");
//        powerset();
        // 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
        System.out.println("조합");
//         makeCombination(3, 0, new char[3]);
        // 3. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
        System.out.println("순열");
         makePermutation(3, new char[3], new boolean[src.length]);
    }
    static void makeCombination(int r, int start, char[] temp) {
        if (r == 0) {
            System.out.println(Arrays.toString(temp));
            return;
        }
        for (int i = start; i < src.length; i++) {
            temp[r - 1] = src[i];
            makeCombination(r - 1, i + 1, temp);
        }
    }

    static void makePowerset() {
        for (int i = 0; i < (1 << src.length); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < src.length; j++) {
                if ((i & (1 << j)) > 0) {
                    list.add(j);
                }
            }
            System.out.println(list);
        }
    }
    static void powerset() {
        // 전체 집합의 총 개수: 2^n : 1<<n
        for (int i = 1; i < (1 << src.length) - 1; i++) {
            System.out.println(i + ":" + Integer.toBinaryString(i));
            List<Integer> list = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int j = 0; j < src.length; j++) {
                if ((i & (1 << j)) > 0) {
                    // System.out.print("\t" + j);
                    list.add(j);
                } else {
                    list2.add(j);
                }
            }
            System.out.println(list + " :" + list2);
        }
    }

    static void makePermutation(int r, char[] temp, boolean[] visited) {
        if (r == 0) {
            System.out.println(Arrays.toString(temp));
            return;
        }
        for (int i = 0; i < src.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[r - 1] = src[i];
                makePermutation(r - 1, temp, visited);
                visited[i] = false;
            }
        }
    }

    
}
