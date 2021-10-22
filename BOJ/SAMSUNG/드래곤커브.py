"""
끝 점이란 시작 점에서 선분을 타고 이동했을 때, 가장 먼 거리에 있는 점을 의미
"""
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]
# 동,남,서,북


def make_dragon(y, x, d, gen):
    board[y][x] = 1
    dirs = [d]

    for _ in range(gen):
        next_dir = []

        for i in range(len(dirs)):
            next_dir.append((dirs[i]+1) % 4)

        dirs.extend(list(reversed(next_dir)))
    # print(dirs)
    for i in dirs:
        ny = y + dy[i]
        nx = x + dx[i]
        # board[ny][nx] = 1
        # y, x = ny, nx
        if 0 <= ny <= 100 and 0 <= nx <= 100:
            board[ny][nx] = 1
            y, x = ny, nx


N = int(input())
board = [[0]*101 for _ in range(101)]

for _ in range(1, N+1):
    x, y, d, gen = map(int, input().split())
    make_dragon(y, x, d, gen)

res = 0

for i in range(100):
    for j in range(100):
        if board[i][j]:
            if board[i+1][j] and board[i][j+1] and board[i+1][j+1]:
                res += 1
print(res)
