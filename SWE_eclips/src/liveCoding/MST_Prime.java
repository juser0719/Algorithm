package liveCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MST_Prime {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int [N][N];	
		boolean[] visited = new boolean[N];
		int[] minEdge     = new int [N];
		
		StringTokenizer st = null;
		for(int i = 0 ; i < N ; i ++)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < N ; j ++)
			{
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;		
		}
		int res =0 ; // 최소신장트리 비용.
		minEdge[0] = 0; // 임의의 시작점 0의 간선비용을 0으로 세팅.
		
		for(int i =0; i < N ; i ++)
		{
			int min = Integer.MAX_VALUE;
			int minVertax = -1; // 최소 간선비용의 정점번호.
			//1. 신장트리에 포함되지 않은 정점중에 최소간선 비용의 정점 찾기.
			for(int j = 0 ; j < N ; j ++)
			{
				if(!visited[j] && min > minEdge[j])
				{
					min = minEdge[j];
					minVertax = j;
				}
			}
			
			visited[minVertax] = true; // 신장트리에 포함시킴.
			res += min; // 간선 비용 누적.
			
			//2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선비용 최소로 업데이트.
			
			for(int j = 0 ; j < N ; j++)
			{
				if(!visited[j] && adjMatrix[minVertax][j] !=0 &&minEdge[j] > adjMatrix[minVertax][j])
					minEdge[j] = adjMatrix[minVertax][j];
					
			}
		}
	}
}
