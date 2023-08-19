package com.base;

import java.util.Arrays;

public class KMP {
    static String target = "banana";
    static String pattern = "ana";

    public static void main(String[] args) {
        kmp();
    }

    static void kmp() {
        int patternLen = pattern.length();
        int targetLen = target.length();
        int[] pi = getPi();

        // begin: 검색 시작 위치, matched: 일치한 문자열의 길이
        int begin = 0, matched = 0;
        // 범위 내에 있을때까지...
        while (begin + patternLen <= targetLen) {
            // 현재 위치에서의 비교가 일치할 때
            // --> 아직 pattern과 완전히 일치하지는 않았고 현재 위치에서의 문자가 같다면..
            if (matched < patternLen && pattern.charAt(matched) == target.charAt(matched + begin)) {
                matched++;
                // 이렇게 증가시켰더니... matched가 patternLen과 같다면??
                if (matched == patternLen) {
                    System.out.println("발견: 시작 위치: " + begin);
                }
            }
            // 현재 위치에서의 비교가 실패할 때
            else {
                // 처음부터 하나도 안맞았다면..
                if (matched == 0) {
                    begin++;
                }
                // 몇 개는 맞는게 있다며...
                else {
                    // 비교를 시작할 위치를 pi 배열을 기준으로 구한다.
                    begin = begin + matched - pi[matched - 1];// begin++이 아니라.. 건너뜀.
                    // 실제 비교해볼 위치도 변경한다.
                    matched = pi[matched - 1];
                }
            }
        }
    }

    static int[] getPi() {
        int patternLen = pattern.length();
        int[] pi = new int[patternLen];
        // begin: 검색 시작 위치, matched: 일치한 문자열의 길이
        // 동일한 패턴을 이용해서 비교할꺼니까 begin이 0부터 시작하는건 의미 없다.
        int begin = 1, matched = 0;
        // 범위 내에 있을때까지...그런데 접두/접미부는 전체 문자열을 대상으로 하지 않는다.
        while (begin + matched <= patternLen - 1) {
            // 현재 비교하는게 같다면..
            if (pattern.charAt(matched) == pattern.charAt(begin + matched)) {
                matched++;
                // 증가된 값이 pi 배열의 값이다.~~~ pi는 0부터 시작
                pi[begin + matched - 1] = matched;
            }
            // 다르다면..
            else {
                // 처음부터 하나도 안맞았다면..
                if (matched == 0) {
                    begin++;
                }
                // 몇 개는 맞는게 있다며...건너뛰기 신공
                else {
                    // 현재 matched글자가 일치했다는 정보는 이미 pi[matched-1]에 저장한 상태
                    begin = begin + matched - pi[matched - 1];
                    // 실제 비교해볼 위치도 변경한다.
                    matched = pi[matched - 1];
                }
            }
        }
//        System.out.println(Arrays.toString(pi));
        return pi;
    }
}
