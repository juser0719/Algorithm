package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농작물수확 {
	
	static int map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc ++)
		{
			int res = 0;
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int mid  = (N-1)/2;
			int row_cnt = 0;
			
			for(int i = 0 ; i < N ; i ++)
			{
				String s = br.readLine();
				
				for(int j = 0 ; j < N ; j++)
					map[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
				
				res += map[i][mid];
				for(int side = 1 ; side <= row_cnt; side++)
					res += map[i][mid-side] + map[i][mid+side];
				
				if(i < mid)
					row_cnt++;
				else
					row_cnt--;
			}
			
			System.out.printf("#%d %d\n",tc,res);
		}
		
	}
}
