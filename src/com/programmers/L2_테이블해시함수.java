package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L2_테이블해시함수 {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[col-1] == o2[col-1]){
                    return Integer.compare(o2[0], o1[0]);
                }
                return Integer.compare(o1[col-1], o2[col-1]);
            }
        });

        List<Integer> list = new ArrayList<>();

        for(int i=row_begin-1; i<=row_end-1; i++){
            int sum = 0;
            for(int j=0; j< data[i].length; j++){
                sum += data[i][j] % (i+1);
            }
            list.add(sum);
        }

        answer = list.get(0);
        for(int i=1; i<list.size(); i++){
            answer ^= list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        System.out.println(solution(data,2,2,3));
    }
}
