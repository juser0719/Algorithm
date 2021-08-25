package algo;

import java.util.*;
import java.io.*;
 
public class 아기상어 {
    static final int BABY_SHARK = 500;
    static int[][] sea;
    static int N, res, babySharkX, babySharkY, babyShark = 2, eaten;
    static boolean flag = false;
    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sea = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    babySharkX = j;
                    babySharkY = i;
                }
            }
        }
        while (!flag) {
            solve();
        }
       System.out.println(res);
    }
 
 
    public static void solve() {
        boolean[][] visited = new boolean[N + 2][N + 2];
        Queue<Shark> q = new LinkedList<>(); // 상어 위치 .
        PriorityQueue<Shark> pq = new PriorityQueue<>((Shark o1, Shark o2) -> { // 먹이 위치. 
            if (o1.d == o2.d) {
                if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
                return Integer.compare(o1.y, o2.y);
            }
            return Integer.compare(o1.d, o2.d);
        });
 
        q.offer(new Shark(babySharkY, babySharkX));
        
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int d = q.peek().d;
            q.poll();
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
 
                if (ny < 1 || ny > N || nx < 1 || nx > N) continue; // 범위 넘어감.
                if (babyShark < sea[ny][nx] || visited[ny][nx]) continue; // 물고기가 더 크거나 이미 들린곳.
 
                if (babyShark > sea[ny][nx] && sea[ny][nx] > 0) // 먹을 수 있음.
                    pq.offer(new Shark(ny, nx, d + 1)); 
                else // 지나갈 수 있음.
                    q.offer(new Shark(ny, nx, d + 1));
 
                visited[ny][nx] = true; // 방문 처리.
            }
        }
 
        if (pq.isEmpty()) flag = true; // 먹을게 없다면 멈춰.
        else { // 먹을 수 있다면.
            eaten++; // 냠.
            res += pq.peek().d; //가장 짧은 거리 더해줌.
 
            if (babyShark == eaten) { // 사이즈 키워주고 .
                babyShark++;
                eaten = 0;
            }
 
            sea[babySharkY][babySharkX] = -1; // 지금 위치 바꿔주고 
            babySharkX = pq.peek().x;
            babySharkY = pq.peek().y;
            sea[babySharkY][babySharkX] = BABY_SHARK; // 새로운 위치로 이동. 
        }
    }
 
    static class Shark {
        int x;
        int y;
        int d;
 
        public Shark(int y, int x, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
 
        public Shark(int y, int x) {
            this(y, x, 0);
        }
 
    }
}