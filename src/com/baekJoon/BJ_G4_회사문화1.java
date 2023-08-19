package com.baekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_G4_회사문화1 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());

        tokens = new StringTokenizer(input.readLine());
        int score[] = new int [n+1];
        int parents[] = new int [n+1];

        for(int i=1; i<n+1; i++){
            parents[i] = Integer.parseInt(tokens.nextToken());
        }
        parents[1] = 0;
        for(int i=0; i<m; i++){
            tokens = new StringTokenizer(input.readLine());
            int employee = Integer.parseInt(tokens.nextToken());
            int compliment = Integer.parseInt(tokens.nextToken());
            score[employee] += compliment;
        }

        for(int i=1; i<n+1; i++){
            score[i] += score[parents[i]];
        }

        for(int i=1; i<n+1; i++){
            output.append(score[i]+" ");
        }
        output.close();
    }

    static String src =
            "5 3\n" +
            "-1 1 2 3 4\n" +
            "2 2\n" +
            "3 4\n" +
            "5 6";
}
