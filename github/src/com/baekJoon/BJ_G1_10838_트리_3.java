package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G1_10838_트리_3 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int parent[]; // parent[i] : i 의 부모노드
    static int color[]; // color[i] : i 노드에서 부모노드 사이에 칠해진 페인트 색깔
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());
        parent = new int[N];
        color = new int[N];
        parent[0] = -1; // 0은 부모가 없음 ㅜㅜ

        for(int i=0; i<K; i++){
            tokens = new StringTokenizer(input.readLine());
            int r = Integer.parseInt(tokens.nextToken());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            int c = 0;
            if(r == 1){ // paint
                c = Integer.parseInt(tokens.nextToken());
                int commonParent = getCommonParent(a,b);
                while (a != commonParent){
                    color[a] = c;
                    a = parent[a];
                }
                while (b != commonParent){
                    color[b] = c;
                    b = parent[b];
                }
            }else if(r == 2){ // move
                parent[a] = b;
            }else{ // count
                int commonParent = getCommonParent(a,b);
                Set<Integer> set = new HashSet<>();
                while (a != commonParent){
                    set.add(color[a]);
                    a = parent[a];
                }
                while (b != commonParent){
                    set.add(color[b]);
                    b = parent[b];
                }
                output.append(set.size()+"\n");
            }
        }
        output.close();

    }
    static int getCommonParent(int a, int b){
        if(a == 0 || b == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        set.add(a);
        int cnt = 0;
        while (a != 0){
            if(cnt++ >= 1000) break;
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
