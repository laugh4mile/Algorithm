package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G4_2916_자와각도기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, K;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        tokens = new StringTokenizer(input.readLine());
        List<Integer> angles = new ArrayList<>();
        for(int i=0; i<N; i++){
            int angle = Integer.parseInt(tokens.nextToken());
            angles.add(angle);
        }

//        System.out.println(Arrays.toString(angles));
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<angles.size(); i++){
            set.add(angles.get(i));
        }

        int size = 0;
        while(angles.size() != size){
            size = angles.size();
            for(int i=0; i<angles.size()-1; i++){
                for(int j=i+1; j<angles.size(); j++){
                    int hap = (angles.get(i) + angles.get(j)) > 360 ? angles.get(i) + angles.get(j) - 360 : angles.get(i) + angles.get(j);
                    int cha = (angles.get(i) - angles.get(j)) < 0 ? (angles.get(i) - angles.get(j))*-1 : (angles.get(i) - angles.get(j));

                    if(!set.contains(hap)){
                        set.add(hap);
                        angles.add(hap);
                    }

                    if(!set.contains(cha)){
                        set.add(cha);
                        angles.add(cha);
                    }

                    if(!set.contains(360-hap)){
                        set.add(360 - hap);
                        angles.add(360 - hap);
                    }

                    if(!set.contains(360-cha)){
                        set.add(360 - cha);
                        angles.add(360-cha);
                    }
                }
            }
        }
//        Collections.sort(angles);
//        System.out.println(angles);
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<K; i++){
            int angle = Integer.parseInt(tokens.nextToken());
            if(set.contains(angle)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    static String src =
            "2 1\n" +
            "30 70\n" +
            "40";
}
