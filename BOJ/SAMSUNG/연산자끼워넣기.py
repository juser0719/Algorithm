N = int(input())
nums = list(map(int, input().split()))
op = list(map(int, input().split()))
# +,-,*,/
maxx = -1e9
minn = 1e9


def dfs(idx, res, pl, mi, sub, mul):
    global maxx, minn

    if idx == N:
        maxx = max(maxx, res)
        minn = min(minn, res)
        return

    if pl:
        dfs(idx+1, res+nums[idx], pl-1, mi, sub, mul)
    if mi:
        dfs(idx+1, res-nums[idx], pl, mi-1, sub, mul)
    if sub:
        dfs(idx+1, res*nums[idx], pl, mi, sub-1, mul)
    if mul:
        dfs(idx+1, int(res/nums[idx]), pl, mi, sub, mul-1)


dfs(1, nums[0], op[0], op[1], op[2], op[3])
print(maxx)
print(minn)
