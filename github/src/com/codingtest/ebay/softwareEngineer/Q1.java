package com.codingtest.ebay.softwareEngineer;

public class Q1 {
    static String[][] map = {
            {"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"},
            {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"},
            {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"},
            {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"},
            {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}};
    public static void main(String[] args) {
        System.out.println("answer : " + solution(map));
    }
    static int result[], answer;
    public static int solution(String[][] schedule) {
        map = schedule.clone();
        result = new int[5];
        permutation(0);
        return answer;
    }
    private static int dayToMM(String day){
        int mm = 0;
        switch (day){
            case "MO" :
                mm = 0;
                break;
            case "TU" :
                mm = 1440;
                break;
            case "WE" :
                mm = 2880;
                break;
            case "TH" :
                mm = 4320;
                break;
            case "FR" :
                mm = 5760;
                break;
        }
        return mm;
    }

    private static void getAnswer(int[] result) {
        boolean isSelected[] = new boolean[7200]; // 하루 : 1440분 * 5일 = 7200
        for(int i=0; i<5; i++){
            String time = map[i][result[i]];
            if(time.length() > 8){
                int day1 = dayToMM(time.substring(0,2));
                day1 += Integer.parseInt(time.substring(3,5)) * 60;
                day1 += Integer.parseInt(time.substring(6,8));
                int day2 = dayToMM(time.substring(9,11));
                day2 += Integer.parseInt(time.substring(12,14)) * 60;
                day2 += Integer.parseInt(time.substring(15,17));
                for(int j=day1; j<day1+90; j++){
                    if(isSelected[j]){
                        return;
                    }
                    isSelected[j] = true;
                }
                for(int j=day2; j<day2+90; j++){
                    if(isSelected[j]){
                        return;
                    }
                    isSelected[j] = true;
                }
            }else{
                int day1 = dayToMM(time.substring(0,2));
                day1 += Integer.parseInt(time.substring(3,5)) * 60;
                day1 += Integer.parseInt(time.substring(6,8));
                for(int j=day1; j<day1+180; j++){
                    if(isSelected[j]){
                        return;
                    }
                    isSelected[j] = true;
                }
            }
        }
        answer++;
    }

    private static void permutation(int cnt) {
        if(cnt == 5){
            getAnswer(result);
            return;
        }
        for(int i=0; i<4; i++){
            result[cnt] = i;
            permutation(cnt+1);
        }
    }
}