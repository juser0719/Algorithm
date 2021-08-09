package algo;
import java.util.Scanner;

public class 햄버거다이어트 {
	
	static int[] Cals , Taste;
	static int max_cal =0 , max_t = 0;
	
	public static void combi (int idx ,  int sum_t , int sum_c)
	{
		int N = Cals.length;
		if(sum_c > max_cal) return;
		if(idx == N)
		{
			if(sum_t > max_t)
				max_t = sum_t;
			return;
		}
		
		combi(idx+1,sum_t + Taste[idx], sum_c + Cals[idx]); // 선택했을때
		combi(idx+1,sum_t,sum_c); // 선택 안했을
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc= 1; tc<= T;  tc++)
		{
			int N = sc.nextInt();
			max_cal = sc.nextInt();
			
			Cals = new int [N];
			Taste = new int[N];
			
			for(int i = 0  ; i < N ; i ++)
			{
				int taste = sc.nextInt();
				int	cal = sc.nextInt();
				Taste[i] = taste;
				Cals[i] = cal;
			}
			
			max_t = 0;
			
			combi(0,0,0);
			
			System.out.printf("#%d %d\n",tc,max_t);
		}
	}
}
