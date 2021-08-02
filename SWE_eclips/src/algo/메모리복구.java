package algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class 메모리복구 {
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("메모리복구.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++)
		{
			char[] input = sc.next().toCharArray();
			int cnt = 0 ;
			char flg = '0';
			
			for(int i = 0; i < input.length; i++)
			{
				if(input[i] != flg)
				{
					cnt++;
					flg = input[i];
				}
			}
			
			System.out.printf("#%d %d\n",tc,cnt);
		}
	}
}
