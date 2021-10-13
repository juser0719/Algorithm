# 빨간 구슬을 구멍을 통해 빼내는것. 파란 구슬은 안됨.
# 왼쪽,오른쪽,위,아래 기울이기 가능. (동시에 같은칸에 있을 수 없다.)
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
q = []

N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]
visit = [[[[False]*M for _ in range(N)] for _ in range(M)] for _ in range(N)]
red = []
blue = []

for i in range(N):
    for j in range(M):
        if board[i][j] == 'R':
            board[i][j] = '.'
            red = [i, j]
        elif board[i][j] == 'B':
            board[i][j] = '.'
            blue = [i, j]

q.append((red[0], red[1], blue[0], blue[1], 1))
visit[red[0]][red[1]][blue[0]][blue[1]] = True


def move(y, x, dy, dx):
    cnt = 0
    # 이동 칸수
    while board[y+dy][x+dx] != '#' and board[y][x] != 'O':
        # 다음이 벽이거나 현재가 구멍일때 까지.
        x += dx
        y += dy
        cnt += 1

    return y, x, cnt


def solution():
    while q:
        ry, rx, by, bx, depth = q.pop(0)
        if depth > 10:
            break

        for i in range(4):
            nry, nrx, rcnt = move(ry, rx, dy[i], dx[i])
            nby, nbx, bcnt = move(by, bx, dy[i], dx[i])

            if board[nby][nbx] != 'O':
                # 파란 구슬이 먼저 빠지지 않았고,
                if board[nry][nrx] == 'O':
                    # 빨간 구슬은 나갔다면,
                    print(depth)
                    return
                if nry == nby and nrx == nbx:
                    # 겹쳤다면,
                    if rcnt > bcnt:
                        # 이동거리 비교로 짧은 구슬이 벽에 먼저 붙기 때문에..
                        nry -= dy[i]
                        nrx -= dx[i]
                    else:
                        nby -= dy[i]
                        nbx -= dx[i]

                if not visit[nry][nrx][nby][nbx]:
                    visit[nry][nrx][nby][nbx] = True
                    q.append((nry, nrx, nby, nbx, depth+1))
    print(-1)


solution()
