package com.programmers;

class L2_예상대진표
{
    public static int solution(int n, int a, int b)
    {
        int answer = 0;

        double aa = a;
        double bb = b;
        while (aa != bb){
            aa = Math.ceil(aa/2);
            bb = Math.ceil(bb/2);
            answer++;
            System.out.println(aa + " " + bb);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8,4,8));
    }
}