package com.codingtest.devmatching2;

import java.util.Arrays;

public class Q2 {
	static int leave = 16;
	static String day = "MON";
	static int[] holidays = {1, 2, 3, 4, 28, 29, 30};
	public static void main(String[] args) {
		int answer = solution(leave, day, holidays);
		System.out.println(answer);
	}
	static int month[][] = new int[6][7]; // 달력임.
	static boolean isHoliday[] = new boolean[31]; 
	static int arr[],R, result[], maxHolidays;
	public static int solution(int leave, String day, int[] holidays) {
        int answer = -1;
        R = leave;
        getMonth(day);
        getHolidays();
        for(int i=0; i<holidays.length; i++) {
        	isHoliday[holidays[i]] = true;
        }
        int cnt = 0;
        for(int i=1; i<=30; i++) {
        	if(!isHoliday[i]) cnt++;
        }
        if(cnt <= leave) {
        	return 30;
        }
        arr = new int[cnt];
        result = new int[R];
        cnt = 0;
        for(int i=1; i<=30; i++) {
        	if(!isHoliday[i]) arr[cnt++] = i;
        }
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
        combi(0,0);
        answer = maxHolidays;
        return answer;
    }
	
	private static void combi(int start, int cnt) {
		if(cnt == R) {
			getMaxHuga(result);
			return;
		}
		for(int i=start; i<arr.length; i++) {
			result[cnt] = arr[i];
			combi(i+1, cnt+1);
		}
	}

	private static void getMaxHuga(int[] result) {
		for(int i=0; i<result.length; i++) {
			isHoliday[result[i]] = true;
		}
		
		int max = 0;
		for(int i=1; i<=30; i++) {
			if(isHoliday[i]) {
				max++;
				maxHolidays = Math.max(maxHolidays, max);
			}else {
				max = 0;
			}
		}
		for(int i=0; i<result.length; i++) {
			isHoliday[result[i]] = false;
		}
	}

	private static void getHolidays() {
		for(int r=0; r<6; r++) {
			if(month[r][0]>0 && month[r][0] < 31) {
				isHoliday[month[r][0]] = true;
			}
			if(month[r][6]>0 && month[r][6] < 31) {
				isHoliday[month[r][6]] = true;
			}
		}
	}

	private static void getMonth(String day) {
		switch (day) {
		case "SUN":
			month[0][0] = 1;
			matching();
			break;
		case "MON":
			month[0][1] = 1;
			matching();
			break;
		case "TUE":
			month[0][2] = 1;
			matching();
			break;
		case "WED":
			month[0][3] = 1;
			matching();
			break;
		case "THU":
			month[0][4] = 1;
			matching();
			break;
		case "FRI":
			month[0][5] = 1;
			matching();
			break;
		case "SAT":
			month[0][6] = 1;
			matching();
			break;
		}
	}

	private static void matching() {
		boolean flag = false;
		int day = 1;
		for(int r=0; r<month.length; r++) {
			for(int c=0; c<month[0].length; c++) {
				if (flag) month[r][c] = ++day; 
				if(month[r][c] == 1) {
					flag = true;
				}
			}	
		}
	}
}
