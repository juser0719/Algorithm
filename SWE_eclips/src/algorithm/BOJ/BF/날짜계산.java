package algorithm.BOJ.BF;

import java.util.Scanner;

public class 날짜계산 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt(); int S = sc.nextInt(); int M = sc.nextInt();
		int year = 1 , e,s,m;
		e =s =m =1;
		
		while(true)
		{
			if(E == e && S == s && M == m)
				break;
			e++; s++; m++;
			if(e == 16) e =1;
			if(s == 29) s =1;
			if(m == 20) m =1;
			
				
			year++;
		}
		System.out.println(year);
	}
}
