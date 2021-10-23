from collections import deque


def isLink(area):
    q = deque()
    link = [0]*N
    q.append(area[0])
    link[area[0]] = 1
    cnt = 1
    area_people = 0

    while q:
        now = q.popleft()
        area_people += people[now]

        for next in maps[now]:
            if next in area and link[next] == 0:
                link[next] = 1
                cnt += 1
                q.append(next)

    if cnt == len(area):
        return area_people
    else:
        return 0


def dfs(cnt, idx, end):
    # 현재 선택한 도시 갯수, 시작, 선택할 구역의 총 도시 수.
    global min_res

    if cnt == end:
        # 한 구역의 도시 다 잡았다면,
        area1 = deque()
        area2 = deque()

        for i in range(N):
            if visit[i]:
                area1.append(i)
            else:
                area2.append(i)

        area1_link = isLink(area1)
        area2_link = isLink(area2)

        if area1_link == 0 or area2_link == 0:
            return
        else:
            min_res = min(min_res, abs(area1_link - area2_link))

        return

    for i in range(idx, N):
        if visit[i]:
            continue
        visit[i] = True
        dfs(cnt+1, i, end)
        visit[i] = False


N = int(input())
people = list(map(int, input().split()))
maps = [[] for _ in range(N)]

for i in range(N):
    info = list(map(int, input().split()))

    for j in range(1, info[0]+1):
        maps[i].append(info[j]-1)

min_res = 1e9

for i in range(1, (N//2) + 1):
    visit = [False]*N
    dfs(0, 0, i)

if min_res == 1e9:
    print(-1)
else:
    print(min_res)
