package algorithm.BOJ.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽돌깨기 {
	
	static class Point{
		int y,x,cnt;

		public Point(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	static int K,N,M,min;
	static int[] dy = {1,-1,0,0}, dx = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<= T; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[][] map= new int [N][M];
			
			for(int i =0 ; i < N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j =0 ; j < M ; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			Throw(0,map);
			System.out.println(min);
		}
	}

	private static void Throw(int cnt,int[][] map) {
		if (cnt == K) // 구슬 다 던짐.
		{
			// 남아있는 벽돌수 카운트 후 최소값 갱신.
			int res = 0;
			
			for(int i =0 ; i < N ; i++)
				for(int j =0 ; j < M; j++)
					if(map[i][j] != 0) res++;
			
			min = Math.min(res, min);
			
			return;
		}
		int[][] copy_map = new int[N][M];
		for(int x =0 ; x < M ; x++)
		{
			int y= 0;
			while(y<N &&map[y][x] == 0) y++;
			
			if (y == N) // 구슬을 던졌지만 맞는 벽돌이 없는 경우.
			{
				Throw(cnt+1,map); // 다음 구슬 던지기.
			} else // 맞은 벽돌이 있는 경우.
			{
				//1. 이전까지의map 복사해서 사용.
				for(int i =0 ;i < N ; i++)
					for(int j =0 ; j < M; j++)
						copy_map[i][j] = map[i][j];
				//2. 맞은 벽돌 및 주변 함께 제거처리.
				boom(copy_map,y,x);
				//3. 제거된벽돌 내리기.
				down(copy_map);
				//4. 다음 구슬 던지기.
				Throw(cnt+1,copy_map);
			}
		}
		
	}
	private static void boom(int[][] copy_map, int y, int x) {
		Queue<Point> q = new LinkedList<Point>(); //q 에 들어갈 좌표는 삭제가 시작될 좌표를 넣음.
		
		if(copy_map[y][x] > 1) // 1 이상일때만 연쇄처리.
			q.add(new Point(y,x,copy_map[y][x]));
		copy_map[y][x] = 0; // 벽돌 제거.
		
		Point p = null;
		
		while(!q.isEmpty())
		{
			p = q.poll();
			for (int i =0 ; i < 4; i++)
			{
				int ny = p.y;
				int nx = p.x;
				
				for (int k=1; k< p.cnt ; k++)
				// 몇개까지갈껀지.
				{
					ny += dy[i];
					nx += dx[i];
					if(ny<0 || nx <0 || N<=ny|| M<=nx || copy_map[ny][nx] == 0) continue;
					if(copy_map[ny][nx]>1)
						q.add(new Point(ny,nx,copy_map[ny][nx]));
					copy_map[ny][nx] = 0; // 부숴주기.
				}
			}
		}
		
	}
	
	private static void down(int[][] copy_map) {
		for(int x = 0; x < M ; x++)
		{
			int y = N-1;
			while(y>0)
			{
				if(copy_map[y][x] == 0)// 빈칸이라면,	
				{
					int ny = y-1;
					while(ny>0 && copy_map[ny][x] == 0) ny--;
					
					copy_map[y][x] = copy_map[ny][x]; // 현재빈칸에는 자신의 위쪽으로 처음 만나는 벽돌로 내리기.
					copy_map[ny][x] = 0; // 내린 벽돌은 빈칸으로.
				}
				y--;
			}
		}
	}
}
