package algorithm.BOJ.graph;

import java.util.Scanner;

public class 키_순서 {
	static int[][] student;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		int max;
		for(int tc = 1; tc<= T; tc++) 
		{
			int res= 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			student = new int [N][N];
			max = N *(N * (N-1)/2);			
			for(int i = 0; i < N ; i++)
				for(int j = 0 ; j <N; j++)
					student[i][j] = max;
			for(int i = 0 ; i < M; i++)
			{
				int from = sc.nextInt()-1;
				int to   = sc.nextInt()-1;
				student[from][to] = 1;
			}
			
			for(int k = 0; k < N; k++)
				for(int i = 0; i < N; i++)
					for(int j = 0 ; j < N; j++)
						if(student[i][j]> student[i][k]+ student[k][j])
							student[i][j] = student[i][k]+ student[k][j];
			
			for(int i = 0; i < N ; i++)
			{
				int cnt = 0;
				for(int j = 0 ; j < N ; j++)
					if(student[i][j] < max || student[j][i] < max) cnt++;
				if (cnt == N-1) res++;
			}
			
			sb.append("#"+tc+" "+res+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
