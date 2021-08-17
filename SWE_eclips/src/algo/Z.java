package algo;

import java.util.Scanner;

public class Z {
	static int N,R,C,res;
	static int[] dx= {0,1,0,1},dy= {0,0,1,1}; // Z 모양 탐색 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); R = sc.nextInt(); C = sc.nextInt();
		N = (int) Math.pow(2, N);
		
		div_area(0,0,N);
	}
	
	public static void div_area(int y,int x, int len)
	{
		if(len == 2)
		{
			for(int i = 0 ; i < 4; i++)
			{
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny == R && nx == C)
				{

					System.out.println(res);
					System.exit(0);
					return;
				}
				res++;
			}
			return;
		}
		
		for(int i = y; i < y+len; i+=len/2)
		{
			for(int j = x; j< x+len; j+= len/2)
			{
				if(i+len/2 -1 < R || j+len/2-1 < C)
				{
					res+= Math.pow(len/2, 2);
					continue;
				}
				div_area(i,j,len/2);
			}
		}
	}
}
