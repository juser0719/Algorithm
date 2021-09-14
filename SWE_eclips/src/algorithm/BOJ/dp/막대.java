package algorithm.BOJ.dp;

import java.util.Scanner;

public class 막대 {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		dp = new int [target+1];
		dp[1] = 2;
		dp[2] = 5;
		
		for(int i = 3; i<=target ; i++) {
			dp[i] = dp[i-1]*2 + dp[i-2];
		}
		
		System.out.println(dp[target]);
		
	}
}
