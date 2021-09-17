package algorithm.BOJ.dp;

import java.util.Scanner;

public class RBG거리 {
	static int N;
	static int[][] map,dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][3];
		dp  = new int[N+1][3];
		for(int i = 1 ; i <= N; i++) 
			for(int j = 0 ; j < 3; j++) 
				map[i][j] = sc.nextInt();
		for(int i = 1; i<= N ; i++)
		{
			dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + map[i][0];
			dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + map[i][1];
			dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + map[i][2];
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
	}
}
