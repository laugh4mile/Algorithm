package com.baekJoon;
import java.io.*;
import java.util.*;
/**
                    
while문 종료조건: isOrdered() == true
shuffle(): S대로 카드 섞기
isOrdered(): 플레이어 순서 확인하여 올바르면 true, 그렇지 않으면 false 반환
checkCycle(): 처음 player상태와 비교하여 cycle인지 check
shuffle후 원래배열값은 계속 조정해줌
*/
public class BJ1091_카드섞기 {
    static int N, ans;
    static int[] P, S, P_original;
    
    public static boolean checkCycle() {
        boolean flag = true;
        
        for (int i=0; i<N; i++) {
            if (P[i] != P_original[i]) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
    
    public static void shuffle() {
        // class 만들어서 정렬기준 만들기
        ArrayList<Card> cards = new ArrayList<>();
        for (int i=0; i<N; i++)
            cards.add(new Card(P[i], S[i]));
        
        // shuffle
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return Integer.compare(o1.order, o2.order);
            }
            
        });
        
        //System.out.print("shuffle 이후: ");
        for (int i=0; i<N; i++) {
            P[i] = cards.get(i).player;
            //System.out.print(P[i] + " ");
        }
        
        if (!checkCycle()) ans++;
        else ans = -1;
    }
    
    public static boolean isOrdered() {
        boolean flag = true;
        
        for (int i=0; i<N; i++) {
            switch((i + 3) % 3) {
            case 0:
                if (P[i] != 0) flag = false;
                break;
            case 1:
                if (P[i] != 1) flag = false;
                break;
            case 2:
                if (P[i] != 2) flag = false;
                break;
            }
            if (!flag) break;
        }
        
        return flag;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        P_original = new int[N];
        S = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            P_original[i] = P[i];
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++)
            S[i] = Integer.parseInt(st.nextToken());
        
        boolean flag = false;
        while (!flag) {
            flag = isOrdered();
            if (flag) break;
            
            shuffle();
            if (ans == -1) break;
        }
        
        
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
class Card {
    int player;
    int order;
    
    public Card(int player, int order) {
        this.player = player;
        this.order = order;
    }
}