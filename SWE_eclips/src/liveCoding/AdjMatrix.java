package liveCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrix {
	static int N ; // 정점 개수 
	static boolean[][] adjMatrix ; // 인접행렬 (가중치 없음.)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[N][N];
		int C = Integer.parseInt(br.readLine()); // 간선 갯수.
		
		for(int i = 0 ; i < C ; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = true;
			adjMatrix[to][from] = true; // 쌍방이니까. 
		}
		bfs(0);
		boolean[] visited = new boolean[N];
//		visited[0] = true; 해줘야함.  
//		dfs(0,visited);
	}
	
	public static void bfs(int start)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		q.add(start);// 시작 루트 노드 넣어줌.
		visited[start] = true;
		
		while(!q.isEmpty())
		{
			int now = q.poll();
			
			for(int i = 0 ; i < N; i++)
			{
				if(!visited[i] && adjMatrix[now][i])
				{
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void dfs(int start , boolean[] visited)
	{
		//visited[now] = true; //후보 2: 호출 후 수정. -> 이게 더 나을듯. 
		
		for(int i = 0 ; i < N ; i++)
		{
			if(!visited[i] && adjMatrix[start][i])
			{
				//visited[i] = true; // 후보 1 : dfs 들어가기 전에시작도 visited[start] = true; g해줘야
				dfs(i,visited);
			}
		}
	}
	
}
