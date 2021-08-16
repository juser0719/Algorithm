package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로찾기 {
	
	static int[][] map;
	static int[] dx = {0,0,1,0,-1} , dy = {0,-1,0,1,0};
	static int sy,sx , N;
	
	public static void move (int dir , int cnt, int y,int x)
	{		
		int ny = y ;
		int nx = x ;
		for(int i = 0; i < cnt; i++)
		{
			ny += dy[dir];
			nx += dx[dir];
			
			if(ny<=N && 1<=ny && nx<=N && 1<=nx && map[ny][nx] == 0) // 범위 안.
			{
				sy =ny;
				sx =nx;
			}else // 범위 밖이거나 값이 2.
			{
				sy = 0;
				sx = 0;
				return;
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1 ; tc <= T ; tc++)
		{
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			map = new int[N+1][N+1];
			sy = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			
			int J = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < J ; j++)
			{
				int jy = Integer.parseInt(st.nextToken());
				int jx = Integer.parseInt(st.nextToken());
				map[jy][jx] = 2;
			}
			st = new StringTokenizer(br.readLine());
			int O = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int o = 0 ; o < O ; o++)
			{
				int dir = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				move(dir,cnt,sy,sx);
				if(sy == 0 && sx == 0)
					break;
			}
			
			System.out.printf("#%d %d %d\n",tc,sy,sx);
		}
		
		
	}
}
