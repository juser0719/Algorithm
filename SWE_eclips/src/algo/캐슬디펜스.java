package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 캐슬디펜스 {
	static int N,M,D,res = Integer.MIN_VALUE;
	static int[][] map;
	
	static int[][] monster_move(int[][] m , ArrayList<int []> monster)
	{
		for(int i = 0 ; i < monster.size() ; i++)
		{
			int m_y = monster.get(i)[0];
			int m_x = monster.get(i)[1];
			if(m[m_y][m_x] == 1)
			{
				if(m_y+1 < N)
					m[m_y+1][m_x] = 1;
				
				m[m_y][m_x] = 0;
			}
		}
		return m;
	}
	
	static void attack()
	{
		int kill = 0;
		int[][] copy_map = new int[N+1][M];
		int move = 0;
		
		for(int i = 0 ; i <= N ; i++)
			for(int j = 0 ;  j < M ; j++)
				copy_map[i][j] = map[i][j];
		
		while(move < N)
		{
			ArrayList<int []> monster = new ArrayList<int[]>();
			ArrayList<int []> archer  = new ArrayList<int[]>();
			
			for(int i = 0 ; i <= N ;  i++)
				for(int j =0; j < M ; j++)
				{
					if(copy_map[i][j] == 1)
						{
							System.out.printf("monster :%d , %d\n",i,j);
							monster.add(new int[] {i,j});
						}
					else if(copy_map[i][j] == 2)
						{System.out.printf("archer :%d , %d\n",i,j);
						archer.add(new int[] {i,j});
						}
				}
			
			for(int i = 0 ; i < 3; i++)
			{
				int ac_y = archer.get(i)[0];
				int ac_x = archer.get(i)[1];
				PriorityQueue<int[]> shoot = new PriorityQueue<int[]>((o1,o2) ->{ if(o1[2] == o2[2]) return o1[1] - o2[1];
					return o1[2] - o2[2];
				});
				
				for(int j = 0 ; j < monster.size();  j ++)
				{
					int mon_y = monster.get(j)[0];
					int mon_x = monster.get(j)[1];
					int dis   = Math.abs(ac_x- mon_x) + Math.abs(ac_y - mon_y);
					shoot.add(new int[] {mon_y,mon_x,dis});
				}
				
				while(kill == 3) // 죽임. 
				{
					int[] kill_chk = shoot.poll();
					System.out.println(kill_chk.toString());
					if(kill_chk[2] <= D)
						if(copy_map[kill_chk[0]][kill_chk[1]] == 1) // 몬스터 있다면.
						{
							copy_map[kill_chk[0]][kill_chk[1]] = 0;
							kill++;
						}
				}
				
				res = Math.max(res, kill);
			}
			move++;

			copy_map= monster_move(copy_map,monster);
		}

		
	}
	
	

	static void set_position(int cnt , int idx)
	{
		if(cnt == 3)
		{
			attack();
			return;
		}
		for(int i  = idx ; i <M; i++)
		{
			map[N][i] = 2;
			set_position(cnt+1,i+1);
			map[N][i] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken()); //공격 거리 제한. 
		map = new int[N+1][M];
		
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j <M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		set_position(0,0);
		
		System.out.println(res);
		
		
	}
}
