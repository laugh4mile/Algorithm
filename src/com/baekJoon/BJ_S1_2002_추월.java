package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_S1_2002_추월 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        for(int i=1; i<N+1; i++){
            map.put(input.readLine(), i);
        }
        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = map.get(input.readLine());
        }
        int answer = 0;
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static int getLowerBound(List<Integer> lis, int target) {
        int left = 0;
        int right = lis.size()-1;
        int mid = 0;

        while(left < right){
            mid = (left+right)/2;
            if(target <= lis.get(mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    static String src =
            "4\n" +
                    "ZG431SN\n" +
                    "ZG5080K\n" +
                    "ST123D\n" +
                    "ZG206A\n" +
                    "ZG206A\n" +
                    "ZG431SN\n" +
                    "ZG5080K\n" +
                    "ST123D";
}
