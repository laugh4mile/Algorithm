package com.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L3_셔틀버스 {
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<timetable.length; i++){
            int hh = Integer.parseInt(timetable[i].substring(0,2));
            int mm = Integer.parseInt(timetable[i].substring(3,5));
            list.add(hh*60+mm);
        }
        Collections.sort(list);

        if(540+n*t < list.get(0)){
            return formatTime(540+n*t);
        }

        int idx = 0;
        int remain = 0;

        for(int i=0; i<n; i++){
            int bus = 540 + i*t;
            remain = m;
            for(int j = idx; j<list.size(); j++){
                if(list.get(j) <= bus && remain > 0){
                    remain--;
                    idx = j+1;
                }else{
                    idx = j;
                    break;
                }
            }
        }
        int lastPassanger = list.get(idx-1);
        if(remain > 0){
            answer = formatTime(540+(n-1)*t);
        }else{
            answer = formatTime(lastPassanger-1);
        }
        return answer;
    }

    private static String formatTime(int answerMM) {
        String answer = "";
        int hh = answerMM / 60;
        int mm = answerMM % 60;
        if(hh < 10){
            answer += "0"+hh;
        }else{
            answer += hh;
        }
        if(mm < 10){
            answer += ":0"+mm;
        }else{
            answer += ":"+mm;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 2;
        int t = 10;
        int m = 2;
        String[] timetable = {"09:10", "09:09", "08:00"};
//        System.out.println(solution(n,t,m,timetable));
        String[] timetable2 = {"08:00", "08:01", "08:02", "08:03"};
        System.out.println(solution(4,1,5,timetable2));

    }
}
