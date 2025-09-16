package com.programmers;

import java.util.*;

public class L2_과제진행하기 {
    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        ArrayList<Task> list = new ArrayList<>();
        for(int i=0; i<plans.length; i++){
            int hh = Integer.parseInt(plans[i][1].substring(0,2));
            int mm = Integer.parseInt(plans[i][1].substring(3,5));
            list.add(new Task(plans[i][0], hh*60+mm, Integer.parseInt(plans[i][2])));
        }

        Collections.sort(list);

        System.out.println(list);

        int idx = 0;
        Stack<Task> stack = new Stack<>();
        for(int i=0; i<list.size(); i++){
            if(stack.isEmpty()){
                stack.push(list.get(i));
            }else{
                int extraTime = list.get(i).start - stack.peek().start;

                while(!stack.isEmpty() && extraTime > 0){
                    extraTime -= stack.peek().playtime;

                    if(extraTime >= 0){
                        answer[idx++] = stack.pop().name;
                    }else{
                        Task top = stack.pop();
                        stack.push(new Task(top.name, list.get(i).start, extraTime * -1));
                    }
                }
                stack.push(list.get(i));
            }
        }
//        System.out.println(stack);

        while(!stack.isEmpty()){
            answer[idx++] = stack.pop().name;
        }
        return answer;
    }

    static class Task implements Comparable<Task>{
        String name;
        int start;
        int playtime;

        public Task(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }

        @Override
        public int compareTo(Task o){
            return Integer.compare(this.start, o.start);
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", start=" + start +
                    ", playtime=" + playtime +
                    '}';
        }
    }

    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        System.out.println(Arrays.toString(solution(plans)));
        System.out.println();
        String[][] plans2 = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(Arrays.toString(solution(plans2)));
    }
}
