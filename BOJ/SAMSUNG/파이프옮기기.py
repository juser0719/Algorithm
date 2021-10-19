# 꼭 빈 칸이어야 하는 곳은 색으로 표시되어져 있다.
dx = [1, 1, 0]
dy = [0, 1, 1]
cnt = 0
N = int(input())
board = [map(int, input().split()) for _ in range(N)]
visit = [[False] * N for _ in range(N)]


def ckRow(y, x, visit):
    if not (0 <= x+1 < N and 0 <= y < N and not visit[y][x+1]):
        return False
    return True


def ckCol(y, x, visit):
    if not (0 <= x < N and 0 <= y+1 < N and not visit[y+1][x]):
        return False
    return True


def ckDir(y, x, visit):
    for i in range(3):
        ny = y + dy[i]
        nx = x + dx[i]
        if not (0 <= nx < N and 0 <= ny < N and not visit[ny][nx]):
            return False
    return True


def dfs(y, x, type, visit):
    global cnt

    if y == N-1 and x == N-1:
        cnt += 1
        return

    if y == N or x == N:
        return

    visit[y][x] = True

    if type == 0:
        # 가로
        if ckRow(y, x, visit):
            dfs(y, x+1, 0, visit)
        if ckDir(y, x, visit):
            for i in range(3):
                ny = y+dy[i]
                nx = x+dx[i]
                dfs(ny, nx, i, visit)
    elif type == 1:
        if ckCol(y, x, visit):
            dfs(y+1, x, 1, visit)

    if ckDir(y, x, visit):
        for i in range(3):
            ny = y+dy[i]
            nx = x+dx[i]
            dfs(ny, nx, i, visit)


for type in [0, 1, 2]:
    # 가로 , 세로 , 대각선.
    visit = [[False] * N for _ in range(N)]
    dfs(0, 0, type, visit)

print(cnt)
