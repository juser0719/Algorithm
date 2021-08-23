package liveCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjList {
	
	static class Node
	{
		int vertax;
		Node link;
		
		public Node(int vertax, Node link) {
			super();
			this.vertax = vertax;
			this.link = link;
		}
		
	}
	
	static int N; // 정점의 갯수.
	static Node[] adjList; // 인접 리스트.	
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adjList = new Node[N];
		visited = new boolean[N];
		int C = Integer.parseInt(br.readLine()); // 간선 갯수.
		
		for(int i = 0 ; i < C ; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
	}
	
	public static void bfs(int start)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty())
		{
			int now= q.poll();
			for(Node temp = adjList[now]; temp!= null ; temp=temp.link)
			{
				if(!visited[temp.vertax])
				{
					q.add(temp.vertax);
					visited[temp.vertax] = true;
				}
			}
		}
	}
	
	public static void dfs(int start , boolean[] visited)
	{
		visited[start] = true;
		for(Node temp = adjList[start]; temp!= null ; temp=temp.link)
		{
			if(!visited[temp.vertax])
			{
				dfs(temp.vertax,visited);
			}
		}
	}
}
