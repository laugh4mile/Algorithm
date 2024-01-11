package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_2590_색종이 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int answer = 0;
        int N = 6;
        int paper[] = new int[7];
        for(int i=1; i<7; i++){
            paper[i] = Integer.parseInt(input.readLine());
        }
        answer += paper[6];
        if(paper[5] > 0){
            answer += paper[5];
            paper[1] -= paper[5] * 11;
        }
        if(paper[4] > 0){
            answer += paper[4];
            if (paper[2] > 0){
                if(paper[2] < paper[4] * 5){
                    paper[1] -= (paper[4] * 5 - paper[2]) * 4;
                }
                paper[2] -= paper[4] * 5;
            }else{
                if(paper[1] > 0){
                    paper[1] -= paper[4] * 5 * 4;
                }
            }
        }
        if(paper[3] > 0){
            answer += (int) Math.ceil((double)paper[3]/4);
            if(paper[3] % 4 == 1){ // 27칸 남음. paper[2] 5개 들어감
                if(paper[2] > 0){
                    if(paper[2] < 5){
                        paper[1] -= 27-(5-paper[2])*4;
                    }else{
                        paper[1] -= 27 - 5 * 4;
                    }
                    paper[2] -= 5;
                }else{
                    if(paper[1] > 0){
                        paper[1] -= 27;
                    }
                }
            }else if(paper[3] % 4 == 2){ // 18칸 남음. paper[2] 3개 들어감
                if(paper[2] > 0){
                    if(paper[2] < 3){
                        paper[1] -= 18-(3-paper[2])*4;
                    }else{
                        paper[1] -= 18 - 3 * 4;
                    }
                    paper[2] -= 3;
                }else{
                    if(paper[1] > 0){
                        paper[1] -= 18;
                    }
                }
            }else if(paper[3] % 4 == 3){ // 9칸 남음. paper[2] 1개 들어감
                if(paper[2] > 0){
                    paper[1] -= 9 - 4;
                    paper[2] -= 1;
                }else{
                    if(paper[1] > 0){
                        paper[1] -= 9;
                    }
                }
            }
        }
        if(paper[2] > 0){
            answer += (int) Math.ceil((double)paper[2]/9);
            if(paper[2] % 9 != 0){
                paper[1] -= 36 - (paper[2] % 9)*4;
            }
        }
        if(paper[1] > 0){
            answer += (int) Math.ceil((double)paper[1]/36);
        }

        System.out.println(answer);
    }

    static String src =
        "1\n" +
                "1\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "1";
}
