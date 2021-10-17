# 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 크기가 같은 물고기는 먹을 수 없지만, 지나갈 수 있다.
from collections import deque
dy = [0, 0, -1, 1]
dx = [1, -1, 0, 0]

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

shark_y, shark_x, shark_size, shark_eat = 0, 0, 2, 0
fish_cnt = 0
fish_pos = []
time = 0

for i in range(N):
    for j in range(N):
        if board[i][j] == 9:
            board[i][j] = 0
            shark_y = i
            shark_x = j
        elif board[i][j] > 0:
            fish_cnt += 1
            fish_pos.append([i, j])


def bfs(sy, sx):
    q = deque([(sy, sx, 0)])
    # 상어의 위치를 나타냄 ,y x, 움직인 거리.
    dist_lis = []
    visit = [[False]*N for _ in range(N)]
    # 4방 탐색 당시가 가장 짧은 거리기 때문에 같은 곳을 둘러서 갈 필요 X
    visit[sy][sx] = True

    while q:
        y, x, dis = q.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < N and 0 <= nx < N and not visit[ny][nx]:
                # 넘지도 않고 아직 안가본곳임.
                if board[ny][nx] <= shark_size:
                    # 먹거나 지나갈 수 있냐?
                    visit[ny][nx] = True
                    # 1로 최소 거리니까. 무조건 가야지.
                    if 0 < board[ny][nx] < shark_size:
                        # 먹을 수 있냐? 먹을 수 있는 물고기들의 정보 넣어줌.
                        dist_lis.append([dis+1, ny, nx])
                    else:
                        # 이동만 하면 이동할 곳 넣어줌.
                        q.append((ny, nx, dis+1))

    if dist_lis:
        dist_lis = sorted(dist_lis)
        return dist_lis[0]

    else:
        return False


while fish_cnt:
    shark = bfs(shark_y, shark_x)
    # 최단거리 물고기까지 거리 , y, x
    if shark == False:
        # 먹을 물고기 없음.
        break
    shark_y, shark_x = shark[1], shark[2]
    time += shark[0]
    shark_eat += 1
    fish_cnt -= 1
    if shark_size == shark_eat:
        shark_size += 1
        shark_eat = 0
    board[shark_y][shark_x] = 0

print(time)
