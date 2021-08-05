package liveCoding;

import java.util.Scanner;

public class 조합테스트 {
	
	static int N , numbers[], totalCnt = 0;
	static boolean[] isSelected;
	
	private static void dice1(int idx) {
		if(idx == N)
		{
			totalCnt++;
			return;
		}
		for(int i = 0 ; i < N; i ++)
		{
			numbers[idx] = i;
			dice1(idx+1);
				
		}
	}
	private static void dice2(int idx) {}
	private static void dice3(int idx, int start) {}
	private static void dice4(int idx, int start) {}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 주사위 던진 횟수.
		numbers = new int[N];
		
		int M = sc.nextInt();
		
		switch (M) {
		
		case 1: // 중복 순열 
			dice1(0);
			break;
		
		case 2: // 순열 
			isSelected = new boolean[7];
			dice2(0);
			break;
		
		case 3: // 중복 조합 
			dice3(0,1);
			break;
			
		case 4: // 조합 
			dice4(0,1);
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + M);
		}
		
		System.out.println("경우의 수 : " +totalCnt);
	}
}
