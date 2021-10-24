N = int(input())
maps = [list(map(int, input().split())) for _ in range(N)]
res = 1e9
total = 0

for i in range(N):
    for j in range(N):
        total += maps[i][j]


def cal(y, x, d1, d2):
    global res, total
    area1, area2, area3, area4 = 0, 0, 0, 0

    x1 = x+1
    for i in range(y+d2):
        if i >= y:
            x1 += 1
        area1 += sum(maps[i][:x1])

    x2 = x+1
    for i in range(y+d2+1):
        if i > y:
            x2 += 1
        area2 += sum(maps[i][x2:])

    x3 = x-d1
    for i in range(y+d1, N):
        area3 += sum(maps[i][:x3])
        if i < y+d1+d2:
            x3 += 1

    x4 = (x+d2) - N
    for i in range(y+d2+1, N):
        area4 += sum(maps[i][x4:])
        if i < y+d1+d2:
            x4 -= 1

    area5 = total - area1 - area2-area3-area4
    res = min(res, (max(area1, area2, area3, area4, area5) -
              min(area1, area2, area3, area4, area5)))


def check(y, x, d1, d2):
    # 가능한 d1,d2 찾기
    if 0 <= y+d1-1 < N and 0 <= y+d2-1 < N and 0 <= x-d1+d2-1 < N:
        if 0 <= x-d1 and x+d2 < N and y+d1+d2 < N:
            cal(y, x, d1, d2)


for r in range(N-2):
    for c in range(1, N-1):
        for d1 in range(1, N-1):
            for d2 in range(1, N-1):
                check(r, c, d1, d2)

print(res)
