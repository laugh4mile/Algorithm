package com.codingtest.sk.skt.second;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q4 {
    static int n = 8;
    static int m = 4;
    static int k = 4;
    static int[][] records = {{1, 5, 1, 3}, {5, 7, 5, 6}};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(n,m,k,records)));
    }

    public static int[] solution(int n, int m, int k, int[][] records) {
        int[] answer = new int[records[0].length];
        int len = Integer.MAX_VALUE; // 비밀번호의 범위는 x ~ x+len 이다.
        boolean use_1 = false; // 비밀번호에 포함된 숫자 중 최소값. 1이 포함되는 경우를 판단하기 위해 쓰인다.
        boolean use_N = false; // 비밀번호에 포함된 숫자 중 최대값. n이 포함되는 경우를 판단하기 위해 쓰인다.
        Set<Integer> set = new HashSet<>();
        int countOfNums = 0;
        for(int i=0; i<records[0].length; i++){
            if(!set.contains(records[0][i])){
                set.add(records[0][i]);
                countOfNums++;
            }
        }
        for(int i=0; i<records.length; i++){
            int min = Integer.MAX_VALUE;
            int max = 0;
            for(int j=0; j<records.length; j++){
                if(records[i][j] < min){
                    min = records[i][j];
                }
                if(records[i][j] > max){
                    max = records[i][j];
                }
                if(records[i][j] == 1){
                    use_1 = true;
                }
                if(records[i][j] == n){
                    use_N = true;
                }
            }
            if(max - min < len){
                len = max - min+1;
            }
        }
        // 이제 난 pw가 1을 포함하는지, n을 포함하는지, 범위는 어떻게 되는지, 총 몇개의 숫자를 쓰는지 알고있다.
//        System.out.println(len);
//        System.out.println(countOfNums);
        if(use_1 && use_N){ // 1과 N이 둘다 포함될때
            if(len == countOfNums){ // 범위와 사용하는 숫자의 갯수가 같을 경우.
                return records[0]; // 단 한가지 경우 밖에 없다. {1,2,3,4,...,n}
            }
            answer[0] = 1;
            answer[answer.length-1] = n;
            int el = n-1;
            for(int i=answer.length-2; i>0; i--){
                answer[i] = el--;
            }
        }else if(use_1 && !use_N){ // 1만 포함될때

        }else if(!use_1 && use_N){ // N만 포함될때

        }else if(!use_1 && !use_N){ // 둘다 포함되지 않을때

        }
        return answer;
    }
}
