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
	private static int[] dijkstra(int start, int N, ArrayList<int[]>[] arr) {
		
		int[] dis = new int[N+1]; // start에서 각 노드로 가는 최소비용.
		Arrays.fill(dis, Integer.MAX_VALUE); // 처음엔 무한대로 설정.
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(x -> x[1])); // 가중치에 맞게 정렬.
		pq.add(new int[] {start,0}); // start노드, 가중치:0 =>자기자신이니까.
		
		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			int node_num = node[0]; // 시작노드번호.
			int node_weight   = node[1]; // 가중치.
			
			if(dis[node_num] < node_weight) continue;
			//만약 노드의 거리가 가중치보다 작다면,
			dis[node_num] =  node_weight;
			
			//node_num에서 갈 수 있는 노드들 체크.
			for(int i = 0 ; i < arr[node_num].size(); i++)
			{	
				int[] tmp =  arr[node_num].get(i);
				int next_node = tmp[0];
				int next_node_w = tmp[1];
				
				pq.add(new int[] {next_node,next_node_w+node_weight});
			}
		
		}
		return dis;
	}
}
