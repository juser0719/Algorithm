package algorithm.BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미세먼지_안녕 {
	static int N,M,T;
	static int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st= new StringTokenizer(br.readLine());
		ArrayList<int[]> aircon = new ArrayList<int[]>();
		Queue<int[]> air = new LinkedList<int[]>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		int dir = 0;
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j ++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1)
				{
					aircon.add(new int[] {i,j,dir});
					dir = 1;
				}else if (map[i][j] != 0)
				{
					air.add(new int[] {i,j});
				}
			}
		}
		
		while(T-- >0)
		{
//			spread();
			while(!air.isEmpty())
			{
				int y = air.peek()[0];
				int x = air.peek()[1];
			}
//			airCondition();
		}
		
	}
}
