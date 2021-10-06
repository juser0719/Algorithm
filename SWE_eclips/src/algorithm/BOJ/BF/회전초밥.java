package algorithm.BOJ.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class 회전초밥 {
	static int N, d, k , c;// 접시수 , 초밥 가짓수, 연속 먹는 수 ,쿠폰 번호.
	static int[] arr,eat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		eat = new int[d+1]; //초밥 갯수들.
		arr = new int[N]; // 놓여있는 초밥들.
		
		for(int i =0 ; i < N ; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int res =getMax();
		System.out.println(res);
	}
	private static int getMax() {
		int cnt =0 , max =0;
		
		for(int i =0 ; i < k ; k++)
		{
			if(eat[arr[i]] == 0) cnt ++;
			eat[arr[i]]++;
		}
		max = cnt;
		
		for(int i =1; i < N; i++)
		{
			if(max <= cnt)
			{
				if(eat[c] == 0)
					cnt++;
				else 
					max = cnt;
			}
			
			eat[arr[i-1]]--;
			if(eat[arr[i-1]] == 0) cnt--;
			if(eat[arr[(i+k-1)%N]] == 0) cnt++;
			
			eat[arr[(i+k-1)%N]]++;
			
			
		}
		
		return max;
	}
}
