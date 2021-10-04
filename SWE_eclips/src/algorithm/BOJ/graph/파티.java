package algorithm.BOJ.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 파티 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		@SuppressWarnings("unchecked")
		ArrayList<int[]>[] adj = new ArrayList[N+1];
		@SuppressWarnings("unchecked")
		ArrayList<int[]>[] reverse = new ArrayList[N+1];
		
		for(int i =1; i <= N; i++)
		{
			adj[i] = new ArrayList<int[]>();
			reverse[i] = new ArrayList<int[]>();
		}
		
		for(int i =0; i< M; i++)
		{
			int from = sc.nextInt();
			int to = sc.nextInt();
			int w  = sc.nextInt();
			adj[from].add(new int[] {to,w});
			reverse[to].add(new int[] {from,w});
		}
		
		int[] dis = dijkstra(X,N,adj);
		int[] revers_dis = dijkstra(X,N,reverse);
		int res = 0;
		for(int i = 1; i <= N ; i++)
			res = Math.max(res, dis[i]+revers_dis[i]);
		System.out.println(res);
	}
	private static int[] dijkstra(int now, int N, ArrayList<int[]>[] arr) {
		int[] dis = new int[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(x -> x[1]));
		pq.add(new int[] {now,0});
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			
			if(dis[node[0]] < node[1]) continue;
			
			dis[node[0]] = node[1];
			for(int i = 0 ; i < arr[node[0]].size(); i++)
			{	
				int[] tmp =  arr[node[0]].get(i);
				pq.add(new int[] {tmp[0],tmp[1]+node[1]});
			}
		
		}
		return dis;
	}
}
