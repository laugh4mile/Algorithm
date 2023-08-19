package com.baekJoon;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_27979_볼링장아르바이트 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        int w[] = new int[N];
        tokens = new StringTokenizer(input.readLine());
        int max = 0;
        int maxIdx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            w[i] = Integer.parseInt(tokens.nextToken());
            pq.offer(w[i]);
            if(max <= w[i]){
                max = Math.max(max, w[i]);
                maxIdx = i;
            }
        }
        for(int i=maxIdx; i>=0; i--){
            if(w[i] == pq.peek()){
                pq.poll();
            }
        }
        System.out.println(pq.size());
    }

    static String src =
            "3\n" +
                    "1 2 3";
}
