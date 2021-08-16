package algo;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 로봇이동거리 {
	static int[][] map;
	static int[] dx = {1,-1,0,0}, dy = {0,0,-1,1}; // A = 1 , B = 2 , C = 4
	
	public static int move(int cnt,ArrayList<int[]> starts)
	{
		for(int i =  0 ; i < starts.size(); i++)
		{
			int[] robot = starts.get(i);
			
			for(int dir = 0; dir < robot[2]; dir++)
			{
				int y = robot[0];
				int x = robot[1];
				int N = map.length;
				while(true)
				{
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if(ny <0 || nx < 0 || N<=ny || N<=nx || map[ny][nx] != 0)
						break;
					cnt++;
					y = ny;
					x = nx;
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc<= T; tc++)
		{
			int N = sc.nextInt();
			map = new int[N][N];
			ArrayList<int []> arr = new ArrayList<int[]>();
			for(int i = 0 ; i < N ; i++)
				for(int j =0; j < N ; j++)
				{
					String val = sc.next();
					
					switch (val) {
					case "S":
						map[i][j] = 0;
						break;
					case "W":
						map[i][j] = 8;
						break;
					case "A":
						map[i][j] = 1;
						arr.add(new int[] {i,j,1});
						break;
					case "B":
						map[i][j] = 2;
						arr.add(new int[] {i,j,2});
						break;
					case "C":
						map[i][j] = 4;
						arr.add(new int[] {i,j,4});
						break;
					default:
						System.out.println(val);
					}
				}
			
			System.out.printf("#%d %d\n",tc,move(0,arr));
			
		}
	}
}
