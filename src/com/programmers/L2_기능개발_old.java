package com.programmers;

public class L2_기능개발_old {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] days = getDays(progresses, speeds);
        answer = distFunc(days);
        return answer;
    }

    public static int[] getDays (int[] progresses, int[] speeds) { // 각 기능별 배포하기 위한 작업 시간을 담을 배열
        int n = progresses.length;
        double[] temp = new double[n];
        int[] result = new int[n];
        for(int i = 0 ; i < n ; i++) {
            temp[i] = (100-progresses[i]) / (double) speeds[i];
            if((int)temp[i] < temp[i])
                temp[i]++;
            result[i] = (int)temp[i];
        }
        return result;
    }

    public static int[] distFunc(int[] days) {
        int n = days.length;
        int start = days[0];
        int count = 1;
        for(int i = 0 ; i < n-1 ; i++) {
            for(int j = i + 1 ; j < n ; j++) {
                if(start < days[j]) {
                    start = days[j];
                    count++;
                    i = j;
                }
            }
        }
        int[] result = new int[count];

        int max = days[0];
        int start2 = 0;
        int count2 = 0;
        for(int i = 0 ; i < result.length-1 ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(max < days[j]) {
                    max = days[j];
                    result[count2++] = j - start2;
                    start2 = j;
                }
            }
        }
        result[count2] = days.length - start2;
        return result;
    }
}
