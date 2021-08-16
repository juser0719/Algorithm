package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 정사각형방 {
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int room[][] = new int[n][n];
			int tmp = 0; 
			int cnt = 0; 
			int maxCnt = 0;  
			int max = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					room[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < n ; i++) {
				for(int j = 0; j < n; j++) {
					cnt = 0;
					boolean flag = true;
					tmp = room[i][j];
					
					int si = i;
					int sj = j;
					
					d: while(flag) {
				
						c: for(int k = 0; k < 4; k++) {
							int di = si + dx[k];
							int dj = sj + dy[k];
							
							if(dj < 0 || di < 0 || dj >= n || di >= n) {
								if(k == 3) {
									flag = false;
									break d;
								}
								continue c; 
							}
					
							if(room[di][dj] == room[si][sj] + 1) {
								si = di;
								sj = dj;
								cnt++;
								break c;
							}
							
							if(k == 3) {
								flag = false;
								break d;
							}
							
						}
					}
					
					if(maxCnt > cnt) {
						continue;
					}
					else if (maxCnt < cnt) {
						maxCnt = cnt;
						max = tmp;
					}
					else {
						if(max > tmp) max = tmp;
					}
					
				}
			}

			System.out.print("#" + t + " " + max + " ");
			System.out.println(maxCnt + 1);
		}
    }
}
