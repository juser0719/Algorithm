package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <=10; tc++)
		{
			int T = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			int cnt = 1;
			
			for(int i = 0 ; i < 8 ; i ++)
				q.add(sc.nextInt());

			while(true)
			{
				int first = q.poll();
				if(first-cnt <= 0)
				{
					q.add(0);
					break;
				} else
				{
					q.add(first-cnt);
				}
				cnt %= 5;
				cnt ++;
			}
			
			System.out.printf("#%d ",T);
			for(int i = 0 ; i < 8 ; i ++)
			{
				int val = q.poll();
				System.out.printf("%d ",val);
			}
			System.out.println();
			
		}
		
	}
}
