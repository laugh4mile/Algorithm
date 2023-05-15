package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G1_1981_배열에서이동_현욱 {
    static int N, board[][];
    static int dy[] = {0, 0,-1, 1};
    static int dx[] = {1,-1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }
    static void pro() {
        int left = 0, right = 200, answer = 0;
        while(left<=right) {
            int mid = (left+right)/2;
            if(bfs(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
    static boolean bfs(int mid) {
        for(int p=0; p<=200; p++) {
            int s = p;
            int e = p + mid;
            if(board[0][0]<s || board[0][0]>e) continue;
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visit = new boolean[N][N];
            q.add(new int[] {0, 0});
            visit[0][0] = true;
            while(!q.isEmpty()) {
                int[] info = q.poll();
                int cy = info[0];
                int cx = info[1];
                if(cy==N-1 && cx==N-1)
                    return true;
                for(int d=0; d<4; d++) {
                    int ny = cy + dy[d];
                    int nx = cx + dx[d];
                    if(isNotRange(ny, nx)) continue;
                    if(visit[ny][nx]) continue;
                    if(board[ny][nx]<s || board[ny][nx]>e) continue;
                    q.add(new int[] {ny, nx});
                    visit[ny][nx] = true;
                }
            }
        }
        return false;
    }
    static boolean isNotRange(int y, int x) {
        return y<0 || x<0 || y>=N || x>=N;
    }
}