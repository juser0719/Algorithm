package liveCoding;

import java.util.Scanner;
//같은 행에 두지 않는 방식 
// N 개의 퀸을 위협적이지 않게 놓는모든 경우의 수 
public class NQueen {
	static int N,cnt ;
	static int col[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1]; //1열부터 시작.
		cnt =0;
		setQueens(1);
	}
	
	private static void setQueens(int rowNo) 
	{
//		if(!isPossible(rowNo-1)) return;
		//유망 여부 체크 : 직전 행까지 유망한지 체
		if(rowNo > N)
		{
			cnt++;
			return;
		}
		//1 열부터 N 열까지 놓아보고, 놓았으면 다음퀸 놓으러 가기.
		for(int i = 1 ; i <=N; i++)
		{
			col[rowNo] = i;
			if(isPossible(rowNo-1)) // 놓은게 유망하냐? 아니면 넘어감. 
				setQueens(rowNo+1);
		}
	}
	
	private static boolean isPossible (int rowNo)
	{
		for(int i = 1 ; i < rowNo; i++) //i 는 이전까지의 퀸들의 위치, rowNo는 현재 
		// 현재 놓은 퀸이 이전에 놓은 퀸들과 겹치지 않는지 체크. (유망성 체크)
		{
			if(col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == rowNo-i) return false; //행과 대각선에 있다면 멈춰줌.
			
		}
		return true;
	}
}
