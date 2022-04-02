package com.codingtest.devmatching.test3SiliconValley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2 {
	static String[] names = {"azad","andy","louis","will","edward"};
	static int[][] homes = {{3,4},{-1,5},{-4,4},{3,4},{-5,0}};
	static double[] grades = {4.19, 3.77, 4.41, 3.65, 3.58};
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(names, homes, grades)));
	}
	public static int[] solution(String[] names, int[][] homes, double[] grades) {
        List<Student> list = new ArrayList<>();
        for(int i=0; i<names.length; i++) {
        	String name = names[i];
        	double distance = Math.sqrt(Math.pow(homes[i][0], 2)+Math.pow(homes[i][1], 2));
        	int grade = (int) grades[i];
        	list.add(new Student(name, distance, grade));
        }
        Collections.sort(list);
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<list.size(); i++) {
        	map.put(list.get(i).name, i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = map.get(names[i]);
        }
        return answer;
    }
	
	static class Student implements Comparable<Student>{
		String name;
		double distance;
		int grade;
		
		public Student(String name, double distance, int grade) {
			super();
			this.name = name;
			this.distance = distance;
			this.grade = grade;
		}

		@Override
		public int compareTo(Student o) {
			if(this.grade == o.grade) {
				if(this.distance == o.distance) {
					return this.name.compareTo(o.name);
				}
				return Double.compare(o.distance, this.distance);
			}
			return Integer.compare(o.grade, this.grade);
		}
	}
}
