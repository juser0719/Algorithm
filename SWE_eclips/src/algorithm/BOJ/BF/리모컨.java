package algorithm.BOJ.BF;

import java.util.Scanner;

public class 리모컨 {
	static int res;
	static int[] numbers = new int[10];
	
	public static int Direct(int ch)
	{
		int cnt = 0; 
		String target = Integer.toString(ch);
		for(int i = 0; i < target.length(); i++)
		{	
			int idx = Character.getNumericValue(target.charAt(i)); 
			if(numbers[idx]== 1) // 못누름.
				return 0;
			else 
				cnt++;
		}
		return cnt; 
	}
	
	public static int solve(int N)
	{
		if(N == 100)
			return 0;
		
		int up = N , down = N;
		int u_cnt =0, d_cnt= 0 , up_down_cnt =0; 
		
		while(up != 100 && down != 100) //내리다가 둘중 하나라도 100이라면 + - direct로 바로 갈 수 있는 채널이 나오지 않았다는 뜻이기 때문에 +-한횟수 return. 
		{

			if(down >= 0)
			{
				d_cnt = Direct(down--); 
				if(d_cnt != 0)
					return Math.min(Math.abs(N - 100), up_down_cnt+d_cnt); 
			}
			
			u_cnt = Direct(up++); 
			if(u_cnt != 0)
				return Math.min(Math.abs(N-100), up_down_cnt+u_cnt);
			
			up_down_cnt++;
		}
		
		return up_down_cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for(int i = 0 ; i < M ; i++)
		{
			int idx = sc.nextInt();
			numbers[idx] = 1; // broken
		}
		
		res = solve(N);
		
		System.out.println(res);
		
	}
}
