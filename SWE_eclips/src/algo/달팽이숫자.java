package algo;

import java.util.Scanner;

public class 달팽이숫자 {
	
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] map;
		for(int tc=1; tc<=T; tc++)
		{
			int N = sc.nextInt();
			map= new int[N][N];
			
			if(N == 1)
			{
				System.out.printf("#%d\n",tc);
				System.out.printf("1 \n");
				continue;
			}
			
			int dir = 0;
			int num = 1;
			int y =0, x=0;
			
			for(int i = 1 ; i <= N*N ; i++)
			{
				map[y][x] = i;
				x += dx[dir];
				y += dy[dir];
				
				if(x<0 || x>=N || y<0 || y>= N)
				{
					x -=dx[dir];
					y -=dy[dir];
					dir = (dir+1)%4;
					
					x += dx[dir];
					y += dy[dir];
				}
				
				if(map[y][x] != 0)
				{
					x -= dx[dir];
					y -= dy[dir];
					dir = (dir+1)%4;
					x += dx[dir];
					y += dy[dir];
				}
			}
			
			System.out.printf("#%d\n",tc);
			
			for(int i= 0; i<N; i++)
			{
				for(int j = 0 ; j<N; j++)
					System.out.printf("%d ",map[i][j]);
				System.out.println();
			}
		}
	}
}
