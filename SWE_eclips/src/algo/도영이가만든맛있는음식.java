package algo;

import java.util.Scanner;

public class 도영이가만든맛있는음식 {
	static int[] A,B;
	static int N, min = Integer.MAX_VALUE;
	static boolean[] visited;
	
	static void makeSubset(int idx)
	{
		if(idx == N )
		{
			int A_mul =1 , B_sum = 0 , cnt = 0; 
			for(int i = 0 ; i < N ; i ++)
				if(visited[i])
				{	
					cnt++;
					A_mul *= A[i];
					B_sum += B[i];
				}
			if(cnt > 0)
				min = Math.min(Math.abs(A_mul-B_sum), min);
			return;
		}
		visited[idx] = true;
		makeSubset(idx+1);
		visited[idx] = false;
		makeSubset(idx+1);
	}
	
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N];
		B = new int[N];
		visited = new boolean[N];
		for(int i = 0 ; i < N ; i ++)
		{
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}

		makeSubset(0);
		System.out.println(min);
	}
}
