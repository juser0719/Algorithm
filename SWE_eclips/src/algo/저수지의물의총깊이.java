package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 저수지의물의총깊이 {
	static int dx[] = {-1,-1,-1,0,1,1,1,0};
	static int dy[] = {-1,0,1,1,1,0,-1,-1};
	static int res = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= T ; tc++)
		{
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			for(int i = 0 ; i < N ; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++)
					map[i][j] = st.nextToken().charAt(0);
			}
			int deep = 0;
			for(int i = 0 ; i < N;  i ++)
				for(int j = 0; j<N ; j++)
					{
						if(map[i][j] == 'W')
							deep =dfs(map,i,j);
						res = Math.max(deep, res);
					}
			System.out.printf("#%d %d\n",tc,res);	
		}		
	}
	
	public static int dfs(char[][]map,int y, int x)
	{
		int sum = 0;
		int N = map.length;
		for(int i = 0 ; i < 8; i++)
		{
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx < 0 || nx < 0 || N<=nx || N<=ny) continue;
			if(map[ny][nx] == 'W')
				sum++;
		}
		if(sum == 0) return 1;
		return sum;
	}
}
