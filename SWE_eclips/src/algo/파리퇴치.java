package algo;


import java.util.Scanner;

public class 파리퇴치 {
	
	static int[][] map;
	static int res =0;;
	
	
	public static void kill(int y,int x , int M)
	{
		int N = map.length;
		int sum = 0;
		for(int i = y; i<y+M ; i ++)
			for(int j = x ; j < x+M; j++)
			{
				sum+= map[i][j];
			}
		res = Math.max(res, sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<= T ; tc++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			map = new int[N][N];
			res = 0;
			
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j<N;j++)
					map[i][j] = sc.nextInt();
			
			for(int i = 0 ; i <= N-M ; i++)
				for(int j = 0 ; j <= N-M ; j ++)
					kill(i,j,M);
			
			System.out.printf("#%d %d\n",tc,res);
		}
		
	}
}
