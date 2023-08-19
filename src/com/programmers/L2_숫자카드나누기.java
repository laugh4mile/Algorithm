package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L2_숫자카드나누기 {
    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        List<Integer> list = new ArrayList<>();
        for(int i=1; i*i<=arrayA[0]; i++){
            if(arrayA[0]%i == 0){
                if(i*i == arrayA[0]){
                    list.add(i);
                }else{
                    list.add(i);
                    list.add(arrayA[0]/i);
                }
            }
        }
        Collections.sort(list, Collections.reverseOrder());

        List<Integer> list2 = new ArrayList<>();
        for(int i=1; i*i<=arrayB[0]; i++){
            if(arrayB[0]%i == 0){
                if(i*i == arrayB[0]){
                    list2.add(i);
                }else{
                    list2.add(i);
                    list2.add(arrayB[0]/i);
                }
            }
        }
        Collections.sort(list2, Collections.reverseOrder());

        outer : for(int i=0; i<list.size(); i++){
            for(int j=0; j<arrayB.length; j++){
                if(arrayA[j] % list.get(i) != 0 ||  arrayB[j] % list.get(i) == 0){
                    continue outer;
                }
            }
            answer = list.get(i);
            break;
        }

        outer : for(int i=0; i<list2.size(); i++){
            for(int j=0; j<arrayA.length; j++){
                if(arrayB[j] % list2.get(i) != 0 || arrayA[j] % list2.get(i) == 0){
                    continue outer;
                }
            }
            answer = Math.max(answer, list2.get(i));
            break;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};

        System.out.println(solution(arrayA, arrayB));
    }
}
