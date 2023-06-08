package com.baekJoon;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_G2_1655_가운데를말해요 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(input.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(input.readLine());
            if(maxHeap.isEmpty()) maxHeap.add(num);
            else if (maxHeap.peek() > num) {
                maxHeap.add(num);
                if(maxHeap.size() == minHeap.size()+2){
                    minHeap.add(maxHeap.poll());
                }
            }else{
                minHeap.add(num);
                if(maxHeap.size() < minHeap.size()){
                    maxHeap.add(minHeap.poll());
                }
            }
            output.append(maxHeap.peek()+"\n");
        }
        output.close();
    }

    static String src =
            "9\n" +
            "1\n" +
            "5\n" +
            "2\n" +
            "10\n" +
            "-99\n" +
            "7\n" +
            "11\n" +
            "12\n" +
            "5";
}
