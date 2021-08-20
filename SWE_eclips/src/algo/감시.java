package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class 감시 {
	static int[][] map;
	static int res = Integer.MAX_VALUE;
	static int[] dx = {1,-1,0,0} , dy = {0,0,-1,1};//우,좌,하,상 
	static ArrayList<int[]> arr = new ArrayList<int[]>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i ++)
			for(int j = 0 ; j < M; j++)
			{
				int num = sc.nextInt();
				if(num !=0 && num!= 6)
					arr.add(new int[] {i,j});
				map[i][j] = num;
			}
		combi(0,Copy(map));
		System.out.println(res);
	}
	
	public static void combi(int idx , int[][] copyMap)
	{
		if(idx == arr.size())
		{
			int all = getEmpty(copyMap);
//			System.out.println(all);
			res = Math.min(res,all);
			return;
		}
		
		for(int i = idx ; i < arr.size(); i++)
		{
			int y = arr.get(i)[0];
			int x = arr.get(i)[1];
			int type = map[y][x];// 1
			int type_rotate[] = {0,4,2,4,4,1};
			
			for(int rotate = 0 ; rotate < type_rotate[type] ; rotate++)
			{
				int[][] copy_map = Copy(copyMap);
				copy_map = simul(y,x,rotate,copy_map); // 1 , 2, 3, 4 , 5
//				print(copy_map);
				
				combi(idx+1,copy_map);
			}
		}
		
	}
	
	public static int[][] simul(int y, int x , int dir, int[][] copyMap)
	{
		int type = map[y][x];
		//우,좌,하,상 
		switch (type) {
		case 1: 
			int[] temp = new int[] {dir};
			copyMap = draw(y,x,temp,copyMap);
			break;
		case 2:
			if(dir == 0) copyMap = draw(y,x,new int[]{0,1},copyMap);//좌우
			else copyMap = draw(y,x,new int[]{2,3},copyMap);// 상하 
			break;
		case 3:
			if(dir == 0) copyMap = draw(y,x,new int[]{0,3},copyMap);
			else if(dir == 1) copyMap = draw(y,x,new int[]{0,4},copyMap);
			else if(dir == 2) copyMap = draw(y,x,new int[]{1,3},copyMap);
			else if(dir == 3) copyMap = draw(y,x,new int[]{1,4},copyMap);
			break;
		case 4:
			if(dir == 0) copyMap = draw(y,x,new int[]{0,1,3},copyMap);// ㅗ 
			else if(dir == 1) copyMap = draw(y,x,new int[]{0,2,3},copyMap);// ㅏ 
			else if(dir == 2) copyMap = draw(y,x,new int[]{0,1,2},copyMap);// ㅜ 
			else if(dir == 3) copyMap = draw(y,x,new int[]{1,2,3},copyMap);// ㅓ
			break;
		case 5:
			copyMap = draw(y,x,new int[]{0,1,2,3},copyMap);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}

		return copyMap;
	}
	
	public static int[][] draw(int y ,int x, int[] dirs,int [][] copyMap)
	{
		int N = copyMap.length;
		int M = copyMap[0].length;
		for(int i = 0 ; i < dirs.length ; i++)
		{
			int ny = y;
			int nx = x;
			int dir= dirs[i];
			while(true)
			{
				ny += dy[dir];
				nx += dx[dir];
				if(ny<0 || nx < 0|| N <= ny || M <= nx || copyMap[ny][nx] == 6)
					break;
				copyMap[ny][nx] = 8;
			}
		}
		
		return copyMap;
	}
	
	public static int[][] Copy(int[][] m)
	{
		int N = m.length;
		int M = m[0].length;
		int [][]res = new int[N][M];
		for(int i = 0 ; i < N ; i ++)
			for(int j = 0 ; j < M ; j++)
				res[i][j] = m[i][j];
		return res;
	}
	
	public static int getEmpty(int[][] m)
	{
		int cnt= 0 ;
		for(int i = 0 ; i < m.length; i++)
			for(int j = 0 ; j < m[0].length; j++)
				if(m[i][j] == 0)
					cnt++;
		return cnt;
	}

	public static void print(int [][] m)
	{
		for(int i = 0 ; i < m.length; i++)
		{
			for(int j =0 ; j < m[0].length; j++)
				System.out.printf("%d ",m[i][j]);
			System.out.println();
		}
		System.out.println();
	}
}
