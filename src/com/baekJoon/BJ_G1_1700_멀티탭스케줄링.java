package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G1_1700_멀티탭스케줄링 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());

        List<Integer> list = new ArrayList<>();
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<K; i++){
            list.add(Integer.parseInt(tokens.nextToken()));
        }
        Queue<Node> queue = new LinkedList<>();
        for (int i=0; i<list.size(); i++){
            int item = list.get(i);
            int priority = Integer.MAX_VALUE;
            for(int j=i+1; j<list.size(); j++){
                 if(item == list.get(j)){
                     priority = j-i;
                     break;
                 }
            }
            queue.offer(new Node(item, priority));
        }

        int answer = 0;
        List<Node> multitab = new ArrayList<>();
        while (!queue.isEmpty()){
            Node front = queue.poll();
            // front 가 멀티탭에 이미 존재할 경우 >> priority만 변경
            boolean isExist = false;
            for(int i=0; i<multitab.size(); i++){
                if (multitab.get(i).item == front.item) {
                    multitab.get(i).priority = front.priority;
                    isExist = true;
                    break;
                }
            }
            // front 가 멀티탭에 존재하지 않을 경우 >> 자리가 있다면 추가, 자리가 없다면 제일 안쓰이는거 빼고 추가
            if(!isExist){
                if(multitab.size() < N){
                    multitab.add(front);
                }else{
                    Collections.sort(multitab);
                    multitab.remove(0); // 제일 오랫동안 안쓰이는것 제거
                    answer++;
                    multitab.add(front);
                }
            }
            for(int i=0; i<multitab.size(); i++){
                multitab.get(i).priority--;
            }
        }
        System.out.println(answer);

    }

    static class Node implements Comparable<Node>{
        int item;
        int priority;

        public Node(int item, int priority) {
            this.item = item;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "{" +
                    item +
                    ", " + priority +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.priority, this.priority);
        }
    }

    static String src =
        "3 100\n" +
                "56 71 70 25 52 77 76 8 68 71 51 65 13 23 7 16 19 54 95 18 86 74 29 76 61 93 44 96 32 72 64 19 50 49 22 14 7 64 24 83 6 3 2 76 99 7 76 100 60 60 6 50 90 49 27 51 37 61 16 84 89 51 73 28 90 77 73 39 78 96 78 13 92 54 70 69 62 78 7 75 30 67 97 98 19 86 90 90 2 39 41 58 57 84 19 8 52 39 26 7";
}
