package com.cordingtest.woowa;

public class Q7 {
	
	static int N = 4;
	static int arr[][]= new int [N][N]; 
	static int arr2[][]= new int [N][N]; 
	public static void main(String[] args) {
	    int cnt=-1;
	    
	    int c=0, r=-1;
	    char direction = 'u'; 
	    direction='u'; 
	    
	    while(true){ 
	        if(c==N-1){
	            arr[++r][c]=++cnt;
	            direction='d';
	        }
	        if(r==N-1){
	            arr[r][++c]=++cnt;
	            direction='u';
	        }
	        if(r==0){
	            arr[r][++c]=++cnt;
	            direction='d';
	        }
	        if(c==0){
	            arr[++r][c]=++cnt;
	            direction='u';
	        }
	        if(direction=='u'&&c!=N-1&&r!=0) {
	        	arr[--r][++c]=cnt+2;
	        	cnt += 2;
	        }
	        if(direction=='d'&&r!=N-1&&c!=0) {
	        	arr[++r][--c]=cnt+2;
	        	cnt += 2;
	        }
	        if(r==N-1 && c==N-1) {
	    		break;
	    	}
	    }
	    
	    
	    for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            System.out.print(arr[i][j]+" ");
	        }
	        System.out.println();
	    }
	    System.out.println();
//	    turnArr();
	    for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr2[i][j] = arr[j][i];
            }
        }
	    
	    for(int i=0;i<N;i++){
	    	for(int j=0;j<N;j++){
	    		System.out.print(arr2[i][j]+" ");
	    	}
	    	System.out.println();
	    }
	    System.out.println();
	}
	private static void turnArr() {
		for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            System.out.print(arr[j][i]+" ");
	        }
	        System.out.println();
	    }
	}
}
