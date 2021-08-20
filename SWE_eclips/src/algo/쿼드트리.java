package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
	static int N,res;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N ; i++)
		{
			String row = br.readLine();
			for(int j = 0 ; j < N ; j++)
				map[i][j] = Character.getNumericValue(row.charAt(j));	
		}
		dfs(0,0,N);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int y,int x, int len)
	{
		if(quad(y,x,len))
		{
			sb.append(map[y][x]);
		}else
		{
			len = len/2;
			sb.append("(");
//			for(int i = y; i <= y+ len ; i+= len)
//				for(int j = x ; j <= x+ len; j+= len)
			dfs(y,x,len); dfs(y,x+len,len); dfs(y+len,x,len); dfs(y+len,x+len,len);
			sb.append(")");
		}
	}
	
	public static boolean quad(int y,int x , int len)
	{
		int temp = map[y][x];
		for(int i = y ; i < y+len; i++)
		{
			for(int j = x; j < x+len; j++)
			{
				int com = map[i][j];
				if(com != temp)
					return false;
			}
		}
		return true;
	}
}
