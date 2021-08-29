package algo;

import java.util.Arrays;
import java.util.Scanner;

public class 도시건설 {
	static int N ,M, res = 0;
	static Edge[] E;
	static int[]  parent;
	static class Edge implements Comparable<Edge>{
		int from , to , w;

		public Edge(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
		
	}

	public static int find (int a)
	//a 가 속한 집합의 대표자 찾기.
	{
		if(a == parent[a]) return a; // 자신이 대표자임.
//		return find(parents[a]); 일반적인 방법으로 부모찾아옴,
		return parent[a] = find(parent[a]); // 자신이 속한 집합의 대표자를 자신의 부모로.. : path compression -> 연산 쉽게 해줌.
	}
	public static boolean union(int a, int b)
	// 두 원소를 하나의 집합으로합치기.
	{
		int a_root = find(a);
		int b_root = find(b);
		if(a_root == b_root) return false; // 이미 같은 집합이므로 합치지 않음.
		
		parent[b_root] = a_root;
		// a_root 밑으로 b_root set 이 모두 흡수됨.
		return true;
	}
	public static boolean check()
	{
		boolean flg = true;
		int tmp = find(1);
		for(int i = 2; i < N+1; i++)
		{
			if(tmp != find(i)) {
				flg =false;
				break;
			}
		}
		return flg;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		E = new Edge[M];
		parent  = new int[N+1];
		int total = 0;
		for(int i = 0 ; i < M ; i ++)
		{
			int from = sc.nextInt();
			int to   = sc.nextInt();
			int w    = sc.nextInt();
			E[i] = new Edge(from, to, w);
			total += w;
		}
		check();
		for(int i = 1; i <= N ; i++)
		{
			parent[i] = i;
		}
		Arrays.sort(E);
		int minMST = 0;
		for(int i = 0; i < M; i++)
		{
			if(union(E[i].from,E[i].to))
			{
				minMST += E[i].w;
			}
		}
		if(check())
			System.out.println(total-minMST);
		else
			System.out.println(-1);
	}
	
	
}
