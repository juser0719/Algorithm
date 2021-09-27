package algo;

import java.util.Scanner;

public class 이항계수1 {
	
	static int N,K;
	static int[][] map;
	
	public static void main(String[] args) {
		map = new int [11][11];
		map[0][0] = 1;
		for(int i = 1; i<11;i++) {
			map[i][0] = 1;
			map[i][i] = 1;
			for(int j = 1; j<i; j++)
				map[i][j] = map[i-1][j-1] + map[i-1][j];
		}
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int r = nCr(N,K);
		System.out.println(r);
		
	}

	private static int nCr(int n, int k) {
		
		return map[n][k];
	}
}
