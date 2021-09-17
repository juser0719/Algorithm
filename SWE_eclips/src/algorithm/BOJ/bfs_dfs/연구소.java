package algorithm.BOJ.bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소 {
	static int N,M , res = Integer.MIN_VALUE;
	static int[][] map, copy;
	static int[] dx= {0,0,-1,1} , dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		copy= new int[N][M];
		for(int i = 0; i < N; i++)
			for(int j = 0; j< M; j++)
			{
				map[i][j] = sc.nextInt();
				copy[i][j]= map[i][j];
			}
		
		makeWall(0);
		System.out.println(res);
		
	}
	private static void makeWall(int cnt) {
		if(cnt == 3) {
			spreadVirus();
			countZero();
			return;
		}
		
		for(int i =0 ; i<N;i++) {
			for(int j = 0 ; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
		
	}
	private static void countZero() {
		int cnt = 0;
		for(int i =0 ; i < N ; i++)
			for(int j = 0 ; j < M ; j++)
				if(copy[i][j] == 0)
					cnt++;
		res = Math.max(cnt, res);
	}
	private static void spreadVirus() {
		Queue<int[]> virus = new LinkedList<int[]>();
		for(int i = 0 ; i < N ; i ++)
			for(int j = 0 ; j <M ; j++)
			{
				copy[i][j] = map[i][j];
				if(map[i][j] == 2)
					virus.add(new int[] {i,j});
			}
		while(!virus.isEmpty()) {
			int y = virus.peek()[0];
			int x = virus.peek()[1];
			virus.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny<0 || nx <0 || ny>=N || nx >=M) continue;
				if(copy[ny][nx] == 0) 
				{
					copy[ny][nx] = 2;
					virus.add(new int[] {ny,nx});
				}
			}
		}
	}
}
