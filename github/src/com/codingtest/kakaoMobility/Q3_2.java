package com.codingtest.kakaoMobility;

public class Q3_2 {
    static int[] A = {1,2,3,2};
    public static void main(String[] args) {
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int answer = 0;
        if(check(A)){
            return 0;
        }
        int trees[] = new int[A.length-1];
        for(int i=0; i<A.length; i++){
            int cnt = 0;
            for(int j=0; j<A.length; j++){
                if(j==i) continue;
                trees[cnt++] = A[j];
            }
            if(check(trees)){
                answer++;
            }
        }

        if(answer == 0){
            return -1;
        }
        return answer;
    }

    private static boolean check(int[] trees) {
        for(int i=0; i<trees.length-1; i++){
            if(trees[i] == trees[i+1]){
                return false;
            }
        }
        boolean isHigh = false;
        if(trees[0] < trees[1]){
            isHigh = true;
        }else{
            isHigh = false;
        }

        for(int i=1; i<trees.length-1; i++){
            if(isHigh){
                if (trees[i] <= trees[i+1]){
                    return false;
                }else{
                    isHigh = false;
                }
            }else{
                if(trees[i] >= trees[i+1]){
                    return false;
                }else{
                    isHigh = true;
                }
            }
        }
       return true;
    }
}
