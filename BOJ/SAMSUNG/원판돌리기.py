from collections import deque
N, M, T = map(int, input().split())

circle = [deque(map(int, input().split())) for _ in range(N)]
orders = [list(map(int, input().split())) for _ in range(T)]
"""
번호가 xi의 배수인 원판을 di방향으로 ki칸 회전시킨다. 
di : 0 시계 방향, 1 반시계 방향
set은 이중 배열 안됨.
"""

for t in range(T):
    x, d, k = orders[t]
    res = 0

    for i in range(N):
        res += sum(circle[i])

        if (i+1) % x == 0:
            if d == 0:
                circle[i].rotate(k)
            else:
                circle[i].rotate(-k)

    if res != 0:

        will_remove = []
        # 같은 원 내에서 인접한 요소들 구함.
        for i in range(N):
            for j in range(M-1):
                if circle[i][j] != 0 and circle[i][j+1] != 0 and circle[i][j] == circle[i][j+1]:
                    will_remove.append((i, j))
                    will_remove.append((i, j+1))

            if circle[i][0] != 0 and circle[i][-1] != 0 and circle[i][0] == circle[i][-1]:
                will_remove.append((i, 0))
                will_remove.append((i, M-1))

        # 다른 원들 끼리 인접한 요소를 구함.
        for j in range(M):
            for i in range(N-1):
                if circle[i][j] != 0 and circle[i+1][j] != 0 and circle[i][j] == circle[i+1][j]:
                    will_remove.append((i, j))
                    will_remove.append((i+1, j))

        # 중복된 좌표 제거.
        will_remove = list(set(will_remove))
        # 같은것들 0으로 만들어주기.
        for pos in will_remove:
            y, x = pos
            circle[y][x] = 0

        if len(will_remove) == 0:
            avg_num = 0
            zero_cnt = 0

            for i in range(N):
                avg_num += sum(circle[i])
                zero_cnt += circle[i].count(0)

            avg = avg_num / (N*M-zero_cnt)

            for i in range(N):
                for j in range(M):
                    if circle[i][j] != 0 and circle[i][j] > avg:
                        circle[i][j] -= 1
                    elif circle[i][j] != 0 and circle[i][j] < avg:
                        circle[i][j] += 1
    else:
        break


res = 0
for i in range(N):
    res += sum(circle[i])

print(res)
