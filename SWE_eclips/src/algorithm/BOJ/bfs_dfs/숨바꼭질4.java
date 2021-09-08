package algorithm.BOJ.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 숨바꼭질4 {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] visite = new int[100000+1]; // key = pos , val = time
			int[] path   = new int[100000+1]; // key = to  , val = from
			
			visite[N] = 1;
			path[N] = N;
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(N);
			while(!q.isEmpty()) {
				
				int now = q.poll();
				
				if (now == K) 
				{
					System.out.println(visite[now] -1);
					Stack<Integer> st =new Stack<>();
					while(path[now] != now) 
					{
						st.add(now);
						now = path[now];
					}
					
					st.add(N);
					
					StringBuilder sb = new StringBuilder();
	                while (!st.isEmpty())
	                    sb.append(st.pop() + " ");
	                System.out.println(sb.toString());
	                
					return;
				}
				
				int[] move = {now*2,now+1,now-1};
				
				for(int i = 0 ; i < 3; i++){
					int next = move[i];
					if(next < 0|| next > 100000 || visite[next] != 0) continue;
					
					visite[next] = visite[now] +1;
					path[next] = now;
					q.add(next);
				}
			}
			
	}
}
