def calc(n1, n2, op):
    if op == '*':
        return n1 * n2
    elif op == '+':
        return n1 + n2
    elif op == '-':
        return n1 - n2


def dfs(idx, cnt, flg, orders):
    global count, num, ops
    if cnt == count:
        num.append(orders)
        return
    if flg:
        dfs(idx + 2, cnt+1, False, orders)
    else:
        dfs(idx, cnt+1, True, ops[:idx-1] + [calc(orders[idx-1],
            orders[idx], orders[idx+1])] + orders[idx+2:])
        dfs(idx+2, cnt+1, False, orders)


N = int(input())
res = int(-1e9)
arr = input()
num = []
ops = []

for a in arr:
    if a in ["+", "-", "*"]:
        ops.append(a)
    else:
        num.append(int(a))

count = len(ops) // 2

print(res)
