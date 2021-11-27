package com.codingtest.line.fintech;

public class Q2 {
    static int[] arr1 = {0, 1, 2, 5, 3, 7};
    static int[] arr2 = {1, 2, 3, 2, 1};
    static int[] arr3 = {1, 2, 3, 2, 1, 4, 3, 2, 2, 1};
    static int[] arr4 = {1, 2, 1, 2, 1};
    public static void main(String[] args) {
        System.out.println(solution(arr4));
    }

    public static int solution(int[] arr) {
        int answer = 0;

        int mod = 1_000_000_007;
        int left = 0;
        int mid = 0;
        int right = 0;
        int direction = 1; // 0:↗, 1:→, 2:↘

        for(int i=1; i<arr.length; i++){
            if(direction == 0){ // 우 상향중
                if(arr[i-1]<arr[i]){
                    mid = i;
                    direction = 0;
                }else if(arr[i-1] == arr[i]){
                    left = i;
                    mid = i;
                    right = i;
                    direction = 1;
                }else{
                    right = i;
                    direction = 2;
                }
            }else if(direction == 1){ // ㅡ
                if(arr[i-1]<arr[i]){
                    mid = i;
                    direction = 0;
                }else if(arr[i-1] == arr[i]){
                    left = i;
                    mid = i;
                    right = i;
                    direction = 1;
                }else{
                    right = i;
                    direction = 2;
                }
            }else{ // 우 하향
                if(arr[i-1]<arr[i]){
                    if(arr[left] < arr[mid] && arr[mid] > arr[right]){ // A자 모양이 완성될 경우.
                        answer += ((mid-left) * (right - mid)) % mod;
                    }
                    left = i-1;
                    mid = i;
                    right = i;
                    direction = 0;
                }else if(arr[i-1] == arr[i]){
                    if(arr[left] < arr[mid] && arr[mid] > arr[right]){ // A자 모양이 완성될 경우.
                        answer += ((mid-left) * (right - mid)) % mod;
                    }
                    left = i;
                    mid = i;
                    right = i;
                    direction = 1;
                }else{
                    right = i;
                    direction = 2;
                }
            }
        }
        // 마지막 인덱스 부분에서 A자가 완성이 될 경우를 계산해줘야 함.
        if(arr[left] < arr[mid] && arr[mid] > arr[right]){
            answer += ((mid-left) * (right - mid)) % mod;
        }
        return answer;
    }

}
