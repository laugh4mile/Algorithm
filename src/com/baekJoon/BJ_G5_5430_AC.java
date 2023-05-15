package com.baekJoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_G5_5430_AC {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int T = Integer.parseInt(input.readLine());
        for(int t=0; t<T; t++){
            char commands[] = input.readLine().toCharArray(); // 1~100000
            int n = Integer.parseInt(input.readLine());
            int arr[] = new int[n];
            String str = input.readLine();
            str = str.substring(1,str.length()-1);
            tokens = new StringTokenizer(str,",");
            Deque<Integer> deque = new LinkedList<>();
            while(tokens.hasMoreTokens()){
                deque.offer(Integer.parseInt(tokens.nextToken()));
            }

            boolean direction = true; // t : 정방향 , f : 역방향
            boolean isError = false;
            for(int i=0; i<commands.length; i++){
                if(commands[i] == 'D'){ // 버리기
                   if(deque.isEmpty()){
                       isError = true;
                       break;
                   }else{
                       if(direction){
                           deque.pollFirst();
                       }else{
                           deque.pollLast();
                       }
                   }
                }else{ // 뒤집기
                    if(direction){
                        direction = false;
                    }else{
                        direction = true;
                    }
                }
            }
            if(isError){
                output.append("error\n");
            }else{
                output.append("[");
                if(direction){
                    while (!deque.isEmpty()){
                        output.append(deque.pollFirst()+"");
                        if(!deque.isEmpty()){
                            output.append(",");
                        }
                    }
                }else{
                    while (!deque.isEmpty()){
                        output.append(deque.pollLast()+"");
                        if(!deque.isEmpty()){
                            output.append(",");
                        }
                    }
                }
                output.append("]\n");
            }
        }
        output.close();

    }

    static String src =
            "4\n" +
            "RDD\n" +
            "4\n" +
            "[1,2,3,4]\n" +
            "DD\n" +
            "1\n" +
            "[42]\n" +
            "RRD\n" +
            "6\n" +
            "[1,1,2,3,5,8]\n" +
            "D\n" +
            "0\n" +
            "[]";
}
