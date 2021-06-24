# 단순 dfs 문제 

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def dfs(y,x,team,cnt):
    if army[y][x] == '0':
        return cnt
    army[y][x] = '0'
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (0 <= ny < M) and (0 <= nx < N) and army[ny][nx] == team:
            cnt = dfs(ny,nx,team,cnt+1)
    return cnt
N , M = map(int,input().split())
army = [list(input()) for _ in range(M)]
res  = {'W' : 0 , 'B': 0 }
for i in range(M):
    for j in range(N):
        if army[i][j] == 'W':
            res['W'] += dfs(i,j,'W',1) ** 2
        elif army[i][j] == 'B':
            res['B'] += dfs(i,j,'B',1) ** 2
            
print(res['W'],res['B'])