package algo;

import java.util.Scanner;

public class N퍼즐 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		char[][] map= new char[4][4];
		int res = 0 ;
		for(int i =0 ;i < 4; i++)
		{
			String str = sc.next();
			for(int j = 0 ; j < 4 ; j++)
			{
				map[i][j] = str.charAt(j);
				if(map[i][j] != '.')
				{
					System.out.printf("%d, %d\n",(map[i][j]-'A')/4,(map[i][j]-'A')%4);
					res += Math.abs(((map[i][j]-'A')/4)-i) + Math.abs(((map[i][j]-'A')%4)-j);
				}
			}
		}
		
		System.out.println(res);
				
	}
}
