package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G1_10838_트리 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static List<Node> graph[];
    static int parent[];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());
        parent = new int[N];
        parent[0] = -1; // 0은 부모가 없음 ㅜㅜ

        graph = new List[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            graph[0].add(new Node(i, 0));
        }

        for(int i=0; i<K; i++){
            tokens = new StringTokenizer(input.readLine());
            int r = Integer.parseInt(tokens.nextToken());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            int c = 0;
            if(r == 1){ // paint
                c = Integer.parseInt(tokens.nextToken());
                int commonParent = getCommonParent(a,b);
//                System.out.println(commonParent);
            }else if(r == 2){ // move
                for(int j=0; j<graph[parent[a]].size(); j++){
                    if(graph[parent[a]].get(j).child == a){
                        graph[b].add(graph[parent[a]].get(j));
                        graph[parent[a]].remove(j);
                        break;
                    }
                }
                parent[a] = b;
            }else{ // count
            }
        }

    }
    static int getCommonParent(int a, int b){
        if(a == 0 || b == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        set.add(a);
        while (a != 0){
            a = parent[a];
            set.add(a);
        }
        while (b != 0){
            if(set.contains(b)){
                return b;
            }
            set.add(b);
            b = parent[b];
        }
        return 0;
    }
    static class Node{
        int child;
        int color;

        public Node(int child, int color) {
            this.child = child;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Node{" +
                    ", child=" + child +
                    ", color=" + color +
                    '}';
        }
    }


    static String src =
            "6 8\n" +
            "2 1 3\n" +
            "2 5 3\n" +
            "1 5 4 8\n" +
            "3 4 5\n" +
            "2 3 4\n" +
            "1 0 3 7\n" +
            "3 2 5\n" +
            "3 4 2";
}
