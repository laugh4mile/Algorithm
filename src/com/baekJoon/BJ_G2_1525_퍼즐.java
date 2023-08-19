package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G2_1525_퍼즐 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int move[]={-1,1,-3,3}; // 좌, 우, 상, 하
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        String initial = "";
        int zeroIdx = -1;
        for(int r=0; r<3; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<3; c++){
                char num = tokens.nextToken().charAt(0);
                initial += num;
                if(num == '0'){
                    zeroIdx = r*3+c;
                }
            }
        }
        System.out.println(bfs(initial, zeroIdx));
    }

    private static int bfs(String initial, int zeroIdx) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(initial, zeroIdx, 0));
        set.add(initial);

        while (!queue.isEmpty()) {
            Node front = queue.poll();
            if(front.str.equals("123456780")){
                return front.cnt;
            }
            for(int i=0; i<4; i++){
                if(front.zeroIdx%3 == 2 && i==1){
                    continue;
                }else if(front.zeroIdx%3 == 0 && i==0){
                    continue;
                }
                int nextZeroIdx = front.zeroIdx + move[i];
                if(isIn(nextZeroIdx)){
                    char ch = front.str.charAt(nextZeroIdx);
                    String temp = front.str.replace('0','t');
                    temp = temp.replace(ch,'0');
                    temp = temp.replace('t',ch);
                    if(!set.contains(temp)){
                        set.add(temp);
                        queue.offer(new Node(temp, nextZeroIdx, front.cnt+1));
                    }
                }
            }
        }
        return -1;
    }

    static class Node{
        String str;
        int cnt;
        int zeroIdx;

        public Node(String str, int zeroIdx, int cnt) {
            this.str = str;
            this.zeroIdx = zeroIdx;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "str='" + str + '\'' +
                    ", cnt=" + cnt +
                    ", zeroIdx=" + zeroIdx +
                    '}';
        }
    }

    static boolean isIn(int i){
        return (i>=0 && i<9);
    }

    static String src =
            "6 4 7\n" +
            "8 5 0\n" +
            "3 2 1";
}
