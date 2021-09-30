package algorithm.BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범_검거 {
	
	static class Node {
		int y,x,dir,time;

		public Node(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}	
	}
	
	static int N,M,R,C,L , cnt;
	static Queue<Node> q;
	static boolean map[][][],visit[][];
	static int[] dx = {0,0,-1,1},dy = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1 ; tc<=T; tc++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			q = new LinkedList<Node>();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new boolean[N][M][4];
			visit = new boolean[N][M];
			
			for(int i =0 ; i < N ; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++)
				{
					int type  = Integer.parseInt(st.nextToken());
					switch(type)
					{
						case 1:
							map[i][j][0] = true;
							map[i][j][1] = true;
							map[i][j][2] = true;
							map[i][j][3] = true;
							break;
						case 2:
							map[i][j][0] = true;
							map[i][j][2] = true;
							break;
						case 3:
							map[i][j][1] = true;
							map[i][j][3] = true;
							break;
						case 4:
							map[i][j][0] = true;
							map[i][j][3] = true;
							break;
						case 5:
							map[i][j][2] = true;
							map[i][j][3] = true;
							break;
						case 6:
							map[i][j][1] = true;
							map[i][j][2] = true;
							break;
						case 7:
							map[i][j][0] = true;
							map[i][j][1] = true;
							break;
					}
				}
			}
			
			visit[R][C] =true;
			cnt = 1;
			q.add(new Node(R,C,1));
			bfs();
			sb.append("#"+tc+" "+cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	private static void bfs() {
		while(!q.isEmpty())
		{
			Node tmp = q.poll();
			if(tmp.time >= L) return;
			
			for(int i = 0 ; i < 4; i++)
			{
				int ny = tmp.y + dy[i];
				int nx = tmp.x + dx[i];
				if(nx<0 || ny<0 || ny>=N || nx>=M || visit[ny][nx]) continue;
				if(map[tmp.y][tmp.x][i] && map[ny][nx][(i+2)%4])
				{
					cnt++;
					visit[ny][nx] = true;
					q.add(new Node(ny,nx,tmp.time+1));
				}
			}
		}
		
	}
}
