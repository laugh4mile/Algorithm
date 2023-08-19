package com.review;

public class L2_NQueen {
    static int board[], N, answer;
    public static int solution(int n) {
        N = n;
        board = new int[n];

        dfs(0);
        return answer;
    }

    private static void dfs(int cnt) {
        if(cnt == N){
            answer++;
            return;
        }

        for(int i=0; i<N; i++){
            board[cnt] = i;
            if(checkLocation(cnt)){
                dfs(cnt+1);
            }
        }
    }

    private static boolean checkLocation(int x) {
        for(int i=0; i<x; i++){
            if(board[i] == board[x] || Math.abs(i-x) == Math.abs(board[i]-board[x])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}