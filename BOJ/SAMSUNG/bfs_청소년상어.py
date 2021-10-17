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
fishs = {}
board = [[0]*4 for _ in range(4)]
visit = [[0]*4 for _ in range(4)]
for i in range(4):
    li = list(map(int, input().split()))
    j = 0
    for k in range(0, 7, 2):
        board[i][j] = li[k]
        fishs[li[k]] = [li[k+1], True, i, j]
        # key: 번호, value : 방향,먹혔는지, y, x,
        j += 1
fishs = sorted(fishs.keys())
shark_y, shark_x = 0, 0
shark_res = board[0][0]  # 0 번째에 있는 물고기 먹음.
shark_dir = fishs[board[0][0]][0]  # 0,0 물고기 방향성 가짐.
fishs[board[0][0]][1] = True


print(board)
