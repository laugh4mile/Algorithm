package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G5_18428_감시피하기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N;
    static char map[][];
    static boolean isOver;
    static List<Node> teachers = new ArrayList<>();
    static List<Node> blanks = new ArrayList<>();
    static int result[];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        map = new char[N][N];

        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = tokens.nextToken().charAt(0);
                if(map[r][c] == 'T'){
                    teachers.add(new Node(r, c));
                }
                if(map[r][c] == 'X'){
                    blanks.add(new Node(r, c));
                }
            }
        }
        result = new int[3];

        combi(0, 0);

        if(isOver){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    private static void combi(int start, int cnt) {
        if(isOver){
            return;
        }
        if(cnt == 3){
//            System.out.println(Arrays.toString(result));
            for(int i=0; i<result.length; i++){
                Node obstacle = blanks.get(result[i]);
                map[obstacle.r][obstacle.c] = 'O';
            }
            if(yesCheck()){
                isOver = true;
            }
            for(int i=0; i<result.length; i++){
                Node obstacle = blanks.get(result[i]);
                map[obstacle.r][obstacle.c] = 'X';
            }
            return;
        }
        for(int i=start; i<blanks.size(); i++){
            result[cnt] = i;
            combi(i+1, cnt+1);
        }
    }

    private static boolean yesCheck() {
        for(int i=0; i<teachers.size(); i++){
            Node t = teachers.get(i);
            for(int r=t.r; r<N; r++){
                if(map[r][t.c] == 'S'){
                    return false;
                }
                if(map[r][t.c] == 'O'){
                    break;
                }
            }
            for(int r=t.r; r>=0; r--){
                if(map[r][t.c] == 'S'){
                    return false;
                }
                if(map[r][t.c] == 'O'){
                    break;
                }
            }
            for(int c=t.c; c<N; c++){
                if(map[t.r][c] == 'S'){
                    return false;
                }
                if(map[t.r][c] == 'O'){
                    break;
                }
            }
            for(int c=t.c; c>=0; c--){
                if(map[t.r][c] == 'S'){
                    return false;
                }
                if(map[t.r][c] == 'O'){
                    break;
                }
            }
        }
        return true;
    }

    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static String src =
            "4\n" +
                    "S S S T\n" +
                    "X X X X\n" +
                    "X X X X\n" +
                    "T T T X";
}
