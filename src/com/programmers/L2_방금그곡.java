package com.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class L2_방금그곡 {
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        StringTokenizer tokens;
        int longestMusicLen = 0;
        for(int i=0; i<musicinfos.length; i++){
            tokens = new StringTokenizer(musicinfos[i],",");
            String StartTimeStr = tokens.nextToken();
            String EndTimeStr = tokens.nextToken();
            String title = tokens.nextToken();
            String music = tokens.nextToken();

            int startTime = Integer.parseInt(StartTimeStr.substring(0,2))*60 + Integer.parseInt(StartTimeStr.substring(3,5));
            int endTime = Integer.parseInt(EndTimeStr.substring(0,2))*60 + Integer.parseInt(EndTimeStr.substring(3,5));
            int playTime = endTime-startTime;

            List<String> notes = new ArrayList<>();
            for(int j=0; j<music.length(); j++){
                if(music.charAt(j) != '#'){
                    if(j < music.length()-1 && music.charAt(j+1) == '#'){
                        notes.add(music.charAt(j++)+"#");
                    }else{
                        notes.add(music.charAt(j)+"");
                    }
                }
            }
//            System.out.println(notes);

            int quotient = playTime / notes.size();
            int remainder = playTime % notes.size();
            String playedMusic = "";
            for(int j=0; j<quotient; j++){
                playedMusic += music;
            }
            for(int j=0; j<remainder; j++){
                playedMusic += notes.get(j);
            }

//            System.out.println(playedMusic);
            if(m.charAt(m.length()-1) != '#'){
                playedMusic = playedMusic.replaceAll(m+"#","X");
            }
//            System.out.println(playedMusic);
            if(playedMusic.contains(m) && longestMusicLen < playTime){
                longestMusicLen = playTime;
                answer = title;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m1 = "CC#BCC#BCC#BCC#B"	;
        String[] musicinfos1 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m2 = "ABC"	;
        String[] musicinfos2 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m3 = "ABC"	;
        String[] musicinfos3 = {"12:00,12:14,HELLO,ABC#D#", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos)); //HELLO
        System.out.println(solution(m1, musicinfos1)); //FOO
        System.out.println(solution(m2, musicinfos2)); //WORLD
        System.out.println(solution(m3, musicinfos3)); //
    }
}
