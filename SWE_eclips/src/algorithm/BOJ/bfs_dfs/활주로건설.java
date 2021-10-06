package algorithm.BOJ.bfs_dfs;

import java.util.Scanner;

public class 활주로건설 {
	static int N,X;
	static int[][] map,visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int tc =1; tc<=T; tc++)
		{
			N =sc.nextInt();
			X =sc.nextInt();
			map = new int[N][N];
			
			for(int i =0 ; i < N;i++)
				for(int j =0; j<N; j++)
					map[i][j] = sc.nextInt();
			
			int res = 0;
			
			for(int i =0 ; i < N ; i++)
			{	if(ver(i)) res++;
				if(hor(i)) res++;
			}
			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean hor(int idx) {
		int height = map[idx][0];
		int cnt = 1;
		
		for(int i =1; i< N; i++)
		{
			if(map[idx][i] == height)
			{
				cnt++;
				continue;
			}
			
			if(map[idx][i] == height-1) // height보다 낮은 지형 만나게 된다면,
			{
				// X 까지 지속되는지 체크.
				for(int x = 1; x<X ;x++)
				{
					int nx = x+i;
					// x 좌표가 범위를 넘어가거나, 차이가 1나지 않으면 틀린곳.
					if(N<=nx || map[idx][nx]!= height-1) return false;
				}
				// x 만큼 flat 한 공간 있으면, 높이 치환, 카운트 0, i는 x-1(처음cnt=1이라) 만큼 늘려줌.
				height = map[idx][i];
				cnt = 0;
				i += X-1; 
			}
			else if(map[idx][i] == height+1) // 현재 높이보다 1 높은 지형 만나게 된다면,
			{
				//지금까지의 지형이 경사로 놓기 부족하다면, false!
				if(cnt < X)
					return false;
				height = map[idx][i];
				cnt =1;
			} else // 차이가 1이상 크다면.
				return false;
		}
		return true;
	}

	private static boolean ver(int idx) {
		int height = map[0][idx];
		int cnt = 1;
		
		for(int i =1; i< N; i++)
		{
			if(map[i][idx] == height)
			{
				cnt++;
				continue;
			}
			
			if(map[i][idx] == height-1) // height보다 낮은 지형 만나게 된다면,
			{
				// X 까지 지속되는지 체크.
				for(int x = 1; x<X ;x++)
				{
					int ny = x+i;
					// x 좌표가 범위를 넘어가거나, 차이가 1나지 않으면 틀린곳.
					if(N<=ny || map[ny][idx]!= height-1) return false;
				}
				// x 만큼 flat 한 공간 있으면, 높이 치환, 카운트 0, i는 x-1(처음cnt=1이라) 만큼 늘려줌.
				height = map[i][idx];
				cnt = 0;
				i += X-1; 
			}
			else if(map[i][idx] == height+1) // 현재 높이보다 1 높은 지형 만나게 된다면,
			{
				//지금까지의 지형이 경사로 놓기 부족하다면, false!
				if(cnt < X)
					return false;
				height = map[i][idx];
				cnt =1;
			} else // 차이가 1이상 크다면.
				return false;
		}
		return true;
	}

	
}
