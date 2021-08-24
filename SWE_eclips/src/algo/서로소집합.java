package algo;

import java.util.Scanner;

public class 서로소집합 {
	static int[] parents;
	
	public static int find_parent(int a)
	{
		if(parents[a] == a) return a;
		return parents[a] = find_parent(parents[a]);
	}
	
	public static boolean union(int a, int b)
	{
		int a_root = find_parent(a);
		int b_root = find_parent(b);
		
		if(a_root == b_root) return false;
		
		parents[b_root] = a_root;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
		
		for(int tc = 1; tc<=T ; tc++)
		{
			StringBuilder sb = new StringBuilder();
			int N= sc.nextInt();
			int M= sc.nextInt();
			parents = new int[N+1];
			
			for(int i = 1 ; i <= N; i++)
				parents[i] = i;
			
			for(int i = 0 ; i < M ; i++)
			{
				int flg = sc.nextInt();
				int a   = sc.nextInt();
				int b   = sc.nextInt();
				
				if(flg == 0)
					union(a,b);
				else
				{
					if(find_parent(a) == find_parent(b))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			System.out.printf("#%d %s\n",tc,sb.toString());
		}
	}
}
