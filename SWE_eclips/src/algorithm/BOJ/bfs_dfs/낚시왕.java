package algorithm.BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 낚시왕 {
	static int r,c,m,ans;
	static Shark[][] map,mmap;
	static boolean[][] check;
	static int[] dy = {0,-1, 1, 0, 0}; // 상하우좌
	static int[] dx = {0, 0, 0, 1,-1};
	static ArrayList<Shark> list = new ArrayList<Shark>();
	
	static class Shark implements Comparable<Shark>{
		int s,d,z,y,x;
		public Shark(int s, int d, int z, int y, int x) {
			this.s = s;
			this.d = d;
			this.z = z;
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Shark o) {
			return (this.z-o.z);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new Shark[r][c];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int ss = Integer.parseInt(st.nextToken());
			int dd = Integer.parseInt(st.nextToken());
			int zz = Integer.parseInt(st.nextToken());
			map[y][x] = new Shark(ss,dd,zz,y,x); // 상어 상태 입력
		}
		solution();		
		System.out.println(ans);
	}
	
	private static void solution() {
		for(int fisherman=0; fisherman<c; fisherman++) {
			for(int line=0; line<r; line++) {
				if(map[line][fisherman]!=null) {   // 1. 상어가 있으면 잡고
					ans += map[line][fisherman].z;
					map[line][fisherman] = null;   // 2. 상어 지우고
					break;
				}
			}
			allSharksMove();					   // 3. 남은 상어들 움직인다.
		}
	}
	
	private static void allSharksMove(){
		mmap = new Shark[r][c];
		for(int i=0; i<r; i++) 
			for(int j=0; j<c; j++) 
				if(map[i][j]!=null) 
					list.add(new Shark(map[i][j].s,map[i][j].d,map[i][j].z, i, j)); // 상어 한마리씩 더함
		
		Collections.sort(list);
		for(Shark s : list) {
			oneSharkMove(s,s.y,s.x);
		}
		list.clear();
		map = mmap;
	}
	
	private static void oneSharkMove(Shark old, int y, int x) {
		int spd = old.s;
		int dir = old.d;
		int spdY = spd%((r-1)*2);
		int spdX = spd%((c-1)*2);
		int ny = y;
		int nx = x;
		if(dir==1 || dir==2) {
			for(int i=0; i<spdY; i++) {
				ny += dy[dir];
				if(ny<0) {
					ny+=2;
					dir=2;
				}else if(ny>r-1) {
					ny-=2;
					dir=1;					
				}
			}
		}else {
			for(int i=0; i<spdX; i++) {
				nx += dx[dir];
				if(nx<0) {
					nx+=2;
					dir=3;
				}else if(nx>c-1) {
					nx-=2;
					dir=4;
				}
			}
		}
		mmap[ny][nx]= new Shark(spd,dir,old.z,ny,nx);

	}
	


}
