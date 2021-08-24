package algo;

import java.util.Scanner;

public class 창용마을무리의개수 {
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc =1; tc<= T; tc++)
		{
			
			int N  = sc.nextInt(); //사람 수 
			int M  = sc.nextInt(); //간선 수 
			int res= N;
			parent = new int [N+1];
			for(int i = 1 ; i <= N ; i++)
				parent[i] = i;
			for(int i = 0 ; i < M ; i++)
			{
				int from = sc.nextInt();
				int to   = sc.nextInt();
				if(union(from,to))
					res--;
			}
			
			System.out.printf("#%d %d\n",tc,res);
		}
	}
	
	public static int find_set(int a)
	{
		if(parent[a] == a) return a;
		return parent[a] = find_set(parent[a]);
	}
	
	public static boolean union (int a , int b)
	{
		int a_root = find_set(a);
		int b_root = find_set(b);
		if(a_root == b_root) return false;
		parent[b_root] = a_root;
		return true;
	}
}
