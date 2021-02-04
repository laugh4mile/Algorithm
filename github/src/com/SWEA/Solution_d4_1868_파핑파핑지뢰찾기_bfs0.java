package swea.d4;
import java.io.*;
import java.util.*;

public class Solution_d4_1868_파핑파핑지뢰찾기_bfs0 {
	public static int[] di={-1,-1, 0, 1, 1, 1, 0,-1};//상,우상,우,우하,하,좌하,좌,좌상
	public static int[] dj={ 0, 1, 1, 1, 0,-1,-1,-1};
	public static int N;
	public static char[][] m;
	public static boolean[][] v;
	public static Queue<int[]> q;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/swea/d4/1868_파핑파핑.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++){
			N=Integer.parseInt(br.readLine());
			m=new char[N][N];
			v=new boolean[N][N];
			q=new LinkedList<int[]>();

			for(int i=0; i<N; i++){
				String s=br.readLine();
				for(int j=0; j<N; j++){
					m[i][j]=s.charAt(j);
				}
			}
			
			int ans=0;
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(m[i][j]!='.') continue; 
					if(count(i,j)==0){ 
						ans++;
						bfs(i,j);
					}
				}
			}
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(m[i][j]=='.') ans++;
				}
			}			
			System.out.println("#"+tc+" "+ans);
		}
		br.close();
	}
	public static int count(int i,int j){
		int mine=0;
		for(int d=0; d<8; d++){
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<N && m[ni][nj]=='*') mine++;
		}
		return mine;
	}
	public static void bfs(int i,int j){
		v[i][j]=true;
		q.offer(new int[]{i,j});
		while(!q.isEmpty()){
			int[] ij=q.poll();
			i=ij[0];
			j=ij[1];			

			int mine=count(i,j);
			m[i][j]=(char)(mine+'0');			
			if(mine!=0) continue;
			
			for(int d=0; d<8; d++){
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<N && m[ni][nj]=='.' && !v[ni][nj]) {
					v[ni][nj]=true;
					q.offer(new int[]{ni,nj});
				}
			}
		}
	}
}
/*
#1 1990
#2 1574
#3 1252
#4 1080
#5 7645
#6 6378
#7 5073
#8 4093
#9 17111
#10 14683
#11 11693
#12 9135
#13 30616
#14 26184
#15 20124
#16 15225
#17 48378
#18 39769
#19 31522
#20 24196
*/