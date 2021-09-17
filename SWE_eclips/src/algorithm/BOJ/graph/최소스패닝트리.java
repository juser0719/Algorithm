package algorithm.BOJ.graph;

import java.util.Arrays;
import java.util.Scanner;

public class 최소스패닝트리 {
	static int V, E;
	
	static class Edge implements Comparable<Edge>{
		int start,end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	static Edge[] edges;
	static int[] parents;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int tc =1; tc<= T; tc++) 
		{
			V = sc.nextInt();
			E = sc.nextInt();
			parents= new int[V+1];
			edges = new Edge[E];
			for(int i = 0 ; i < E; i++) 
			{
				int from = sc.nextInt();
				int to   = sc.nextInt();
				int w    = sc.nextInt();
				edges[i] = new Edge(from,to,w);
			}
			for(int i = 0 ; i <= V; i++)
			{
				parents[i] = i;
			}
			
			Arrays.sort(edges);
			
			int cnt = 0;
			long res = 0;
			
			for(Edge edge: edges)
			{
				if(union(edge.start,edge.end))
				{
					res += edge.weight;
					if(++cnt == V-1) break;
				}
					
			}
			sb.append("#"+tc+" "+res+"\n");
			
		}
		
		System.out.println(sb.toString());
	}
	
	static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		if(a_root == b_root)
			return false;
		parents[b_root] = a_root;
		return true;
	}
}
