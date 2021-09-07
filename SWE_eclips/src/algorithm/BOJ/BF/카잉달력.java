package algorithm.BOJ.BF;

import java.util.Scanner;

public class 카잉달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int tc =1 ; tc <= T ; tc++)
		{
			int M = sc.nextInt(), N = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
			
			int cnt = x %(M+1); //처음x 를 마추기 위함.
			int temp_y = x;

			for(int i = 0 ; i < N ; i++) // N 번만큼하면 이미 마지막 해 이기 때문임.
			{
				int ty = temp_y % N;  // 지금 temp_y을 정해줌.
				if(ty == 0) ty = N;
				if(ty == y) break;
				temp_y = ty + M; //y 와 같지 않다면, M 번 사이클만큼 다시 돌아줌.
				cnt += M;
			}
		
			if(cnt > lcm(M,N))
				sb.append("-1\n");
			else sb.append(cnt+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int lcm(int a,int b) {
		int gcd = 0;
		int x = a;
		int y = b;
		while (y!=0) {
			int r = x%y;
			x = y;
			y = r;
		}
		gcd = x;
		return a*b / gcd;
	}
}
