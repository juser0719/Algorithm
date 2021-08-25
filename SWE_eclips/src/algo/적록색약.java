package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 {
	static int N;
	static int[] dx = {1,-1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		char[][]copy= new char[N][N];
		for(int i = 0 ; i < N ; i ++)
		{
			String row = br.readLine();
			for(int j = 0 ; j < N ; j++)
				{
					map[i][j] = row.charAt(j);
					if(row.charAt(j) == 'R' || row.charAt(j) == 'G')
						copy[i][j]= 'R';
					else
						copy[i][j] = row.charAt(j);
				}
		}
		
		
		int cnt = 0;
		int cnt2= 0;
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				{
					if(map[i][j] != 'O')
					{
						cnt++;
						dfs(i,j,map[i][j],map);
					}
					if(copy[i][j] !='O')
					{
						cnt2++;
						dfs(i,j,copy[i][j],copy);
					}
				}
					
		System.out.println(cnt+" "+cnt2);
	}
	
	public static void dfs(int y, int x,char color,char[][]map)
	{
		map[y][x] = 'O';
		for(int i = 0 ; i < 4; i++)
		{
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny<0 || nx <0 || nx >= N || ny >= N || map[ny][nx] == 'O' || map[ny][nx] != color) continue;
			dfs(ny,nx,map[ny][nx],map);
			
		}
	}
	
}
