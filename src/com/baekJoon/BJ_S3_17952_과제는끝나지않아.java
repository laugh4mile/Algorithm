package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S3_17952_과제는끝나지않아 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;


    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        int answer = 0;
        Stack<Task> stack = new Stack<>();
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            int task = Integer.parseInt(tokens.nextToken());

            if(!stack.isEmpty()){
                if(--stack.peek().time == 0){
                    answer += stack.pop().score;
                }
            }
            if(task == 0) continue;

            int score = Integer.parseInt(tokens.nextToken());
            int time = Integer.parseInt(tokens.nextToken());

            stack.push(new Task(i, score, time));
        }
        if(!stack.isEmpty() && stack.peek().time == 1){
            answer += stack.pop().score;
        }
        System.out.println(answer);

    }

    static class Task{
        int no;
        int score;
        int time;

        public Task(int no, int score, int time) {
            this.no = no;
            this.score = score;
            this.time = time;
        }

    }

    static String src =
            "3\n" +
            "1 100 3\n" +
            "0\n" +
            "0";
}
