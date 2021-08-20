package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import algo.무선충전.BC;

/*
 * 
5
20 3
2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3
4 4 1 100
7 10 3 40
6 3 2 70
…

// 총 테스트 케이스 개수 T=5
// 첫 번째 테스트 케이스: 이동시간 M=20,BC의 갯수 A=3
// 사용자A의 이동 정보
// 사용자B의 이동 정보
// AP 1의 정보 (4, 4), C1=1, P1=100
// AP 2의 정보 (7, 10), C2=3, P2=40
// AP 3의 정보 (6, 3), C3=2, P3=70


 * */


public class 무선충전 {
	public static class BC
	{
		private int Id;
		private int Y;
		private int X;
		private int C;
		private int P;
		
		public BC(int id,int y, int x, int c, int p) {
			super();
			Id= id;
			Y = y;
			X = x;
			C = c;
			P = p;
		}

		public boolean isIn(int y, int x)
		{
			if(Math.abs(X-x) + Math.abs(Y-y) <= C)
				return true; 
			return false;
		}	
	}
	
	static int[] dx = {0,0,1,0,-1} , dy = {0,-1,0,1,0};
	public static void main(String[] args) throws IOException {
		Scanner sc =new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc =1; tc <= TC ; tc++)
		{
			int T = sc.nextInt(); // 이동시간
			int BCs = sc.nextInt(); // BC 갯수 
			BC[] bc = new BC[BCs];
			int [] A = new int[T] , B = new int[T];
			
			for(int i = 0 ; i < T ; i++)
				A[i] = sc.nextInt();
			for(int i = 0 ; i < T ; i++)
				B[i] = sc.nextInt();
			for(int i = 0 ; i < BCs; i++)
			{
				int y = sc.nextInt(), x= sc.nextInt() , c =sc.nextInt(), p =sc.nextInt();
				bc[i] = new BC(i,y, x, c, p);
			}
			//////////input//////////
			
			int[] A_pos = {0,0};
			int[] B_pos = {9,9};
			
			for(int t = 0 ; t < T; t++)
			{
//				int 
//				A_pos = move(A_pos,A[t]);
//				B_pos = move(B_pos,B[t]);
				Queue<Integer> q = new LinkedList<>();
				for(int i = 0 ; i < BCs ; i++)
				{
					
					if(bc[i].isIn(A_pos[0], A_pos[1]) && bc[i].isIn(B_pos[0], B_pos[1])) // 안에 둘다 있다면.
					{
						
					}
				}
			}
			 
		}
	}
}
