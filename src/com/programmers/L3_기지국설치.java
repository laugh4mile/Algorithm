package com.programmers;

class L3_기지국설치 {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int area = 2*w+1;
        int term = 0;
        for(int i=0; i<stations.length; i++){
            if(stations[i] - w <= start){
                start = stations[i]+w+1;
            }else{
                term = stations[i] - w - start;
                double temp = term/area;
                int temp2 = term/area;
                if(temp > temp2){
                    answer+=temp2+1;
                }else{
                    answer+=temp2;
                }
                start = stations[i]+w+1;
            }
        }
        term = n-start+1;
        answer += Math.ceil((double) term / area);

        return answer;
    }

    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4,11};
        int w = 1;
        System.out.println(solution(n,stations,w));
    }
}