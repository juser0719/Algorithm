"""
하나의 말 위에 다른 말을 올릴 수 있다.
말의 이동 방향에 있는 칸에 따라서 말의 이동이 다르며 아래와 같다.
"""
import sys

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]


def move(num):
    y, x, z = chess[num]
    ny = y + dy[z]
    nx = x + dx[z]

    if not 0 <= nx < N or not 0 <= ny < N or board[ny][nx] == 2:
        # 범위를 넘거나 파랑일 경우
        if 0 <= z <= 1:
            nz = (z+1) % 2
        else:
            nz = (z-1) % 2 + 2
        chess[num][2] = nz
        # 방향 반대로.
        nx = x + dx[nz]
        ny = y + dy[nz]
        # 반대 방향으로 한칸.
        if not 0 <= nx < N or not 0 <= ny < N or board[ny][nx] == 2:
            # 또 넘거나 파랑이면 멈춤.
            return 0

    chess_set = []

    for i, key in enumerate(chess_map[y][x]):
        if key == num:
            chess_set.extend(chess_map[y][x][i:])
            chess_map[y][x] = chess_map[y][x][:i]
            break

    # 이동해서 올림.

    if board[ny][nx] == 1:
        # 빨강이면
        chess_set = chess_set[-1::-1]
        # 움직일놈 반대로.

    for i in chess_set:
        chess_map[ny][nx].append(i)
        chess[i][:2] = [ny, nx]
        # 움직일 곳에 추가해줌.

    if len(chess_map[ny][nx]) >= 4:
        return 1
    return 0


N, K = map(int, (input().split()))
board = [list(map(int, input().split())) for _ in range(N)]
chess_map = [[[]*N] for _ in range(N)]
chess = [[]*K]

for i in range(K):
    y, x, z = map(int, input().split())
    chess_map[y-1][x-1].append(i)
    chess[i] = [y-1, x-1, z-1]
game = 1

while game <= 1000:
    for i in range(K):
        flg = move(i)
        if flg:
            print(game)
            sys.exit()
    game += 1

    # 1~K말까지 순서대로 이동.
    """
        if 흰색이면, :
            그칸으로 모두 이동.
            if 이미 말 있으면 :
                그 위로 모두 이동.
        elif 빨간색이면,:
            if 말이 없다면:
                말의 순서를 반대로 바꿈.
            elif 말이 있다면:
                기존은 냅두고 그 위에 반대로 바꿔서 올림.
        elif 파란색이면 :
            i번 말의 방향 반대로 바꾸고
            1칸 그 방향으로 전진.
            만약 파란색이면 멈춰.
        else 넘어간다면:
            파란색과 같이 동작.
        """


print(-1)
