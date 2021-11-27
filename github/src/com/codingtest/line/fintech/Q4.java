package com.codingtest.line.fintech;

import java.util.*;

public class Q4 {
    static int[][] rectangles = {{0,2,1,3},{1,2,2,5},{3,3,4,4},{4,1,6,3},{1,6,5,7},{5,5,7,6},{5,8,6,10}};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(rectangles)));
    }

    public static String[] solution(int[][] rectangles) {
        List<Rectangle> list = new ArrayList<>();
        for(int i=0; i<rectangles.length; i++){
            list.add(new Rectangle(rectangles[i][0],rectangles[i][1],rectangles[i][2],rectangles[i][3],i));
        }

        Collections.sort(list, new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                if(o1.y1 == o2.y1){
                    return Integer.compare(o1.x1, o2.x1);
                }
                return Integer.compare(o1.y1, o2.y1);
            }
        });

        int x_Axis[] = new int[1000001];
        int y_Axis[] = new int[1000001];

        for(int i=0; i<list.size(); i++){
            Rectangle front = list.get(i);
            int max = 0;
            for(int x=front.x1; x<front.x2; x++){
                if(max < x_Axis[x]){
                    max = x_Axis[x];
                }
            }
            front.y2 = max + front.y2-front.y1;
            front.y1 = max;
            for(int x=front.x1; x<front.x2; x++){
                x_Axis[x] = front.y2;
            }
        }
        Collections.sort(list, new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                return Integer.compare(o1.x1, o2.x2);
            }
        });

        for(int i=0; i<list.size(); i++){
            Rectangle front = list.get(i);
            int max = 0;
            for(int y=front.y1; y<front.y2; y++){
                if(max < y_Axis[y]){
                    max = y_Axis[y];
                }
            }
            front.x2 = max + front.x2-front.x1;
            front.x1 = max;
            for(int y=front.y1; y<front.y2; y++){
                y_Axis[y] = front.x2;
            }
        }
        Collections.sort(list, new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });


        String[] answer = new String[list.size()];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i).x1+" "+list.get(i).y1+" "+list.get(i).x2+" "+list.get(i).y2);
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
    static class Rectangle{
        int x1;
        int y1;
        int x2;
        int y2;
        int num;

        public Rectangle(int x1, int y1, int x2, int y2, int num) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "x1=" + x1 +
                    ", y1=" + y1 +
                    ", x2=" + x2 +
                    ", y2=" + y2 +
                    ", num=" + num +
                    '}';
        }
    }
}
