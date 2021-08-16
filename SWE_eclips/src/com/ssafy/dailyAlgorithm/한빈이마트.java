package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class 한빈이마트 {
	
	static int[] snacks;
	static int res  = -1;
	static int N,M;
	
	public static void combi(int idx, int sum_s, int cnt)
	{
		if(cnt == 2)
		{
			if(sum_s > res)
				res = sum_s;
			return;
		}
		for(int i = idx; i < N ; i ++)
		{
			if(sum_s+snacks[i] <=M)
				combi(idx+1,sum_s+snacks[i],cnt+1);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T ; tc++)
		{
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snacks = new int [N];
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i < N; i ++)
			{
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			res = -1;
			combi(0,0,0);
			if(res < 0)
				res = -1;
			System.out.printf("#%d %d\n",tc,res);
		}
	}
}
