from BOJ.감소하는수 import N


def dfs(x,y,dir):
    global res , N , M
    if x == N -1 and y == N -1:
        res += 1
        return
    if dir == 0 or dir == 2:
        if y+1 < N:
            if M[x][y+1] == 0:
                dfs(x,y+1,0)
    if dir == 1 or dir == 2:
        if x+1 < N:
            if M[x+1][y] == 0:
                dfs(x+1,y,1)
    if dir == 0 or dir == 1 or dir == 2:
        if x+1< N and y+1< N:
            if M[x+1][y] == 0 and M[x][y+1] ==0 and M[x+1][y+1] == 0:
                dfs(x+1,y+1,2)
            


N =  int(input())
M = [list(map(int,input().split())) for _ in range(N)]
res = 0
dfs(0,1,0)
print(res)