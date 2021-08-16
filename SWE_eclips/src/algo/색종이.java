package algo;

import java.util.Scanner;

public class 색종이 {
	
	static int[][] map = new int[100][100];
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			draw(y,x);
		}
		System.out.println(cnt);
	}
	
	public static void draw(int y,int x)
	{
		for(int i = y; i < y+10; i ++)
			for(int j = x ; j < x +10; j++)
				if(map[i][j] != 1)
				{
					map[i][j] = 1;
					cnt++;
				}
	}
}
