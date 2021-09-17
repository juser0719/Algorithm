package algorithm.BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리_만들기2 {
	static int[][] map;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(sb.nextToken());
		M = Integer.parseInt(sb.nextToken());
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i ++)
		{
			sb = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++)
				map[i][j] =Integer.parseInt(sb.nextToken());
		}
			
		
		
	}
}
