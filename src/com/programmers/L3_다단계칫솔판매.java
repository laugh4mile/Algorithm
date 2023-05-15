package com.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L3_다단계칫솔판매 {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> parents = new HashMap<>();
        Map<String, Integer> totalAmount = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            parents.put(enroll[i], referral[i]);
            totalAmount.put(enroll[i], 0);
        }
        outer : for(int i=0; i<seller.length; i++){
            int money = amount[i]*100;
            String cur = seller[i];

            while(parents.get(cur) != null){
                if(money < 10){
                    totalAmount.replace(cur, totalAmount.get(cur) + money);
                    break;
                }else{
                    int tenPercent = money/10;
                    totalAmount.replace(cur, totalAmount.get(cur)+money-tenPercent);
                    money = tenPercent;
                    cur = parents.get(cur);
                }
            }
        }
        for(int i=0; i<enroll.length; i++){
            answer[i] = totalAmount.get(enroll[i]);
        }
//        for(int i=0; i<enroll.length; i++){
//            System.out.println(enroll[i]+" "+totalAmount.get(enroll[i]));
//        }
        return answer;
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }
}
