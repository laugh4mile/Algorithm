package com.codingtest.woowa.test2021;

public class Q6 {
	public static void main(String[] args) {
        System.out.println(solution(3.5, new String[][]{{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}}));
    }

    private static String solution(double time, String[][] plans) {
        for (String[] plan : plans) {
            int needTime = 0;
            int start = get24Hours(plan[1]);
            int end = get24Hours(plan[2]);

            String country = plan[0];

            if (start < 18) {
                needTime += (18 - start);
            }

            if (end > 13) {
                needTime += (end - 13);
            }

            if (needTime <= time) {
                return country;
            }
        }
        return null;
    }

    private static int get24Hours(String time) {
        int result = 0;

        if (time.contains("PM")) {
            result += 12;
        }

        if (time.length() > 3) {
            result += Integer.parseInt(time.substring(0, 2));
        } else {
            result += Integer.parseInt(time.substring(0, 1));
        }

        return result;
    }

}
