package com.codingtest.line.fintechIntern;

public class Q5 {
    static String[] strs = {"AABAAA", "BABABB", "BABBAAAB", "BABAAABAABBABBA"};
    static String[] strs2 = {"AA", "BAB", "BAAAA", "ABBABB", "AABBBBABBAAAA"};
    static String[] strs3 = {"AABAABAAB", "AABBBAABBB", "AABBBABBABABBBAAABBBABBBA"};
    public static void main(String[] args) {
        System.out.println(solution(strs));
    }
    // (AAB~|BAB~A)~
    public static int solution(String[] strs) {
        int answer = 0;

        String pattern = "(((AAB+)+)|((BAB+A)+))+";
        for(int i=0; i<strs.length; i++){
            if(strs[i].matches(pattern))
                answer++;
        }
        return answer;
    }
}
