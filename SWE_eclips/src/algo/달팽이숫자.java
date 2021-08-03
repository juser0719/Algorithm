package algo;

import java.util.Scanner;

public class 달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] map;
		for(int tc=1; tc<=T; tc++)
		{
			int N = sc.nextInt();
			map= new int[N][N];
			boolean flg = true;
			int num = 1;
			
			for(int i = 0 ; i < N; i++)
			{
				for(int j = 0; j<N; j++)
				{
					if(flg)
					{
						map[i][j] = num;
						num++;
					}else
					{
						map[j][i] = num;
						num++;
					}
					if() flg = !flg;
					
				}
			}
			
			
		}
	}
}
