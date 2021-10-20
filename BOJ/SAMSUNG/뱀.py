from collections import deque

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]


def change_dir(d, C):
    if C == 'L':
        d = (d-1) % 4
    else:
        d = (d+1) % 4
    return d


def start():
    dir = 1  # 초기는 우
    time = 1
    y, x = 1, 1
    snake = deque([[y, x]])
    board[y][x] = 2

    while True:
        # 먼저 머리를 다음 칸에 위치시킴.
        ny = y + dy[dir]
        nx = x + dx[dir]
        if 0 < ny <= N and 0 < nx <= N and board[ny][nx] != 2:
            # 다음갈 좌표 체크
            if not board[ny][nx] == 1:
                # 다음 갈 좌표에 사과가 없다면.
                tail_y, tail_x = snake.popleft()
                board[tail_y][tail_x] = 0
                # 꼬리칸 제거.

            board[ny][nx] = 2
            # 다음 갈거니까.
            snake.append([ny, nx])

            if time in times.keys():
                dir = change_dir(dir, times[time])

            time += 1
            y = ny
            x = nx
        else:
            return time


N = int(input())
K = int(input())
board = [[0]*(N+1) for _ in range(N+1)]

for _ in range(K):
    y, x = map(int, input().split())
    board[y][x] = 1

L = int(input())
times = {}

for _ in range(L):
    X, C = input().split()
    times[int(X)] = C

print(start())
