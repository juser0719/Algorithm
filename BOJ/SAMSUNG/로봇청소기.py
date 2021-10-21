dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
# 북서남동


def clean(y, x, dir):
    global res

    if board[y][x] == 0:
        board[y][x] = 2
        res += 1

    for _ in range(4):
        nd = (dir+3) % 4  # -1 씩하는거니까 -90 = 270도 회전
        ny = y + dy[nd]
        nx = x + dx[nd]

        if board[ny][nx] == 0:
            # 왼쪽으로 돌고 청소 가능하면 재가동.
            clean(ny, nx, nd)
            return
        # 왼쪽으로 돌았는데 청소가 되어있다면 '그'방향 회전.a
        dir = nd

    # 네 방향 모두 불가면, 뒤로 1번가기.
    nd = (dir + 2) % 4
    ny = y + dy[nd]
    nx = x + dx[nd]

    if board[ny][nx] == 1:
        # 뒤가 벽이면 멈춤.
        return

    clean(ny, nx, dir)
    # 뒤로 지만 방향은 유지해야함.


N, M = map(int, input().split())
y, x, d = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
res = 0
clean(y, x, d)
print(res)
