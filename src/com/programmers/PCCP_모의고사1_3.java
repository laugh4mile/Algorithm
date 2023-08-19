package com.programmers;

import java.util.Arrays;
import java.util.Stack;

public class PCCP_모의고사1_3 {
    static Stack<Integer> stack = new Stack<>();
    public static String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        long sum = 0;
        for(int i=0; i<queries.length; i++){
            stack.clear();
            getChildIdx(queries[i][0], queries[i][1]); // 몇번째 자식인지 알아냄
//            System.out.println(stack);
            answer[i] = getAnswer(stack);
        }
        return answer;
    }

    private static String getAnswer(Stack stack) {
        String bean = "Rr";
        while(!stack.isEmpty()){
            int cur = (Integer) stack.pop();
            if(cur == 0){
                return bean.charAt(0)+""+bean.charAt(0);
            }else if(cur == 3){
                return bean.charAt(1)+""+bean.charAt(1);
            }
        }
        return bean;
    }

    private static void getChildIdx(int n, int p) {
        p--;
        n--;
        while(n-->0){
            stack.push(p%4);
            p/=4;
        }
    }

    public static void main(String[] args) {
        int[][] queries = {{3, 1},{2, 3},{3, 9}};
        System.out.println(Arrays.toString(solution(queries)));
    }
}
