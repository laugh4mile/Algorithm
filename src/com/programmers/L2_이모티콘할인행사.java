package com.programmers;

import java.util.*;

public class L2_이모티콘할인행사 {
    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        int[] result = new int[emoticons.length];
        combi(0, 0, emoticons.length, emoticons, users, result);

        answer[0] = max1;
        answer[1] = max2;

        return answer;
    }


    private static void combi(int start, int cnt, int N, int[] emoticons, int[][] users, int[] result) {

        if(cnt == N){
            solve(users, result, emoticons);
            return;
        }

        for(int i=start; i<N; i++){
            for(int j=10; j<=40; j+=10){
                result[cnt] = j;
                combi(i+1, cnt+1, N, emoticons, users, result);
            }
        }

    }

    private static void solve(int[][] users, int[] result, int[] emoticons) {
        int member = 0;
        int sales  = 0;
        outer: for(int i=0; i<users.length; i++){
            int money = users[i][1];
            int sum = 0;
            for(int j=0; j<result.length; j++){
                if(users[i][0] > result[j]) continue;

                int dc = (emoticons[j] * result[j]) / 100;
                money -= emoticons[j] - dc;
                sum   += emoticons[j] - dc;

                if(money <= 0){
                    member++;
                    continue outer;
                }
            }

            sales += sum;
        }
        System.out.println(Arrays.toString(result));
        System.out.println("가입자수: "+member+",  매출액: "+sales);
        if(member >= max1){
            if(member > max1){
                max2 = 0;
            }
            max1 = member;
            if(sales > max2){
                max2 = sales;
            }
        }
    }

    static int max1, max2 = 0;

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        int[][] users2 = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons2 = {1300, 1500, 1600, 4900};

//        System.out.println(Arrays.toString(solution(users, emoticons)));
        System.out.println(Arrays.toString(solution(users2, emoticons2)));
    }
}
