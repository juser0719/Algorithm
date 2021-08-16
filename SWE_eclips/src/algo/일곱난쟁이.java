package algo;

import java.util.Scanner;

public class 일곱난쟁이 {
	static int[] nums = new int[9], temp = new int[7], res;
	static void combination(int idx, int start)
	{
		if(idx == 7)
		{
			int total_sum=0;
			
			for(int i = 0; i < 7 ; i++)
				total_sum += temp[i];
			if(total_sum == 100)
				for(int i = 0 ; i < 7 ; i++)
					System.out.println(temp[i]);
			return;
		}
		
		for(int i = start ; i < 9 ; i++)
		{
			temp[idx] = nums[i];
			combination(idx+1, i+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i  < 9 ; i ++)
			nums[i] = sc.nextInt();
		combination(0,0);
	}
}
