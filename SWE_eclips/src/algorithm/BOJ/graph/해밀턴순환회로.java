package algorithm.BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 해밀턴순환회로 {
	static int N, answer = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N  = Integer.parseInt(br.readLine());
		map= new int [N][N];
		visit = new boolean [N];
		
		for(int i = 0; i <N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < N ; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		visit[0] = true;
		// 직장이니까 미리 체크.
		permutation(0,1,0);
		System.out.println(answer);
	}

	private static void permutation(int now, int idx, int sum) {
		if(idx == N)
		{
			if(map[now][0] == 0)
			// 마지막에서 0 번째 노드로 돌아갈 수 없다면 리턴.
			return;
			
			sum += map[now][0];
			// 갈 수 있으면 더해줌.
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i = 1; i < N ; i++)
		{
			if(visit[i] == false && map[now][i] != 0 && sum+map[now][i] < answer)
			// 아직 노드를 방문하지 않았고 now에서 i 노드로 갈 수 있으며, 그 값이 answer 보다 작다면.
			{
				visit[i] = true;
				// 방문 
				permutation(i, idx+1, sum+map[now][i]);
				visit[i] = false;
				// 미방문 처리.
			}
		}
		
	}
}
