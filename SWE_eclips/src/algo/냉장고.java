package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 냉장고 {
	static ArrayList<int[]> arr = new ArrayList<int[]>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i ++)
		{
			int low = sc.nextInt();
			int high= sc.nextInt();
			arr.add(new int[] {low,high});
		}
		
		Collections.sort(arr, (a,b)->{return a[1]- b[1];});
		
		int cnt = 1;
		int now = arr.get(0)[1];
		System.out.println(arr.toArray());
		for(int i = 0 ; i < arr.size(); i++)
		{
			if(now < arr.get(i)[0])
			{
				cnt++;
				now = arr.get(i)[1];
			}
		}
		System.out.println(cnt);
	}
}
