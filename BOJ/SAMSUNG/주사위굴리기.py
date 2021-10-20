dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

N, M, y, x, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
orders = list(map(int, input().split()))
dice = [0]*6
# 위, 북, 동 , 서 , 남 , 아래
# 0,  1, 2 ,  3,  4 , 5

for i in range(k):
    # 동쪽은 0, 서쪽은 1, 북쪽은 2, 남쪽은 3
    dir = orders[i] - 1
    ny = y + dy[dir]
    nx = x + dx[dir]

    if not 0 <= nx < M or not 0 <= ny < N:
        continue
    if dir == 0:
        # 동쪽으로 굴리자.
        dice = [dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]]
    elif dir == 1:
        # 서쪽으로 굴리자.
        dice = [dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]]
    elif dir == 2:
        # 북쪽으로 굴리자.
        dice = [dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]]
    elif dir == 3:
        # 남쪽으로 굴리자.
        dice = [dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]]

    if board[ny][nx] == 0:
        board[ny][nx] = dice[5]
    else:
        dice[5] = board[ny][nx]
        board[ny][nx] = 0

    y, x = ny, nx

    print(dice[0])
