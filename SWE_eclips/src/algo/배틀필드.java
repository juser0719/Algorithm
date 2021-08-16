package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 배틀필드 {
	// 0 :좌 , 1: 우 ,2:하, 3: 상
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int x;
	static int y;
	static char[] tank = {'<','>','v','^'};
	static int dir;
	static String map[][];
	static String orders[];
	
	private static void print_res(int Y, int X) {
		for(int i = 0 ; i < Y ; i++ )
		{
			for(int j = 0 ; j < X ; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
		
	}
	public static void shoot(int d,int s_y, int s_x)
	{
		int ny = dy[d] + s_y;
		int nx = dx[d] + s_x;
		int Y = map.length;
		int X = map[0].length;
		
		if(ny<0 || Y<=ny || nx<0 || X <=nx || map[ny][nx].equals("#"))
			return;
		if(map[ny][nx].equals("*"))
		{
			map[ny][nx] = ".";
			return;
		} else {
			shoot(d,ny,nx);
		}
		
		
		
	}
	
	public static void move(int d)
	{
		dir = d;
		map[y][x] = Character.toString(tank[d]);
		int ny = dy[d] + y;
		int nx = dx[d] + x;
		int Y = map.length;
		int X = map[0].length;
		
		if(ny<0 || Y<=ny || nx<0 || X <=nx  || !map[ny][nx].equals("."))
			return;
			
		map[y][x] = ".";
		map[ny][nx] = Character.toString(tank[d]);
		y = ny;
		x = nx;

		
	}
	
	public static void play(String order,int y, int x ) 
	{
		switch (order) 
		{
			case "S":
				shoot(dir,y,x);
				break;
				
			case "U":
				move(3);
				break;
				
			case "D":
				move(2);
				break;

			case "R":
				move(1);
				break;
				
			case "L":
				move(0);
				break;
				
			default:
				break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++)
		{
			StringTokenizer st =new StringTokenizer(br.readLine());
			int Y = Integer.parseInt(st.nextToken()) , X = Integer.parseInt(st.nextToken());
			
			map = new String[Y][X];
			for(int i = 0 ; i < Y; i++)
			{
			
				String s = br.readLine();
				for(int j = 0 ; j < X ; j++)
				{
					
					map[i][j] = Character.toString(s.charAt(j));
					if("<>v^".contains(map[i][j]))
					{
						y = i;
						x = j;
						dir = "<>v^".indexOf(map[i][j]);
					}
				
				}
			}
			
			int N =  Integer.parseInt(br.readLine());
			orders = new String[N];
			String s = br.readLine();
			for(int i = 0 ; i < N ; i++)
				orders[i] = Character.toString(s.charAt(i));
			
			//////input//////
			
			
			for(int i = 0 ; i < N ; i++)
				play(orders[i],y,x);
			
			System.out.printf("#%d ",tc);
			print_res(Y,X);
		}
	}


}
