package com.baekJoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_G1_2233_사과나무 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int[] parents, arr;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        parents = new int[N];
        arr = new int[2*N];

        String str = input.readLine();

        int cur = -1; // 애벌레 위치
        int cnt = -1; // 열매 번호
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0'){ // 부모 -> 새로운 자식
                parents[++cnt] = cur;
                cur = cnt;
                arr[i] = cnt;
            }else{ // 자식 -> 부모
                arr[i] = cur;
                cur = parents[cur];
            }
        }

        tokens = new StringTokenizer(input.readLine());
        int i = Integer.parseInt(tokens.nextToken())-1;
        int j = Integer.parseInt(tokens.nextToken())-1;
        i = arr[i];
        j = arr[j];

        int commonParent = getCommonParent(i, j);
        for(int idx=0; idx<arr.length; idx++){
            if(arr[idx] == commonParent) {
                System.out.print(idx+1+" ");
            }
        }
    }

    private static int getCommonParent(int a, int b) { // a, b는 썩은 열매
        if(a == b) return a;

        if(a == 0 || b == 0) return 0;

        Set<Integer> set = new HashSet<>();

        while (a != 0){
            set.add(a);
            a = parents[a];
        }

        while (b != 0){
            if(set.contains(b)){
               return b;
            }
            b = parents[b];
        }
        return 0;
    }

    static String src =
            "5\n" +
            "0001011011\n" +
            "4 5";
}
