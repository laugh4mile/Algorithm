package com.programmers;

public class L1_모의고사 {
	public int[] solution(int[] answers) {
        int[] answer = {};
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[][] score = new int[3][1];
        int max = -1;
        for(int i=0; i<answers.length; i++){
            if(answers[i] == supo1[i % supo1.length]){
                score[0][0] += 1;
                if(max < score[0][0]){
                    max = score[0][0];
                }
            }
            if(answers[i] == supo2[i % supo2.length]){
                score[1][0] += 1;
                if(max < score[1][0]){
                    max = score[1][0];
                }
            }
            if(answers[i] == supo3[i % supo3.length]){
                score[2][0] += 1;
                if(max < score[2][0]){
                    max = score[2][0];
                }
            }
        }
        // System.out.println(max);
        // for(int []x : score){
        //     System.out.println(Arrays.toString(x));
        // }
        int cnt = 0;
        for(int i=0; i<3; i++){
            if(score[i][0] == max){
                cnt++;
            }
        }
        answer = new int[cnt];
        int index = 0;
        for(int i=0; i<3; i++){
            if(score[i][0] == max){
                answer[index++] = i+1;
            }
        }
        
        return answer;
    }
}
