package com.codingtest.deliveryhero;

import java.util.Stack;
import java.util.StringTokenizer;

public class Q1 {
	int range = (int)Math.pow(2,20)-1;
    public int solution(String S) {
        // write your code in Java SE 8
        int answer = 0;
        StringTokenizer tokens = new StringTokenizer(S);
        Stack<Integer> stack = new Stack<>();
        while(tokens.hasMoreTokens()){
            String str = tokens.nextToken();
            if(Character.isDigit(str.charAt(0))){
                stack.push(Integer.parseInt(str));
            }else if(str.charAt(0) == 'D'){
                stack.push(stack.peek());
            }else if(str.charAt(0) == 'P'){
                if(stack.isEmpty()){
                    return -1;
                }
                stack.pop();
            }else if(str.charAt(0) == '+'){
                if(stack.size()<2){
                    return -1;
                }else{
                    int sum = 0;
                    sum += stack.pop();
                    sum += stack.pop();
                    if(sum > range){
                        return -1;
                    }
                    stack.push(sum);
                }
            }else{
                if(stack.size()<2){
                    return -1;
                }else{
                    int chai = stack.pop();
                    chai -= stack.pop();
                    if(chai<0){
                        return -1;
                    }
                    stack.push(chai);
                }
            }
        }
        answer = stack.peek();
        return answer;
    }
}
