package com.programmers;

import java.util.Arrays;

public class L2_조이스틱 {
    public static int solution(String name) {
        int answer = 0;

        int[] cnt = new int [name.length()];

        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            cnt[i] = Math.min(c-'A', Math.abs(26-(c-'A')));
        }

        System.out.println(Arrays.toString(cnt));

        int nums = 0;
        for(int i=0; i< cnt.length; i++){
            if(cnt[i] != 0){
                nums++;
            }
            min += cnt[i];
        }
        min += cnt.length-1;

        boolean[] isVisited = new boolean[cnt.length];
        solve(0, nums, cnt, 0, 1, isVisited);

        answer = min;
        return answer;
    }

    static int min = Integer.MAX_VALUE;

    private static void solve(int cur, int nums, int[] cnt, int sum, int d, boolean[] isVisited) {
        if(nums == 0){
            if(sum < min){
                min = sum;
                System.out.println("min: "+min);
            }
            return;
        }

        // d 방향으로 방문되자 않은 새기를 찾아야함.
        while(true){
            if(d == 1){
                cur = (cur+d) % cnt.length;
            }else{
                if(cur == 0){
                    cur = cnt.length-1;
                }else{
                    cur += d;
                }
            }
        }

        // 방문되지 않았으면 방문처리 후 상하 카운트
        if(!isVisited[cur]){
            isVisited[cur] = true;
            if(cnt[cur] != 0){
                nums--;
                sum += cnt[cur];
            }
            if(d == 1){
                cur = (cur+d) % cnt.length;
            }else{
                if(cur == 0){
                    cur = cnt.length-1;
                }else{
                    cur += d;
                }
            }

            solve(cur, nums, cnt, sum+1, d, isVisited);
            solve(cur, nums, cnt, sum+1, d * -1, isVisited);
        }else{
        }

    }

    public static void main(String[] args) {
        String name = "JEROEN";
//        String name = "ABCDEFVWXYZ";
        String name2 = "JAN";

        System.out.println(solution(name));
        System.out.println(solution(name2));
    }
}
