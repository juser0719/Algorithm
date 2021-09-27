package algorithm.BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
	static int N,M,res;
	static int[][] map;
	static int[] dx = {0,0,1,-1},dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		Queue<int[]> tomato = new LinkedList<int[]>();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		res = 0;
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					tomato.add(new int[] {i,j,0});
			}
		}
		
		while(!tomato.isEmpty())
		{
			int y = tomato.peek()[0];
			int x = tomato.peek()[1];
			int t = tomato.peek()[2];
			tomato.poll();
			res = Math.max(t, res);
			for(int i = 0 ; i < 4; i++)
			{
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny<0||nx<0|| ny>=N|| nx >=M || map[ny][nx] != 0) continue;
				map[ny][nx] = 1;
				tomato.add(new int[] {ny,nx,t+1});
			}
		}
		
		if(isRipe()) {
			System.out.println(res);
		}else
			System.out.println(-1);
		
	}

	private static boolean isRipe() {
		for(int i = 0 ; i < N ; i ++)
			for(int j = 0 ; j < M ; j++)
			{
				if(map[i][j] == 0)
					return false;
			}
		return true;
	}
}
