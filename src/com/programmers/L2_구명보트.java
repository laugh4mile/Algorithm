package com.programmers;

import java.util.Arrays;

class L2_구명보트 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int n = people.length;
        int j = 0;
        for(int i=n-1; i>=j; i--){
            if(people[i] + people[j] <= limit){
                j++;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
//        int[] arr = {70, 50, 80, 50};
        int[] arr = {70, 80, 50};
        System.out.println(solution(arr, 100));
    }
}