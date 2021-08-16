package algo;

import java.util.Scanner;

public class 규영이의카드게임 {
	
	static int[] A = new int [9],B = new int [9] , B_temp = new int[9];
	static boolean[] visited = new boolean [9];
	static int win,lose;
	
	public static boolean contain(int[] arr, int val)
	{
		for(int i = 0 ; i < arr.length; i++)
			if(arr[i] == val)
				return true;
		return false;
	}
	
	public static void permutation(int idx)
	{
		if(idx == 9) //9 번 수행
		{
			int A_sum = 0, B_sum = 0 ;
			for(int i = 0 ; i < 9 ; i++)
			{
				if(A[i] > B_temp[i])
					A_sum += A[i]+B_temp[i];
				else
					B_sum += A[i]+B_temp[i];
			}
			if(A_sum > B_sum)
				win+=1;
			else
				lose+=1;
			return;
		}
		
		for(int i = 0 ; i < 9 ; i++)
		{
			if(visited[i])
				continue;
			B_temp[idx] = B[i];
			visited[i] = true;
			permutation(idx+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =1; tc <= T ; tc++)
		{	
			win = 0 ; lose = 0;
			
			for(int i = 0 ; i < 9 ; i++)
				A[i] = sc.nextInt();
			
			int idx = 0;
			
			for(int i = 1 ; i <= 18; i++)
				if(!contain(A,i))
					B[idx++] = i;

					
			permutation(0);
			System.out.printf("#%d %d %d\n",tc,win,lose);
		}

	}
}
