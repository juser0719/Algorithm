package algorithm.BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 프로세스연결하기 {
	static int[][] map;
	static int[] dx = {0,0,-1,1} , dy = {-1,1,0,0};
	static int res_core,res_wire , N;
	static ArrayList<int[]> cores;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T ; tc++)
		{
			N = Integer.parseInt(br.readLine());
			res_core = Integer.MIN_VALUE;
			res_wire = Integer.MAX_VALUE;
			map = new int[N][N];
			cores = new ArrayList<int[]>();
			for(int i = 0 ; i < N ; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)
					{
						if(i == 0 || j == 0 || i == N-1 || j == N-1) continue;
						cores.add(new int[] {i,j});
					}
				}
			}
			//////input///////
			connet(0,0,0);
			sb.append("#"+tc+" "+res_wire+"\n");
//			System.out.printf("#%d %d",tc,res_wire);
		}
		
		System.out.println(sb.toString());
	}
	private static void connet(int idx, int core, int wire) {
		
		if(idx == cores.size()) {
			if(res_core < core) 
			{
				res_core = core;
				res_wire = wire;
			} else if (res_core == core) 
				res_wire = Math.min(wire, res_wire);
			return;
		}
		int x = cores.get(idx)[1];
		int y = cores.get(idx)[0];
		
			
		for(int i = 0 ; i < 4 ; i++)
		{
			if(isConnected(y,x,i))
			// 만약 연결 할 수 있다면.	
			{
				int ny = y + dy[i];
				int nx = x + dx[i];
				int len= 0;
				
				//전선 연결해보기.
				while(ny< N && nx < N && ny>= 0 && nx >=0) {
					map[ny][nx] = 2;
					ny += dy[i];
					nx += dx[i];
					len++;
				}
				
				//연결했다는 가정하에 다음으로 넘어감.
				connet(idx+1,core+1,wire +len);
				
				//연결 풀어주기.
				ny = y + dy[i];
				nx = x + dx[i];
				while(ny< N && nx < N && ny>= 0 && nx >=0) {
					map[ny][nx] = 0;
					ny += dy[i];
					nx += dx[i];
				}
				//연결 안했다는 가정하에 다음으로 넘어감.
				connet(idx+1,core,wire);
			} 
		}
		
	}
	private static boolean isConnected(int y, int x, int i) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if(ny<0|| nx <0 || ny>=N || nx >= N)
			return false;
		while (ny<N && nx <N && nx>=0 && ny>=0) {
			if(map[ny][nx] !=0)
				return false;
			ny += dy[i];
			nx += dx[i];
		}
		return true;
	}
}
