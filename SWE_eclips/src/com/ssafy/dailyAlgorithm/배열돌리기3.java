package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기3 
{
	static int N,M,R;
	static int[][] map;
	
	public static void up_down()
	{
		for(int j = 0 ; j < M ; j++)
		{
			for(int i = 0 , ii = N-1; i < ii ; i++,ii--)
			{
				int temp  = map[i][j];
				map[i][j] = map[ii][j];
				map[ii][j] =temp;
			}
		}
	}
	
	public static void left_right()
	{
		for(int i =0 ; i < N ; i ++)
		{
			for(int j = 0 , jj = M-1; j < jj; j++,jj--)
			{
				int temp = map[i][j];
				map[i][j] = map[i][jj];
				map[i][jj]= temp;
			}
		}
	}
	
	public static void right_90()
	{
		int[][] temp = new int[M][N];
		
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < M ; j++)
				temp[j][N-1-i] = map[i][j];
		}
		map = temp;
	}
	
	public static void left_90()
	{
		int[][] temp = new int[M][N];
		for(int i = 0 ; i <M ; i++)
		{
			for(int j = 0; j <N ; j ++)
				temp[i][j] =map[j][M -1- i];
		}
		map = temp;
	}
	
	public static void move1()
	{
		N = map.length;
		M = map[0].length;
		int[][] temp = new int[N][M];
		
		for(int i =0 ; i < N/2; i++)
			for(int j = 0 ; j < M/2; j++)
				temp[i][j+M/2] = map[i][j];
		
		for(int i =0; i < N/2; i++)
			for(int j = M/2; j < M ; j++)
				temp[i+N/2][j] = map[i][j];
		
		for(int i =N/2; i<N; i++)
			for(int j = M/2; j < M; j++)
				temp[i][j - M/2] = map[i][j];
		
		for(int i = N/2 ; i < N; i++)
			for(int j = 0; j<M/2; j++)
				temp[i-N/2][j] = map[i][j];
		map = temp;
	}
	
	public static void move2()
	{
		int[][] temp = new int[N][M];
		
		for(int i = 0 ; i < N / 2 ; i++) 
			for(int j = 0 ; j < M / 2 ; j++) 
				temp[i + N / 2][j] = map[i][j];

		for(int i = N / 2 ; i < N ; i++) 
			for(int j = 0 ; j < M / 2 ; j++) 
				temp[i][j + M / 2] = map[i][j];

		for(int i = N / 2 ; i < N ; i++)
			for(int j = M / 2 ; j < M ; j++) 
				temp[i - N / 2][j] = map[i][j];
		
		for(int i = 0 ; i < N / 2 ; i++) 
			for(int j = M / 2 ; j < M ; j++) 
				temp[i][j - M / 2] = map[i][j];
				map = temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());;
		
		map = new int[N][M];
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < R ; i++)
		{
			int cmd = Integer.parseInt(st.nextToken());
			N = map.length;
			M = map[0].length;
			switch (cmd) {
			case 1:
				up_down();
				break;
			case 2:
				left_right();
				break;
			case 3:
				right_90();
				break;
			case 4:
				left_90();
				break;
			case 5:
				move1();
				break;
			case 6:
				move2();
				break;
			}
		}
		
		for(int i = 0 ; i < map.length ; i ++)
		{
			for(int j = 0 ; j <map[0].length ; j++)
				System.out.printf("%d ",map[i][j]);
			System.out.println();
		}
	}
}
