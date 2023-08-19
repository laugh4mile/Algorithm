package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_23031_으어어에이쁠주세요 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N;
    static char map[][], cmd[];
    static boolean isOn[][];
    static List<Node> zombies = new ArrayList<>();
    static Node ari;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        map = new char[N][N];
        isOn = new boolean[N][N];
        String cmdStr = input.readLine();
        cmd = cmdStr.toCharArray();
        for(int r=0; r<N; r++){
            String line = input.readLine();
            for(int c=0; c<N; c++){
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'Z'){
                    zombies.add(new Node(r,c,2));
                }
            }
        }
        ari = new Node(0,0,2);

        for(int i=0; i<cmd.length; i++){
            if(cmd[i] == 'F'){
                moveAri(cmd[i]);
            }else if(cmd[i] == 'R'){
                ari.d = (ari.d + 1) % 4;
            }else{
                ari.d = (ari.d + 3) % 4;
            }
            if(map[ari.r][ari.c] == 'S'){
                turnOn(ari.r, ari.c);
            }
            if(!isOn[ari.r][ari.c]){
                if(isZombieZone()){
                    System.out.println("Aaaaaah!");
                    return;
                }
            }
            moveZombies();
            if(!isOn[ari.r][ari.c]){
                if(isZombieZone()){
                    System.out.println("Aaaaaah!");
                    return;
                }
            }
        }
//        for(boolean []x : isOn){
//            System.out.println(Arrays.toString(x));
//        }
        System.out.println("Phew...");
    }

    private static boolean isZombieZone() {
        for(int i=0; i<zombies.size(); i++){
            if(zombies.get(i).r == ari.r && zombies.get(i).c == ari.c){
                return true;
            }
        }
        return false;
    }

    private static void turnOn(int ar, int ac) {
        int sr = Math.max(ar-1, 0);
        int sc = Math.max(ac-1, 0);
        int er = Math.min(ar+1, N-1);
        int ec = Math.min(ac+1, N-1);

        for(int r=sr; r<=er; r++){
            for(int c=sc; c<=ec; c++){
                isOn[r][c] = true;
            }
        }
    }

    private static void moveAri(char cmd) {
        int nr = ari.r + dr[ari.d];
        int nc = ari.c + dc[ari.d];
        if(isIn(nr, nc)){
            ari.r = nr;
            ari.c = nc;
        }
    }

    private static void moveZombies() {
        for(int i=0; i<zombies.size(); i++){
            int nr = zombies.get(i).r + dr[zombies.get(i).d];
            int nc = zombies.get(i).c + dc[zombies.get(i).d];
            if(isIn(nr, nc)){
                zombies.get(i).r = nr;
                zombies.get(i).c = nc;
            }else{
                zombies.get(i).d = (zombies.get(i).d + 2) % 4;
            }
        }
    }

    static int dr[] = {-1,0,1,0}; // 상 우 하 좌
    static int dc[] = {0,1,0,-1};

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }

    static class Node{
        int r;
        int c;
        int d;

        public Node(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }

    static String src =
            "11\n" +
                    "FFFFFFRLRL\n" +
                    "OOOOOOOOOOO\n" +
                    "OOOOOOOOOOO\n" +
                    "OOOOOOOOOOO\n" +
                    "OOOOOOOOOOO\n" +
                    "OOOOOOOOOOO\n" +
                    "OOOOOOOOOOO\n" +
                    "SOOOOOOOOOO\n" +
                    "OOOOOOOOOOO\n" +
                    "OOOOOOOOOOO\n" +
                    "OOOOOOOOOOO\n" +
                    "ZOOOOOOOOOO";
}
