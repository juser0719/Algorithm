import sys
sys.setrecursionlimit(10000)
dx = [0,0,-1,1]
dy = [1,-1,0,0]

def dfs (y,x,cnt) :
    if road[y][x] == 0:
        return cnt
    road[y][x] = 0

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if (0<= ny < N) and (0<= nx < M) and road[ny][nx] == 1:
            cnt = dfs(ny,nx,cnt+1)
    return cnt

N , M , K = map(int,input().split())
road=  [[0]*(M) for _ in range(N)]
res = 0
for _ in range(K):
    y,x = map(int,input().split())
    road[y-1][x-1] = 1

for i in range (N):
    for j in range(M):
        if road[i][j] == 1:
            res = max(dfs(i,j,1) , res)

print(res)