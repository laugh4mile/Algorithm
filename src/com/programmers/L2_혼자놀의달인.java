package com.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L2_혼자놀의달인 {
    public static int solution(int[] cards) {
        int answer = 0;
        int N = cards.length;

        boolean isVisited[] = new boolean[N];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            if (isVisited[i]) continue;

            int cur = i;
            int cnt = 0;

            while(!isVisited[cur]){
                isVisited[cur] = true;
                cur = cards[cur]-1;
                cnt++;
            }

            if(cnt == N) return 0;
            list.add(cnt);
        }
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0) * list.get(1);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8,6,3,7,2,5,1,4}));
    }
}
