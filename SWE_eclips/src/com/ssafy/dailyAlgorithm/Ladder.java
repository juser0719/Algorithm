package algo;

import java.util.Scanner;

public class Ladder {
	
	static int[][] map = new int[100][100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		
		for(int tc = 1; tc<=10 ; tc++)
		{
			int T = sc.nextInt();
			int y =0,x =0 ;
			int dir = 0 ;
			
			for(int i =0 ; i<100; i ++)
				for(int j =0; j <100; j++)
				{	
					int num = sc.nextInt();
					map[i][j] = num;
					if(num == 2)
					{
						y = i;
						x = j;
					}
						
				}
			
			////입력///
			while(y != 0)
			{
				//[y-1][x] , [y-1][x-1]  , [y-1][x+1]
				if(dir == 0)
				{
					y--;
					if(x-1>0 && map[y][x-1] == 1)
						dir = 1;
					else if (x+1 < 100 && map[y][x+1] == 1)
						dir = 2;
						
				} else if (dir == 1)
				{
					x--;
					if(map[y-1][x] == 1)
						dir = 0;	
				} else if (dir == 2)
				{
					x++;
					if(map[y-1][x] == 1)
						dir = 0;
				}
				
			}
			
			System.out.printf("#%d %d",tc,x);
			System.out.println();
		}
	}
}
