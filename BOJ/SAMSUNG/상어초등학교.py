# 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
# 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
# 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def find_cnt(board, friendly):
    N = len(board)
    state = []
    for y in range(N):
        for x in range(N):
            if board[y][x] != 0:
                continue
            empty = 0
            friend = 0
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < N and 0 <= nx < N:
                    if board[ny][nx] in friendly:
                        friend += 1
                    elif board[ny][nx] == 0:
                        empty += 1
            state.append([friend, empty, y, x])

    state = sorted(state, key=lambda x: (-x[0], -x[1]))

    return state[0]


N = int(input())
board = [[0]*N for _ in range(N)]
preferred = {}

for _ in range(N*N):
    arr = list(map(int, input().split()))
    preferred[arr[0]] = arr[1:]

for stu in preferred.keys():
    cnt_pos = find_cnt(board, preferred[stu])
    y, x = cnt_pos[2], cnt_pos[3]
    board[y][x] = stu

score = [0, 1, 10, 100, 1000]
res = 0

for y in range(N):
    for x in range(N):
        cnt = 0
        key = board[y][x]
        for i in range(4):
            ny = y+dy[i]
            nx = x+dx[i]
            if 0 <= ny < N and 0 <= nx < N:
                if board[ny][nx] in preferred[key]:
                    cnt += 1

        res += score[cnt]


print(res)
