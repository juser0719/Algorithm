package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스 {
	
	static int[] mans;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		mans = new int[N];
		
		int i  = 0;
		while(q.size() != N)
		{
			int cnt = 0;
			while(true)
			{
				i %= N;
				if(mans[i] == 0)
				{
					cnt++;
					if(cnt == K)
					{
						q.add(i+1);
						mans[i] = 1;
						break;
					}
				}
				i++;
			}
			//0,1,1,0,0,1,1 - > mans
			//0,1,2,3,4,5,6 
			//q -> 2 5 1 6 
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		for(int a=0;a<N;a++) {
			sb.append(q.poll()+", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
		
	}
}
