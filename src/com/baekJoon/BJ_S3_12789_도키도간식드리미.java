package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S3_12789_도키도간식드리미 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        String answer = "Nice";

        int N = Integer.parseInt(input.readLine());
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        tokens = new StringTokenizer(input.readLine());

        for(int i=0; i<N; i++){
            queue.offer(Integer.parseInt(tokens.nextToken()));
        }

        int cur = 1;
        while (!queue.isEmpty() || !stack.isEmpty()){ // queue와 stack에 하나라도 남아있다면
            if(queue.isEmpty() && !stack.isEmpty() && stack.peek() != cur){ // Sad 인경우
                answer = "Sad";
                break;
            }

            while(!stack.isEmpty() && stack.peek() == cur){ // stack을 먼저 봐야함
                stack.pop();
                cur++;
            }

            if(!queue.isEmpty()){
                if (queue.peek() == cur) {
                    queue.poll();
                    cur++;
                }else{
                    stack.push(queue.poll());
                }
            }
        }

        System.out.println(answer);
    }

    static String src =
            "10\n" +
                    "5 4 3 2 1 6 7 8 9 10";
}
