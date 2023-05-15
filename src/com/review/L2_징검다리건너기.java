package com.review;

class L2_징검다리건너기 {
    public static int solution(int[] stones, int k) {
        int answer = 0;

        int min = 1;
        int max = 2000000;
        int mid = 0;

        while(min < max){
            mid = (min + max)/2;
            if(cross(stones, k, mid)){
                min = mid + 1;
                answer = mid;
            }else{
                max = mid - 1;
            }
        }
        return answer;
    }

    private static boolean cross(int[] stones, int k, int mid) {
        int cnt = 0;
        for(int i=0; i<stones.length; i++){
            if(stones[i]-mid < 0){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones,k));
    }
}