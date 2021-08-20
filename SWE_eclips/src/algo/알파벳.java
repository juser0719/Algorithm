package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 알파벳 {
	static char[][] map;
	static int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};
	static int res = 1;
	static Set<Character> set = new HashSet<Character>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for(int i = 0 ; i < N ; i ++)
		{
			String s = br.readLine();
			for(int j = 0; j < M ; j++)
				map[i][j] = s.charAt(j);
		}
		set.add(map[0][0]);
		dfs(0,0,1);
		System.out.println(res);
	}
	
	public static void dfs(int y, int x , int cnt)
	{
		int N = map.length;
		int M = map[0].length;
		
		
		for(int i = 0 ; i < 4; i++)
		{
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny<0 || nx < 0 || N<= ny || M<= nx || set.contains(map[ny][nx]))
			{
				res = Math.max(res, cnt);
				continue;
			}
				
			set.add(map[ny][nx]);
			dfs(ny,nx,cnt+1);
			set.remove(map[ny][nx]);
		}
	}
}
