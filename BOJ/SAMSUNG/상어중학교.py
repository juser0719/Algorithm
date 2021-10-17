# 검은색 블록 -1, 무지개 블록 0 , 일반 블록 1~M
# 블록 그룹은 연결된 블록의 집합( 2보다 크거나 같아야 )
# 일반 블록의 색은 모두 같아야  = 검은색 블록은 포함X, 무지개 블록은 얼마나 들어있어도 O

# 1. 크기가 가장 큰 블록 그룹을 찾는다. 그러한 블록 그룹이 여러 개라면 포함된 무지개 블록의 수가 가장 많은 블록 그룹
# 2. 1에서 찾은 블록 그룹의 모든 블록을 제거한다. 블록 그룹에 포함된 블록의 수를 B라고 했을 때, B2점을 획득한다.
# 3. 격자에 중력이 작용한다.
# 4. 격자가 90도 반시계 방향으로 회전한다.
# 5. 다시 격자에 중력이 작용한다.(검은색 빼고 )
from collections import deque
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def find_block(board, visite, sy, sx, flg):
    N = len(board)
    q = deque([(sy, sx)])
    col = board[sy][sx]
    visite[sy][sx] = True

    cnt = 1
    rain = 0

    if flg == 1:
        board[sy][sx] = 8

    while q:
        y, x = q.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < N and 0 <= nx < N and not visite[ny][nx]:
                if board[ny][nx] == col or board[ny][nx] == 0:
                    if board[ny][nx] == 0:
                        rain += 1
                    cnt += 1
                    q.append([ny, nx])
                    visite[ny][nx] = True
                    if flg == 1:
                        board[ny][nx] = 8

    if flg == 0:
        return cnt, rain
    else:
        return board


def apply_gravity(board):
    N = len(board)

    for j in range(N):
        for i in range(N-1, -1, -1):
            if board[i][j] != -1 and board[i][j] != 8:
                # 검은 블록도 아니고 빈칸도 아니라면
                val = board[i][j]
                board[i][j] = 8
                row = i
                while True:
                    if row == N-1:
                        board[row][j] = val
                        break

                    n_row = row + 1

                    if n_row == N-1:
                        if board[n_row][j] == 8:
                            board[n_row][j] = val
                            break
                        else:
                            board[row][j] = val
                            break
                    else:
                        if board[n_row][j] != 8:
                            board[row][j] = val
                            break
                    row = n_row

    return board


def turn_90(board):
    tured_board = []

    for line in reversed(tuple(zip(*board))):
        tured_board.append(list(line))
    return tured_board


N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
score = 0

while True:

    visite = [[False]*N for _ in range(N)]
    block, rain = 1, 0
    del_y, del_x = -1, -1

    for i in range(N):
        for j in range(N):
            if 0 < board[i][j] <= M and not visite[i][j]:

                block_cnt, rain_cnt = find_block(board, visite, i, j, 0)

                if block < block_cnt:
                    block = block_cnt
                    del_y, del_x = i, j

                elif block == block_cnt and rain < rain_cnt:
                    rain = rain_cnt
                    del_y, del_x = i, j

    # 모두 하나뿐= 종료.
    if block == 1:
        break

    visite = [[False]*N for _ in range(N)]
    board = find_block(board, visite, del_y, del_x, 1)
    score += block*block
    # 삭제.
    # print("삭제")
    # for line in board:
    #     print(line)
    # print()
    board = apply_gravity(board)
    # print("중력")
    # for line in board:
    #     print(line)
    # print()
    # print("90도")
    board = turn_90(board)
    # for line in board:
    #     print(line)
    # print()
    # print("중력")
    board = apply_gravity(board)
    # for line in board:
    #     print(line)
    # print()

print(score)
