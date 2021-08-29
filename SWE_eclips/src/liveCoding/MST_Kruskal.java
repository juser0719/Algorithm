package liveCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_Kruskal {
	static int V , E; // 노드의 갯수 , 간선의 갯수.
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		
		int start,end,weight;

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
	
	static int[] parents;
	
	public static void make_set()
	{
		parents = new int [V];
		for(int i = 0 ; i < V ; i++)
			parents[i] = i;
	}
	
	public static int find (int a)
	//a 가 속한 집합의 대표자 찾기.
	{
		if(a == parents[a]) return a; // 자신이 대표자임.
		return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로.. : path compression -> 연산 쉽게 해줌.
	}
	
	public static boolean union(int a, int b)
	// 두 원소를 하나의 집합으로합치기.
	{
		int a_root = find(a);
		int b_root = find(b);
		if(a_root == b_root) return false; // 이미 같은 집합이므로 합치지 않음.
		
		parents[b_root] = a_root;
		// a_root 밑으로 b_root set 이 모두 흡수됨.
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 노드 갯수 입력.
		E = Integer.parseInt(st.nextToken()); // 간선 갯수 입력.
		
		edgeList = new Edge[E];
		
		for(int i = 0 ; i < E ; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight); //간선 정보 입력.
		}
		
		Arrays.sort(edgeList); // 가중치를 기준으로 정렬.
		
		make_set();// 모든 정점을 각각의 집합으로 만들고 출발.
		int cnt  = 0 , res =0;
		for(Edge edge : edgeList)
		{
			if(union(edge.start,edge.end)) // true : 합치기 성공. false :합칠 필요 없음.
			{
				res += edge.weight;
				if(++cnt == V-1) break; // 신장트리 완성.
			}
		}
		
		System.out.println(res);
	}
}
