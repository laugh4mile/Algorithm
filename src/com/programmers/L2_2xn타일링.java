package com.programmers;

class L2_2xn타일링 {
    public static int solution(int n) {
        int arr[] = new int[60001];
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3; i<=n; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println((solution(4)));
    }
}