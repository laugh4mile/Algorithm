package com.programmers;

import java.util.Stack;

class L2_괄호회전하기 {
    public static int solution(String s) {
        int answer = 0;
        outer:for(int i=0; i<s.length(); i++){
            Stack<Character> stack = new Stack<>();
            System.out.println(s);
            for(int j=0; j<s.length(); j++) {
                if (stack.isEmpty()) {
                    if (s.charAt(j) == ']' || s.charAt(j) == '}' || s.charAt(j) == ')') {
                        s = s.substring(1).concat(s.charAt(0)+"");
                        continue outer;
                    } else {
                        stack.push(s.charAt(j));
                    }
                } else {
                    if (s.charAt(j) == '[' || s.charAt(j) == '{' || s.charAt(j) == '(') {
                        stack.push(s.charAt(j));
                    } else {
                        if (stack.peek() == '[') {
                            if (s.charAt(j) == ']') {
                                stack.pop();
                            } else {
                                s = s.substring(1).concat(s.charAt(0)+"");
                                continue outer;
                            }
                        } else if (stack.peek() == '{') {
                            if (s.charAt(j) == '}') {
                                stack.pop();
                            } else {
                                s = s.substring(1).concat(s.charAt(0)+"");
                                continue outer;
                            }
                        } else if (stack.peek() == '(') {
                            if (s.charAt(j) == ')') {
                                stack.pop();
                            } else {
                                s = s.substring(1).concat(s.charAt(0)+"");
                                continue outer;
                            }
                        }
                    }
                }
            }
            if(stack.isEmpty()) {
                System.out.println("!!");
                answer++;
            }
            s = s.substring(1).concat(s.charAt(0)+"");
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}"	));
    }
}