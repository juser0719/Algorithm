from copy import deepcopy
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
# 동서 남북
direction = [[], [[0], [1], [2], [3]], [[0, 1], [2, 3]],
             [[3, 0], [0, 2], [2, 1], [1, 3]], [[3, 0, 1], [
                 0, 2, 3], [2, 0, 1], [1, 2, 3]], [[0, 1, 2, 3]]]


def watch(y, x, watch_dirs, office_copy):
    for d in watch_dirs:
        ny = y
        nx = x
        while True:
            ny += dy[d]
            nx += dx[d]

            if 0 <= nx < M and 0 <= ny < N and office_copy[ny][nx] != 6:
                if office_copy[ny][nx] == 0:
                    office_copy[ny][nx] = 8
            else:
                break


def dfs(office, cctv_cnt):
    global area
    office_copy = deepcopy(office)

    if cctv_cnt == len(cctv):
        cnt = 0
        for line in office_copy:
            cnt += line.count(0)
        area = min(area, cnt)
        return
    cctv_type, y, x = cctv[cctv_cnt]
    for turn in direction[cctv_type]:
        watch(y, x, turn, office_copy)
        dfs(office_copy, cctv_cnt+1)
        office_copy = deepcopy(office)


N, M = map(int, input().split())
office = [list(map(int, input().split())) for _ in range(N)]
cctv = []
area = 0
for i in range(N):
    for j in range(M):
        if 0 < office[i][j] < 6:
            cctv.append([office[i][j], i, j])
        elif office[i][j] == 0:
            area += 1


dfs(office, 0)
print(area)
