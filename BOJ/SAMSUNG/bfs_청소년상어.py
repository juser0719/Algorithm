# 상어 : 먹고 -> 물고기 이동 -> 상어 이동 -> 물고기 있으면 먹고 물고기 방향으로 바꿈.
# 물고기: 작은물고기부터 이동-> 빈칸,물고기 O 상어,경계넘으면 X -> 이동 못한다면 반시계 45도로 방향 바꿈.
"""
1. 상어가 (0,0)에 들어가서 먹고 위치와 현재 값넣어줌.
2. 물고기(list) 이동.
    2-1. 번호대로 정렬.
    2-2. 차례대로 이동.
3. 갈 수 있는 방향의 칸들 모두 넣어줌.
4. dfs로 이동한 후보를 시작으로 먹은 물고기 합 저장.
"""
from collections import deque
dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, -1, -1, -1, 0, 1, 1, 1]


def move(fy, fx):
    for i in range(16):
        if fish[i]:
            y, x = fish[i][0], fish[i][0]

            for _ in range(9):
                ny = y + dy[board[y][x][1]]
                nx = x + dx[board[y][x][1]]
                if 0 <= nx < 4 and 0 <= ny < 4 and board[ny][nx]:
                    fish[board[ny][nx][0]] = [y, x]


def dfs(y, x, d, cnt):
    global res, board, fish
    move(y, x)


board = [[] for _ in range(4)]
fish = [[] for _ in range(16)]

for i in range(4):
    line = list(map(int, input().split()))

    for j in range(0, 7, 2):
        board[i].append([line[j]-1, line[j+1]-1])
        fish[line[j]-1] = [i, j//2]
res = 0
d = board[0][0][1]
cnt = board[0][0][0]+1
fish[board[0][0][0]] = []
board[0][0] = []
dfs(0, 0, d, cnt)
print(res)
