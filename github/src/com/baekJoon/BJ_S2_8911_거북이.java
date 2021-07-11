package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_8911_거북이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			Rectangle rec = new Rectangle(0, 0, 0, 0);
			String line = input.readLine();
			int d = 1; // 1 = 상, 2 = 하, 3 = 좌, 4 = 우
			Tutle tutle = new Tutle(0, 0, d);
			for(int c=0; c<line.length(); c++) {
				char commend = line.charAt(c);
				switch (commend) {
				case 'F':
					tutle = move(tutle, tutle.dir, commend);
					setRectangle(tutle,rec);
					break;
				case 'B':
					tutle = move(tutle, tutle.dir, commend);
					setRectangle(tutle,rec);
					break;
				case 'L':
					tutle.dir = turn(tutle.dir, commend);
					break;
				case 'R':
					tutle.dir = turn(tutle.dir, commend);
					break;
				}
			}
			System.out.println((rec.top-rec.bottom) * (rec.right-rec.left));
		}
	}
	static Rectangle setRectangle(Tutle tutle, Rectangle rec){
		if(rec.top < tutle.r) {
			rec.top = tutle.r;
		}
		if(rec.bottom > tutle.r) {
			rec.bottom = tutle.r;
		}
		if(rec.left > tutle.c) {
			rec.left = tutle.c;
		}
		if(rec.right < tutle.c) {
			rec.right = tutle.c;
		}
		return rec;
	}
	static class Rectangle{
		int top;
		int bottom;
		int left;
		int right;
		public Rectangle(int top, int bottom, int left, int right) {
			super();
			this.top = top;
			this.bottom = bottom;
			this.left = left;
			this.right = right;
		}
	}
	
	static int turn(int d, int commend) {
		if(commend == 'L') {
			switch (d) {
			case 1:
				d = 3;
				break;
			case 2:
				d = 4;
				break;
			case 3:
				d = 2;
				break;
			case 4:
				d = 1;
				break;
			}
		}else {
			switch (d) {
			case 1:
				d = 4;
				break;
			case 2:
				d = 3;
				break;
			case 3:
				d = 1;
				break;
			case 4:
				d = 2;
				break;
			}
		}
		return d;
	}
	
	static Tutle move(Tutle tutle, int dir, int commend) {
		if(commend == 'F') {
			switch (dir) {
			case 1:
				tutle.r++;
				break;
			case 2:
				tutle.r--;
				break;
			case 3:
				tutle.c--;
				break;
			case 4:
				tutle.c++;
				break;
			}
		}else {
			switch (dir) {
			case 1:
				tutle.r--;
				break;
			case 2:
				tutle.r++;
				break;
			case 3:
				tutle.c++;
				break;
			case 4:
				tutle.c--;
				break;
			}
		}
		return tutle;
	}
	
	static class Tutle{
		int r;
		int c;
		int dir;
		public Tutle(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Tutle [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
	}
	static String src =
			"3\r\n"
			+ "FFLF\r\n"
			+ "FFRRFF\r\n"
			+ "FFFBBBRFFFBBB";
}
