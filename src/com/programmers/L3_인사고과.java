package com.programmers;

import java.util.*;

public class L3_인사고과 {
    public static int solution(int[][] scores) {
        int size = scores.length; // 사원 수
        if(size == 1){
            return 1;
        }

        int answer = -1;

        ArrayList<Employee> list = new ArrayList<>();

        int wanho0 = scores[0][0];
        int wanho1 = scores[0][1];

        for(int i=0; i<size; i++){
            if(scores[i][0] > wanho0 && scores[i][1] > wanho1){
                return -1;
            }

            if(scores[i][0] + scores[i][1] > wanho0 + wanho1){
                list.add(new Employee(scores[i][0], scores[i][1]));
            }
        }

        if(list.isEmpty()){
            return 1;
        }

        Collections.sort(list);

//        System.out.println(list);

        for(int i=1; i<list.size(); i++){
            if(list.get(i).attitudeScore < list.get(i-1).attitudeScore && list.get(i).coworkerScore < list.get(i-1).coworkerScore){
                list.remove(i--);
            }
        }

        answer = list.size()+1;

        return answer;
    }

    public static void main(String[] args) {
        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        int[][] scores2 = {{4, 6},{6, 4},{1, 8},{5, 7}};
        int[][] scores3 = {{4,3}, {5,2}, {5,1}, {4,5}, {4,4}};

        int answer = solution(scores2);
        System.out.println(answer);
        System.out.println();
        System.out.println();
        System.out.println(solution(scores3));
    }

    private static class Employee implements Comparable<Employee>{
        int attitudeScore;
        int coworkerScore;

        public Employee (int attitudeScore, int coworkerScore){
            this.attitudeScore = attitudeScore;
            this.coworkerScore = coworkerScore;
        }

        @Override
        public int compareTo(Employee o){
            if(this.attitudeScore == o.attitudeScore){
                return Integer.compare(this.coworkerScore, o.coworkerScore);
            }
            return Integer.compare(o.attitudeScore, this.attitudeScore);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "attitudeScore=" + attitudeScore +
                    ", coworkerScore=" + coworkerScore +
                    "}\n";
        }
    }
}
