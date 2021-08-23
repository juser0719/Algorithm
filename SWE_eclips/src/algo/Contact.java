package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Contact {
	static int N,root;
	static int[] visited;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc =1; tc<=10; tc++)
		{
			String[] first =br.readLine().split(" ");
			N = Integer.parseInt(first[0]);
			root = Integer.parseInt(first[1]);
			
			visited = new int[101];
			map = new int[101][101];
			
			String[] second = br.readLine().split(" ");
			for(int i = 1 ; i < second.length; i+=2)
			{
				int from = Integer.parseInt(second[i-1]);
				int to   = Integer.parseInt(second[i]);
				map[from][to] = 1;
			}
			
			
			System.out.printf("#%d %d\n",tc,bfs());
		}
	}
	
	public static int bfs()
	{
		int from = root;
		int from_max  = 0 ,res =0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(from);
		visited[from] = 1;
		while(!q.isEmpty())
		{
			int now = q.poll();
			
			for(int j = 0 ; j < 101 ; j ++)
			{
				if(map[now][j] == 1 && visited[j] == 0)
				{
					visited[j] = visited[now]+1; // 방문 횟수 저장. 지금까지 온 횟수 +1 = j 노드 횟수 . 
					q.add(j);
				}
			}
			from_max = visited[now];
		}
		// 최대 동시 연결 횟수와 같은 것 중에 가장 큰 노드번호 찾기.
		for(int i = 1; i<101 ; i++)
		{
			if(from_max == visited[i])
				res = Math.max(res, i);
		}
		return res;
	}
}
