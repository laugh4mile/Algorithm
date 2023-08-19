package com.programmers;

import java.util.Arrays;
import java.util.Comparator;

class L3_단속카메라 {
    public static int solution(int[][] routes) {
        int answer = 0;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i=0; i<routes.length; i++){
            if(routes[i][0] > routes[i][1]){ // 반대 방향인경우 뒤집기
                int temp = routes[i][0];
                routes[i][0] = routes[i][1];
                routes[i][1] = temp;
            }
        }
        Arrays.sort(routes, new Comparator<int[]>() { // start 포인트 기준으로 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });

        for(int i=0; i<routes.length; i++){
            if(end < routes[i][0]){ // 이전 end 지점보다 현재 시작지점이 더 크면 카메라 추가후 start, end 초기화
                answer++;
                start = routes[i][0];
                end = routes[i][1];
            }else{
                start = routes[i][0];
                end = Integer.min(end, routes[i][1]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }
}