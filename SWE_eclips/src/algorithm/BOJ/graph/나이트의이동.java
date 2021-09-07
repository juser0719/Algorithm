package algorithm.BOJ.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동 {
	public static int[] dy = {-2,-1,1,2,2,1,-1,-2} , dx = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T ; tc++)
		{
			int N = sc.nextInt();
			int y = sc.nextInt(),  x = sc.nextInt();
			int sy= sc.nextInt() , sx =sc.nextInt();
			int[][] map = new int [N][N];
			
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] {y,x,0});
			map[y][x] =1;
			
			while(!q.isEmpty())
			{
				int[] now = q.poll();
				if(now[0] == sy && now[1] == sx) {
					System.out.println(now[2]);
					sb.append(now[2]+"\n");
					break;
				}
				
				for(int i = 0 ; i < 8; i++)
				{
					int ny = y + dy[i];
					int nx = x + dx[i];
					if(ny<0 || nx < 0 || N <=ny|| N<=nx|| map[ny][nx] != 0) continue;
					map[ny][nx] = 1;
					System.out.printf("%d , %d\n", ny,nx);
					q.add(new int[] {ny,nx,++now[2]});
				}
			}

		}
		
		System.out.println(sb.toString());
	}
}
