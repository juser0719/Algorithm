"""
(보드 , 규칙 , 총 경우의 수)

N×N 게임판에 수가 적혀져 있다. 

이 게임의 목표는 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 점프를 해서 가는 것이다.

한 번 점프를 할 때, 방향을 바꾸면 안 된다. 즉, 한 칸에서 오른쪽으로 점프를 하거나, 아래로 점프를 하는 두 경우만 존재한다.

가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수를 구하는 프로그램을 작성하시오.
"""

N = int(input())
board =[list(map(int,input().split())) for _ in range(N)]
dp    =[[0]*N for _ in range(N)]
# dp[i][j] = (i,j) 에 방문할 수 있는 모든 경우.
dp[0][0] = 1
# 시작은 1번뿐.

for i in range(N):
    for j in range(N):
        if i == N-1 and j == N-1:
            break
        down = i + board[i][j]
        right= j + board[i][j]

        if down < N:
            dp[down][j] += dp[i][j]
        if right < N:
            dp[i][right]+= dp[i][j]

print(dp[N-1][N-1])