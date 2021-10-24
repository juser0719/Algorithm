import sys
from collections import deque

customer = {}
q = deque()
N, M, F = map(int, input().split())
dx, dy = [0, 0, -1, 1], [-1, 1, 0, 0]
m = [list(map(int, input().split())) for _ in range(N)]
sx, sy = map(int, input().split())
q.append((sx-1, sy-1))

for i in range(M):
    sx, sy, ex, ey = map(int, input().split())
    customer[i] = [sx-1, sy-1, ex-1, ey-1]
# 최단거리가 항상 짧은 승객을 고르도록 (행, 열) 순으로 정렬
customer = dict(sorted(customer.items(), key=lambda x: (x[1][0], x[1][1])))


def bfs(dist):
    visited[q[0][0]][q[0][1]] = True
    dist[q[0][0]][q[0][1]] = 0

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and m[nx][ny] == 0 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny))
                dist[nx][ny] = dist[x][y] + 1


while True:
    arr = []
    # M <= N^2이고, N <= 20이므로 거리의 최댓값은 400이하이다. 따라서 minimum값 401로 설정
    minimum = 401
    visited = [[False] * N for _ in range(N)]
    dist = [[-1] * N for _ in range(N)]

    # q에 처음 택시의 시작좌표를 넣고 bfs실행
    bfs(dist)
    # bfs실행한 뒤(dist값 갱신된 상태)에 각각의 손님들까지의 거리를 계산해 가장 가까운 위치 구함
    for i in customer:
        if dist[customer[i][0]][customer[i][1]] != -1:
            if dist[customer[i][0]][customer[i][1]] < minimum:
                minimum = dist[customer[i][0]][customer[i][1]]
                arr = [i]
            elif dist[customer[i][0]][customer[i][1]] == minimum:
                arr.append(i)

    # 모든 손님에게 갈 수 없는 경우 -1출력
    if not arr:
        print(-1)
        break

    # 연료의 양에서 가장 가까운 손님까지 가는데 필요한 연료의 양 빼줌
    # 빼 준 뒤 F가 0이하이면, 목적지까지 가지 못하므로 -1출력하고 종료
    F -= dist[customer[arr[0]][0]][customer[arr[0]][1]]
    if F <= 0:
        print(-1)
        break
    else:
        # 연료의 양이 1이상이면, 일단 목적지까지 출발
        q = deque()
        q.append((customer[arr[0]][0], customer[arr[0]][1]))
        visited = [[False] * N for _ in range(N)]
        dist = [[-1] * N for _ in range(N)]

        # 태운 손님의 목적지좌표를 q에 넣고 bfs실행
        bfs(dist)

        # 손님의 목적지까지 갈 수 없는 경우 dist값은 -1이다.
        # 그 경우에는 -1출력하고 종료
        if dist[customer[arr[0]][2]][customer[arr[0]][3]] == -1:
            print(-1)
            break

        # 목적지까지 갈 수 있으면, 현재 연료의 양에서 목적지까지 가는데 필요한 연료의 양 빼줌
        F -= dist[customer[arr[0]][2]][customer[arr[0]][3]]

        # F가 0이상이면, 목적지까지 가는데 필요한 연료의 양 x 2 충전한 뒤, 손님 customer에서 delete
        # F가 0이어도 된다. 문제에서 "승객을 목적지로 이동시킨 동시에 연료가 바닥나는 경우는 실패한 것으로 간주하지 않는다" 주어짐.
        if F >= 0:
            F += dist[customer[arr[0]][2]][customer[arr[0]][3]] * 2
            q.append((customer[arr[0]][2], customer[arr[0]][3]))
            del customer[arr[0]]
        else:
            # F가 0보다 작으면 가는 도중에 연료가 다 닳았으므로 -1출력하고 종료
            print(-1)
            break

    # customer에 모든 승객이 지워졌으면, 모든 승객을 다 태워준 것이므로 현재 연료의 양 출력하고 종료
    if not customer:
        print(F)
        break
