package com.programmers;

import java.util.Arrays;

class L3_숫자게임 {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        for(int i=0; i<A.length; i++){
            if(idx == B.length)break;
            for(int j=idx; j<B.length; j++){
                if(A[i] < B[j]){
                    answer++;
                    idx = j+1;
                    break;
                }
            }
        }
        return answer;
    }

    static class Node implements Comparable<Node>{
        int team;
        int num;

        public Node(int team, int num){
            this.team = team;
            this.num = num;
        }

        @Override
        public int compareTo(Node o){
            if(this.num == o.num){
                return Integer.compare(o.team, this.team);
            }
            return Integer.compare(this.num, o.num);
        }
    }

    public static void main(String[] args) {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        System.out.println(solution(A,B));
    }
}