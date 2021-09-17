package algorithm.BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

	public class 치즈 {
		
	   static int n,m; 
	   static int[][] map , visit;
	   static int[] dx = {-1, 0, 1, 0},dy = {0, 1, 0, -1};
	   
	   public static void main(String[] args) throws IOException {
	      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st = new StringTokenizer(reader.readLine());
	      
	      n = Integer.parseInt(st.nextToken());
	      m = Integer.parseInt(st.nextToken());
	      
	      map = new int[n+1][m+1];
	      visit = new int[n+1][m+1];
	      
	      for (int i=1; i<=n; i++) {
	         st = new StringTokenizer(reader.readLine());
	         for (int j=1; j<=m; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	         }
	      }
	 
	      int result = 0;
	      while (true) {
	         visit = new int[n+1][m+1];
	         
	         boolean flag = false;
	         setAir(1,1);
	         
	         for (int i=1; i<=n; i++) {
	            for (int j=1; j<=m; j++) {
	               if (map[i][j] == 1) {
	                  if (dfs(i,j)) { 
	                     flag = true;
	                  }
	               }
	            }
	         }
	         
	         if (!flag) {
	            break;
	         }
	         
	         result++;
	      }
	      
	      System.out.println(result);
	      
	      
	   }

	   private static void setAir(int x, int y) {
	      map[x][y] = -1;
	      visit[x][y] = 1;
	      
	      for (int i=0; i<dx.length; i++) {
	         int nx = x + dx[i];
	         int ny = y + dy[i];
	         
	         if (nx < 1 || ny < 1 || nx > n || ny > m) {
	            continue;
	         }
	         
	         if (visit[nx][ny] == 0 && map[nx][ny] != 1) {
	            setAir(nx,ny);
	         }
	      }
	      
	   }

	   private static boolean dfs(int x, int y) {
	      
	      int cnt = 0;
	      for (int i=0; i<dx.length; i++) {
	         int nx = x + dx[i];
	         int ny = y + dy[i];
	         
	         if (nx < 1 || ny < 1 || nx > n || ny > m) {
	            continue;
	         }
	       
	         if (map[nx][ny] == -1) {
	            cnt++;
	         }
	         
	      }
	      if (cnt >= 2) {
	         map[x][y] = 0;
	         return true;
	      }
	      return false;
	      
	   }

	}