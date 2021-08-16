package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NXN {
	
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int map[][],cnts[][];
	
	public static void prints()
	{
		int N = map.length;
		System.out.println("**MAP**");
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j<N ; j ++)
				System.out.printf("%d ",map[i][j]);
			System.out.println();
		}
		System.out.println("**CNTS**");
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j<N ; j ++)
				System.out.printf("%d ",cnts[i][j]);
			System.out.println();
		}
	}
	
	public static int dfs(int y,int x,int cnt)
	{
		int N = map.length;
		int total_cnt = 0;
		for(int i = 0 ; i < 4; i++)
		{
			int ny = y+ dy[i];
			int nx = x+ dx[i];
			if(ny<0 || N<=ny|| nx < 0|| N<=nx)
				continue;

			if(map[ny][nx] == (map[y][x]+1))
			{	total_cnt += 1 ;
				total_cnt += dfs(ny,nx,cnt+1);
			}
		}
		
		return total_cnt;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<= T ; tc++)
		{
			int N = sc.nextInt();
			
			map = new int[N][N];
			cnts= new int[N][N];
			
			for(int i = 0 ; i <N ; i++)
			{
				for(int j = 0; j<N ; j++)
					map[i][j] = sc.nextInt();
			}
			
			for(int i = 0 ; i < N ; i++)
				for(int j = 0 ; j< N ; j++)
					cnts[i][j] = dfs(i,j,1);
			
			prints();
			
		}
	}
}
