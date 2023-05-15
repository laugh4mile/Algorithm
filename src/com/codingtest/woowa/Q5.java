package com.codingtest.woowa;

import java.util.Arrays;
import java.util.List;

public class Q5 {
    public static void main(String[] args) {
        String penter = "1100";
        String pexit = "0010";
        String pescape = "1001";
        String data = "1101100100101111001111000000";

        System.out.println(solution(penter, pexit, pescape, data));
    }

    public static String solution(String penter, String pexit, String pescape, String data) {
        StringBuilder sb = new StringBuilder();
        sb.append(penter);
        int escapeCharSize = penter.length();
        int length = data.length() / escapeCharSize;

        List<String> escapeStrings = Arrays.asList(penter, pexit, pescape);

        for (int i = 0; i < length; i++) {
            int index = i * escapeCharSize;
            String value = data.substring(index, index + escapeCharSize);

            if (escapeStrings.contains(value)) {
                sb.append(pescape).append(value);
                continue;
            }
            sb.append(value);
        }
        sb.append(pexit);
        return sb.toString();
    }
}
