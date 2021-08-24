package algorithm.BOJ.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 최단경로 {
	static int V , E ;
	static Node[] edgeList;
	
	static class Node implements Comparator<Node>{
		int from,to,weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compare(Node o1, Node o2) {
			return Integer.compare(o1.weight, o2.weight);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		int start = sc.nextInt();
		edgeList = new Node[E];
		for(int i = 0 ; i < E; i++)
		{
			int from = sc.nextInt();
			int to   = sc.nextInt();
			int weight=sc.nextInt();
			edgeList[i] = new Node(from, to, weight);
		}
		
		Arrays.sort(edgeList);
		for(int i = 0 ; i < E ; i++)
		{
			
		}
	}
}
