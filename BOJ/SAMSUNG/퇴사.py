
res = int(-1e9)


def dfs(idx, val):
    global res
    if idx == N:
        res = max(res, val)
        return

    dfs(idx+1, val)
    # 안받고 다음거 탐색.
    if idx+times[idx] <= N:
        # 만약 받을 수 있으면 받기.
        dfs(idx+times[idx], val+money[idx])


N = int(input())
times = [0]*N
money = [0]*N


for i in range(N):
    times[i], money[i] = map(int, input().split())

dfs(0, 0)
# 인덱스, 봉급
print(res)
