from copy import deepcopy
from collections import deque
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
res = int(-1e9)


def spread(copy_map):
    q = deque()

    for i in range(N):
        for j in range(M):
            if copy_map[i][j] == 2:
                q.append([i, j])
    while q:
        vy, vx = q.popleft()

        for i in range(4):
            ny = vy + dy[i]
            nx = vx + dx[i]

            if 0 <= ny < N and 0 <= nx < M and copy_map[ny][nx] == 0:
                copy_map[ny][nx] = 2
                q.append([ny, nx])
    safe = 0

    for line in copy_map:
        safe += line.count(0)
    return safe


def select_wall(cnt):
    global res
    if cnt == 3:
        copy_map = deepcopy(board)
        res = max(res, spread(copy_map))
        return

    for i in range(N):
        for j in range(M):
            if board[i][j] == 0:
                board[i][j] = 1
                select_wall(cnt+1)
                board[i][j] = 0


N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
virus = []
wall = []
for i in range(N):
    for j in range(M):
        if board[i][j] == 2:
            virus.append([i, j])

select_wall(0)
print(res)
