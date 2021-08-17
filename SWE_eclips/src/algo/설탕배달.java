package algo;

import java.util.Scanner;

public class 설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		for(int i =0; i <= N/5; i++)
		{
			int R = N - (i*5);
			if(R%3 == 0)
				min = Math.min(min, i + (R/3));	
		}
		if(min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}
}
