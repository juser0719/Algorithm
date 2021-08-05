package liveCoding;

import java.util.Scanner;

public class 부분집합2 {
	
	static int N , totalCnt , target; //원소 갯수 , 목표 합 
	static int[] input; // 들어오는 인풋 넘버들. 
	static boolean[] isSelected; // 포함 여부를 알 수 있는 배열. 
	
	private static void makeSubset(int idx)
	{
		if(idx == N)
		{
			int sum = 0;
			
			for(int i =0 ; i < N ; i++)
			{
				if(isSelected[i]) sum+= input[i];
			}
			if (sum == target)
			{
				totalCnt++;
				for (int i = 0; i < N; i++) 
				{
					if(isSelected[i]) System.out.print(input[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		
		//현재 원소를 부분집합에 넣기
		isSelected[idx] = true;
		makeSubset(idx+1);
		
		//현재 원소를 부분집합에 넣지 않기.
		isSelected[idx] = false;
		makeSubset(idx+1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) 
			input[i] = sc.nextInt();
		
		makeSubset(0);
		System.out.println("경우의 수 : " + totalCnt);
		
	}
}
