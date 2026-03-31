package com.programmers;

import java.util.Stack;

public class L2_올바른괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        if(stack.size() > 0){
            return false;
        }

        return true;
    }
}
