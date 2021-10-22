def play():
    for start in range(N-1):
        # 시작점.
        now_y, now_x = 0, start

        while now_y < H:
            # 해당 시작점에서 H 까지.
            if visited[now_y][now_x] == 1:
                # 사다리 있다면,
                if [now_y, now_x] in ladders:
                    # -> 이동
                    now_x += 1
                else:
                    # <- 이동
                    now_x -= 1
            now_y += 1

        if now_x != start:
            return False
    return True


def dfs(start_row, cnt):
    global res
    if cnt > 3:
        return
    else:
        for i in range(start_row, H):
            # 가로의 사다리들
            for j in range(N-1):
                # 세로선
                if visited[i][j] == 0 and visited[i][j+1] == 0:
                    # 만약 현재 위치에 사다리가 없다면,
                    visited[i][j] = 1
                    visited[i][j+1] = 1
                    ladders.append([i, j])
                    # 사다리 추가.
                    if play():
                        # 사다리게임 시작.
                        if res == -1:
                            # 갯수가 없다면 갱신
                            res = cnt
                        else:
                            # 사다리가 있다면 최소값 갱신.
                            res = min(res, cnt)
                    else:
                        # 출발,도착점 다르면 현재 row에 사다리 넣았다 치고 다음 ㄱ
                        dfs(i, cnt+1)

                    visited[i][j] = 0
                    visited[i][j+1] = 0
                    ladders.pop()
                    # 사다리 제거.


N, M, H = map(int, input().split())
visited = [[0]*N for _ in range(H)]
# 현재 사다리가 있는지.
ladders = []
# 어떤 사다리(->)가 있는지 시작점.
res = -1
# print(visited)
for i in range(M):
    y, x = map(int, input().split())
    visited[y-1][x-1] = 1
    visited[y-1][x] = 1
    # 사다리 ->
    ladders.append([y-1, x-1])
    # 사다리 시작점 넣어줌
# print(visited)

if M == 0:
    # 사다리가 없다면.
    res = 0
elif M == 1:
    # 사다리가 1개라면 1개만 더 두면 됨
    res = 1
else:
    # 2개 이상이라면 게임 해봐야함.
    if play():
        res = 0
    else:
        # 최소 1개는 넣어야하니까..
        dfs(0, 1)
print(res)
