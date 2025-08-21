package com.programmers;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class L1_붕대감기 {

    public static void main(String[] args) throws Exception{

        String input = "bandage\thealth\tattacks\tresult\n" +
                "[5, 1, 5]\t30\t[[2, 10], [9, 15], [10, 5], [11, 5]]\t5\n" +
                "[3, 2, 7]\t20\t[[1, 15], [5, 16], [8, 6]]\t-1\n" +
                "[4, 2, 7]\t20\t[[1, 15], [5, 16], [8, 6]]\t-1\n" +
                "[1, 1, 1]\t5\t[[1, 2], [3, 2]]\t3";
        parseAndCallSolution(L1_붕대감기.class, input);
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        System.out.println("bandage: " + Arrays.toString(bandage));
        System.out.println("health: " + health);
        System.out.println("attacks: " + Arrays.deepToString(attacks));
        return answer;
    }

    // 문자열을 파싱하여 데이터를 추출하고 solution 메서드를 동적으로 호출하는 함수
    public static void parseAndCallSolution(Class<?> clazz, String input) throws Exception {
        System.out.println("call parseAndCallSolution");
        // 전달된 클래스의 메서드 정보를 리플렉션으로 가져옴
        Method[] methods = clazz.getMethods();

        // 입력 파싱 (첫 번째 줄은 헤더, 이후는 데이터)
        String[] lines = input.split("\n");
        String[] headers = lines[0].split("\t");
        String[] data = lines[1].split("\t");
        System.out.println(Arrays.toString(data));

        // solution 메서드 중 하나를 찾아서 호출하기
        for (Method method : methods) {
            if (method.getName().equals("solution")) {
                Parameter[] parameters = method.getParameters();
                // 파라미터 개수와 일치하는 메서드인지 확인 result 를 빼야하므로 -1
                if (parameters.length == data.length-1) {
                    System.out.println("test");
                    Object[] parsedParams = new Object[parameters.length];

                    for (int i = 0; i < parameters.length; i++) {
                        Class<?> paramType = parameters[i].getType();
                        String field = data[i];

                        // 파라미터 타입에 따라 데이터 변환
                        if (paramType == int[].class) {
                            // int[]로 변환
                            parsedParams[i] = parseIntArray(field);
                        } else if (paramType == int.class) {
                            // int로 변환
                            parsedParams[i] = Integer.parseInt(field);
                        } else if (paramType == long.class) {
                            // long으로 변환
                            parsedParams[i] = Long.parseLong(field);
                        } else if (paramType == long[].class) {
                            // long[]로 변환
                            parsedParams[i] = parseLongArray(field);
                        } else if (paramType == long[][].class) {
                            // long[][]로 변환
                            parsedParams[i] = parseLongMatrix(field);
                        } else if (paramType == double.class) {
                            // double로 변환
                            parsedParams[i] = Double.parseDouble(field);
                        } else if (paramType == int[][].class) {
                            // int[][]로 변환
                            parsedParams[i] = parseIntMatrix(field);
                        } else if (paramType == String.class) {
                            // String으로 변환
                            parsedParams[i] = field;
                        } else if (paramType == String[].class) {
                            // String[]로 변환
                            parsedParams[i] = parseStringArray(field);
                        } else if (paramType == String[][].class) {
                            // String[][]로 변환
                            parsedParams[i] = parseStringMatrix(field);
                        } else if (paramType == Object[].class) {
                            // Object[]로 변환 (예시로 간단히 구현)
                            parsedParams[i] = field.split(", ");
                        } else {
                            // 처리할 수 없는 타입일 때 기본적으로 문자열로 처리
                            parsedParams[i] = field;
                        }
                    }

                    // solution 메서드를 호출하고 결과 출력
                    method.invoke(null, parsedParams);
                    break;
                }
            }
        }
    }

    // 배열 파싱을 위한 헬퍼 함수들
    public static int[] parseIntArray(String input) {
        String cleaned = input.replaceAll("[\\[\\]]", ""); // 대괄호 제거
        String[] parts = cleaned.split(", ");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    public static long[] parseLongArray(String input) {
        String cleaned = input.replaceAll("[\\[\\]]", ""); // 대괄호 제거
        String[] parts = cleaned.split(", ");
        long[] arr = new long[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Long.parseLong(parts[i]);
        }
        return arr;
    }

    public static int[][] parseIntMatrix(String input) {
        String cleaned = input.replaceAll("[\\[\\]]", ""); // 대괄호 제거
        String[] pairs = cleaned.split("], ");
        int[][] arr = new int[pairs.length][2];
        for (int j = 0; j < pairs.length; j++) {
            String[] pair = pairs[j].split(", ");
            arr[j][0] = Integer.parseInt(pair[0]);
            arr[j][1] = Integer.parseInt(pair[1]);
        }
        return arr;
    }

    public static long[][] parseLongMatrix(String input) {
        String cleaned = input.replaceAll("[\\[\\]]", ""); // 대괄호 제거
        String[] pairs = cleaned.split("], ");
        long[][] arr = new long[pairs.length][2];
        for (int j = 0; j < pairs.length; j++) {
            String[] pair = pairs[j].split(", ");
            arr[j][0] = Long.parseLong(pair[0]);
            arr[j][1] = Long.parseLong(pair[1]);
        }
        return arr;
    }

    public static String[] parseStringArray(String input) {
        String cleaned = input.replaceAll("[\\[\\]]", ""); // 대괄호 제거
        return cleaned.split(", ");
    }

    public static String[][] parseStringMatrix(String input) {
        String cleaned = input.replaceAll("[\\[\\]]", ""); // 대괄호 제거
        String[] pairs = cleaned.split("], ");
        String[][] arr = new String[pairs.length][];
        for (int j = 0; j < pairs.length; j++) {
            arr[j] = pairs[j].split(", ");
        }
        return arr;
    }
}
