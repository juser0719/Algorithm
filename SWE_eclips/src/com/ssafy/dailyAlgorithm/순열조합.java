package algo;

import java.util.Arrays;

public class 순열조합 {
	
	static int[] nums = {1,2,3};
	static int N = 3;
	static int sCnt = 0;
	
	private static void Permutation (int cnt, int[] selected,boolean[] visited)
	{
		if(cnt == N)
		{
			System.out.println(Arrays.toString(selected));
			return;
		}
		
		for(int i =0 ; i < nums.length; i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				selected[cnt] = nums[i];
				Permutation(cnt+1, selected, visited);
				visited[i] = false;
			}
		}
	}
	
	private static void Combination (int cnt, int[] selected, int startidx)
	{
		if(cnt == N)
		{
			System.out.println(Arrays.toString(selected));
			return;
		}
		
		for(int i = startidx ; i < nums.length; i++)
		{
			selected[cnt] = nums[i];
			Combination(cnt+1, selected, i+1);
		}
	}
	
	private static void powerSet(int cnt, boolean[] visited)
	{
		if(cnt == N)
		{
			sCnt ++;
			System.out.print("{");
			for(int i = 0 ; i < N ; i ++)
			{
				if(visited[i])
					System.out.printf(" %d ",nums[i]);
				
			}
			System.out.println("}");
			return;
		}
		
		visited[cnt] = true;
		powerSet(cnt+1,visited);
		
		visited[cnt] = false;
		powerSet(cnt+1,visited);
	}
	
	public static void main(String[] args) 
	{
//      1. num에서 N개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		System.out.println("-----순열-----");
		Permutation(0, new int[N], new boolean[nums.length]);
		System.out.println("-----조합-----");
		Combination(0, new int[N],0);
		System.out.println("-----모든 부분 집합-----");
		powerSet(0,new boolean[N]);
	}
}
/*
순열: 순서의 의미가 있다
예) 1 2 3 (N:2)
1  2
1  3
2  1
2  3
3  1
3  2

조합: 순서의 의미가 없다
예) 1 2 3  (N:2)
1  2
1  3
2  3
*/