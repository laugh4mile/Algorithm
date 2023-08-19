package com.baekJoon;

import java.io.*;
import java.util.Stack;

public class BJ_S1_9009_피보나치 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(input.readLine());

        int [] fivo = new int[45];
        fivo[1] = 1;
        for(int i=2; i<fivo.length; i++){
            fivo[i] = fivo[i-1]+fivo[i-2];
        }

        Stack<Integer> stack = new Stack<>();
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(input.readLine());
            for(int i=fivo.length-1; i>0; i--){
                if(n >= fivo[i]){
                    stack.add(fivo[i]);
                    n -= fivo[i];
                }
            }
            while(!stack.isEmpty()){
                output.append(stack.pop()+" ");
            }
            output.append("\n");
        }
        output.close();
    }

    static String src =
            "4\n" +
                    "100\n" +
                    "200\n" +
                    "12345\n" +
                    "1003";
}
