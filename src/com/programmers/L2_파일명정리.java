package com.programmers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class L2_파일명정리 {
    public static String[] solution(String[] files) {
        String[] answer = {};
        List<File> list = new ArrayList<>();
        int startIdx, endIdx;
        String head, number, tail;
        for(int i=0; i<files.length; i++){
            boolean flag = false;
            startIdx = 0;
            endIdx = 0;
            for(int j=0; j<files[i].length(); j++){
                if(Character.isDigit(files[i].charAt(j)) && !flag){
                    startIdx = j;
                    flag = true;
                }

                if(flag && !Character.isDigit(files[i].charAt(j))){
                    endIdx = j;
                    break;
                }
            }
//            System.out.println(startIdx +" "+endIdx);
            head = files[i].substring(0,startIdx);
            if(endIdx==0){
                number = files[i].substring(startIdx);
                tail = "";
            }else{
                number = files[i].substring(startIdx,endIdx);
                tail = files[i].substring(endIdx);
            }
            list.add(new File(head, number, tail, i));
//            System.out.println(head +" "+number+" "+tail);
        }
        Collections.sort(list);
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).head+list.get(i).number+list.get(i).tail;
        }

        return answer;
    }
    static class File implements Comparable<File>{
        String head;
        String number;
        String tail;

        int cnt;

        public File(String head, String number, String tail, int cnt) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(File o) {
            if(this.head.toLowerCase().equals(o.head.toLowerCase())){
                if(Integer.parseInt(this.number) == Integer.parseInt(o.number)){
                    return Integer.compare(this.cnt, o.cnt);
                }
                return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(o.number));
            }
            return this.head.toLowerCase().compareTo(o.head.toLowerCase());
        }

    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
//        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        System.out.println(Arrays.toString(solution(files)));
    }
}