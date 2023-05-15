package com.baekJoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S4_9012_괄호 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(input.readLine());
        for(int t=0; t<T; t++){
            String line = input.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for(int i=0; i<line.length(); i++){
                if(line.charAt(i) == '(') stack.push('(');
                else {
                    if(stack.isEmpty()){
                        flag = true;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty() || flag) output.append("NO\n");
            else output.append("YES\n");
        }
        output.close();
    }

    static String src =
            "6\n" +
            "(())())\n" +
            "(((()())()\n" +
            "(()())((()))\n" +
            "((()()(()))(((())))()\n" +
            "()()()()(()()())()\n" +
            "(()((())()(";
}
