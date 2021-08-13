package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달 {
	
	static ArrayList<int[]> store = new ArrayList<int[]>();
	static ArrayList<int[]> home  = new ArrayList<int[]>();
	static int N,M,res = Integer.MAX_VALUE , sum = 0;
	static boolean[] visited;
	
	static void combination(int cnt , int start)
	{
		if(cnt == M)
		{
			sum = 0;
			for(int i  = 0 ; i < home.size(); i++)
			{
				int h_y = home.get(i)[0];
				int h_x = home.get(i)[1];
				int min_dis=  Integer.MAX_VALUE;
				
				for(int j  = 0 ; j < store.size() ; j ++)
				{
					if(visited[j])
					{
						int s_y = store.get(j)[0];
						int s_x = store.get(j)[1];
						min_dis = Math.min(min_dis, Math.abs(h_y - s_y) + Math.abs(h_x - s_x));
						
					}
				}
				sum += min_dis;
			}
			res = Math.min(sum, res);
			return;
		}
		
		for(int i = start ; i < store.size(); i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				combination(cnt+1, i+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0  ; i < N ; i ++)
		{	
			st = new StringTokenizer(br.readLine());
			for(int j =  0 ; j< N ; j++)
			{
				int val = Integer.parseInt(st.nextToken());
				if (val == 1)
					home.add(new int[] {i,j});
				else if(val == 2)
					store.add(new int[] {i,j});
			}
		}
		visited = new boolean [store.size()];
		combination(0,0);
		System.out.println(res);
		
	}
}
