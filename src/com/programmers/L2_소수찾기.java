package com.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class L2_소수찾기 {
    static char arr[];
    static boolean isSelected[];
    static boolean isPrime[];
    static int answer;
    static Set<Integer> set = new HashSet<>();
    public static int solution(String numbers) {
        isPrime = new boolean[10000000];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i<isPrime.length; i++){
            if(!isPrime[i]) continue;
            for(int j=i+i; j<isPrime.length; j=j+i){
                isPrime[j] = false;
            }
        }
        arr = numbers.toCharArray();
        isSelected = new boolean[numbers.length()];

        dfs("",0);

        return answer;
    }

    private static void dfs(String str, int cnt) {
        if(!str.equals("") && isPrime[Integer.parseInt(str)] && !set.contains(Integer.parseInt(str))) {
            set.add(Integer.parseInt(str));
            answer++;
        }

        for(int i=0; i<arr.length; i++){
            if (isSelected[i]){
                continue;
            }else{
                isSelected[i] = true;
                dfs(str.concat(Character.toString(arr[i])),cnt+1);
                isSelected[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(solution(numbers));
    }
}