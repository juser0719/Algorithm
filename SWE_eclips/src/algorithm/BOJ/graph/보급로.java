package algorithm.BOJ.graph;

import java.util.Scanner;

public class 보급로 {
	static int N,map[][];
	static int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<= T; tc++)
		{
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i =0; i <N; i++)
				for(int j = 0; j < N; j++)
					map[i][j]  = sc.nextInt();
			sb.append("#"+tc+" "+dijksra(0, 0)+"/n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int dijksra(int y,int x) {
		boolean[][] visited = new boolean[N][N]; // 방문 체크 배열.
		int[][] dp = new int[N][N]; // 이전까지 있었던 최소 값들만 저장.
		
		for(int i =0 ;i< N; i++)
			for(int j = 0; j<N; j++)
				dp[i][j] = Integer.MAX_VALUE;  // 최소를 찾기 위해 모든 값을 무한대로 초기화.
		
		dp[y][x] = 0;
		int min = Integer.MAX_VALUE;
		while (true)
		{
			// step1.
			for(int i = 0 ; i < N; i++)
				for(int j = 0 ; j< N; j++)
					if(!visited[i][j] && min > dp[i][j])
					{
						min = dp[i][j];
						y = i;
						x = j;
					}
			visited[y][x] = true;
			// 종료 조건.
			if(y == N-1 && x == N-1) return min;
			
			// step2 : 1에서 선택된 정점을 경유지로 해서 인접정점(여기선 4방 탐색.) 따져보기.
			for(int i = 0; i < 4; i++)
			{
				int ny = y+ dy[i];
				int nx = x+ dx[i];
				
				if(ny<0 || nx<0 || N<=ny || N<=nx || visited[ny][nx] || dp[ny][nx] <= min+ map[ny][nx]) continue;
				
				dp[ny][nx] =  min+ map[ny][nx]; // min이 ny,nx 까지 오는데 걸리는 최소 비용.
				y = ny;
				x = nx;
			}
			
		}
	}
}
