package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_S4_4949_균형잡힌세상 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        while(true){
            String line = input.readLine();
            if(line == null) break;
            sb.append(line);
        }
        String temp = sb.toString().replace('.','0');
        temp = temp.replaceAll("0","1.");

        tokens = new StringTokenizer(temp, ".");
        List<String> list = new ArrayList<>();
        while(tokens.hasMoreTokens()){
            String str = tokens.nextToken();
            if(isBalanced(str)){
                list.add("yes");
            }else{
                list.add("no");
            }
        }
        for(int i=0; i<list.size()-1; i++){
            output.append(list.get(i)+"\n");
        }
        output.close();
    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('[',']');
        map.put('(',')');
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '[' || c == '('){
                stack.push(c);
            }else if(c == ']' || c == ')'){
                if(!stack.isEmpty() && map.get(stack.peek()) == c){
                    stack.pop();
                }else{
                    return false;
                }

            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }


    static String src =
            "So when I die (the [first] I will see in (heaven) is a score list).\n" +
                    "[ first in ] ( first out ).\n" +
                    "Half Moon tonight (At least it is better than no Moon at all].\n" +
                    "A rope may form )( a trail in a maze.\n" +
                    "Help( I[m being held prisoner in a fortune cookie factory)].\n" +
                    "([ (([( [ ] ) ( ) (( ))] )) ]).\n" +
                    " .\n" +
                    ".";
}
