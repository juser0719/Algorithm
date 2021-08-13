package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class 골드바흐의_추측 {
	
	static boolean[] primeList;
	
	public static void aratosnes(int N)
	{
		primeList = new boolean[10001];
		primeList[0] = true;
		primeList[1] = true;
		
		for(int i = 2; i<=primeList.length/2; i++)
			if(primeList[i])
				for(int j = i*i; j< primeList.length; j+=i)
					primeList[j] = true;

		int l = N/2, r =N/2;
		while(true)
		{
			if(!primeList[l] && !primeList[r])
			{
				System.out.printf("%d = %d + %d", N,l,r);
				break;
			}
			l--;
			r++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(;;)
		{
			int N = sc.nextInt();
			if(N == 0)
				break;
			aratosnes(N);
		}
	}
}
