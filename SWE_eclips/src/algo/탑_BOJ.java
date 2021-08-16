package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_BOJ {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());	
		int[] tower = new int[N+1];
		
		Stack<int[]> st = new Stack<>();
		StringTokenizer s = new StringTokenizer(br.readLine());
		
		for(int i = 1 ; i <= N ; i ++)
		{
			tower[i] = Integer.parseInt(s.nextToken());
		}
		
		for(int i = 1;  i <= N ; i++)
		{
			while(!st.isEmpty())
			{
				if(st.peek()[0] >= tower[i])
				{
					System.out.print(st.peek()[1]+" ");
					break;
				}
				st.pop();
			}
			
			if(st.isEmpty())
			{
				System.out.print("0 ");
			}
			st.push(new int[] {tower[i],i});
		}
			
		
	}
}
