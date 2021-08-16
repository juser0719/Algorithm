package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class 배열돌리기4 {
	static int[][] map;
	static int N,M,K;
	static int[] nx = {1,0,-1,0}, ny = {0,1,0,-1};
	static ArrayList<int[]> arr = new ArrayList<int[]>();
	
	public static void rotate(int[][] copy_map,int r, int c , int s)
	{
		int R = Math.min(r-s, c-s)/2;
	}
	
	public static void permutation(int idx, int k) {
        if(idx == k) {
            int[][] copy = new int[N][M];
            int[] c  = arr.get(idx);
            rotate(copy,c[0],c[1],c[2]);
            return;
        }
        
//        for(int i = 0; i < k; i++) {
//            if(visited[i] == false) {
//                visited[i] = true;
//                result[idx] = i;
//                permutation(idx + 1, k);
//                visited[i] = false;
//            }
//        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M = sc.nextInt(); K = sc.nextInt();
		map = new int[N][M];
		for(int i=0 ; i < N ; i ++)
			for(int j = 0 ; j<M ; j++)
				map[i][j] = sc.nextInt();
		for(int k=0; k < K; k++)
		{
			int r = sc.nextInt(); int c = sc.nextInt(); int s = sc.nextInt();
			arr.add(new int[] {r,c,s});
		}
		
		
	}
}
