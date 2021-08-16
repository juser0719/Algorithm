package algo;

import java.util.Scanner;

public class 영역자르기 {
	static int[][] map;
	static int N,M,cnt= 1;
	static int res = Integer.MIN_VALUE;
	static int[] dx = {0,0,-1,1} , dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int D = sc.nextInt();
		
		for(int d = 0 ;  d < D ; d++)
		{
			int dir = sc.nextInt();
			int idx = sc.nextInt() -1;
			draw(dir,idx);
		}
		
		
//		for(int i = 0 ; i < N ; i++)
//		{
//			for(int j = 0; j< M; j++)
////				System.out.printf("%d ",map[i][j]);
//			System.out.println();
//		}
		for(int i = 0 ; i < N ; i ++)
			for(int j = 0; j < M ; j++)
				{
					if(map[i][j] == 0)
					{
						cnt =1;
						get_max(i,j);
//						System.out.println(cnt);
						res = Math.max(cnt, res);
					}
				}
		System.out.println(res);
	}
	
	public static void draw(int dir, int idx)
	{
		if(dir == 1) //가
		{
			for(int j =0; j <M; j++)
				map[idx][j] = 1;
		}else
		{
			for(int i =0; i< N; i++)
				map[i][idx] = 1;
		}
		
	}
	
	public static void get_max(int y, int x)
	{
		if(map[y][x] != 0 )
			return ;
		map[y][x] = 1;
		for(int i = 0 ; i < 4; i++)
		{
			int ny = y+ dy[i];
			int nx = x+ dx[i];
			if(ny<0 || nx <0 || M<= nx|| N<=ny || map[ny][nx] != 0)
				continue;
			cnt++;
			get_max(ny,nx);
		}
	}
}
