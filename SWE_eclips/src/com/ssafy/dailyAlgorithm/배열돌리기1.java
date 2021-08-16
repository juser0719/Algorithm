package algo;

import java.util.Scanner;

public class 배열돌리기1 {
	static int N,M,R;
	static int[][] map;
	static int[] dx = {0,1,0,-1},dy = {1,0,-1,0};
	
	public static void rotate()
	{
		for(int i = 0 ; i < Math.min(N,M)/2; i++)
		{
			//(i,i)
			int y = i, x = i;
			
			char dir = 'D';
			int temp = map[i][i];
			int swap;
			boolean flg = true;
			while(flg)
			{
				
				switch (dir) {
				case 'D': 
					if(y+1< N - i)
					{
						y++;
						swap = map[y][x];
						map[y][x] = temp;
						temp = swap;
					}else {
						dir = 'R';
					}
					break;
				case 'R':
					if(x+1 < M - i)
					{
						x++;
						swap = map[y][x];
						map[y][x] = temp;
						temp = swap;
					}else {
						dir = 'U';
					}
					break;
				case 'U':
					if(y-1>=i)
					{
						y--;
						swap = map[y][x];
						map[y][x] = temp;
						temp = swap;
					}else {
						dir = 'L';
					}
						
					break;
				case 'L':
					if(x-1>=i)
					{
						x--;
						swap = map[y][x];
						map[y][x] = temp;
						temp = swap;
					} else
						flg = false;
					break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + dir);
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt(); R = sc.nextInt();
		map= new int[N][M];
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < M ; j++)
				map[i][j] = sc.nextInt();
		for(int r = 0 ; r< R ;r++)
		{
			rotate();
		}
		
		for(int c = 0 ; c<N;c++)
		{
			for(int r = 0; r< M ; r++)
				System.out.printf("%d ",map[c][r]);
			System.out.println();
		}
	}
}
