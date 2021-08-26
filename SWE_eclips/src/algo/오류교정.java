package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오류교정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0 ; i < N ; i ++)
		{
			String[] str = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j ++)
				if(str[j].equals("0"))
					map[i][j] = 0;
				else
					map[i][j] = 1;
		}
		int[] parite = isParite(map);
//		System.out.println(parite[0] + " , "+ parite[1]);
		if(parite[0] == -1 && parite[1] == -1)
		{
			System.out.println("OK");
		}else
		{
			if(parite[0] != -1 && parite[1] != -1)
			{
				System.out.printf("Change bit (%d,%d)\n",parite[1]+1,parite[0]+1);
			}
			else System.out.println("Corrupt");
		}
	}
	
	public static int[] isParite(int[][] map)
	{
		int row_sum = -1;
		int col_sum = -1;
		int N = map.length;
		
		for(int d = 0 ; d <N ; d++)
		{
			int sum = 0;
			for(int j = 0 ; j < N;  j++) sum+= map[d][j];
			if(sum % 2!=0)
			{
				if(col_sum == -1)
					col_sum = d;
			}
			sum = 0;
			for(int i = 0 ; i < N; i++) sum+= map[i][d];
			if(sum %2 !=0)
			{
				if(row_sum == -1)
					row_sum = d;
			}
				
		}
		
		return new int[] {row_sum,col_sum};
	}
	
//	public static int[] Change(int[][] map, int[] cross)
//	{
//		
//	}
}
