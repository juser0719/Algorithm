"""
처음에는 양분이 모든칸에 5만큼.
M 개의 나무 구매, 한칸에 여러개 나무 가능.
봄 : 자신의 나이만큼 양분 먹고 1살 증가. -> 양분 먹는건 나이순대로 어린애들부터. 못먹으면 즉시 즉사.
여름 : 죽은 나무 나이 // 2 + 양분으로 
가을 : 나이가 5배수이면 8방에 1의 나무가 생김.
겨울 : 로봇이 양분 추가.

K 년후 살아있는 나무 개수.
"""
from collections import deque
dx = [0, 0, 1, 1, 1, -1, -1, -1]
dy = [-1, 1, 0, 1, -1, 0, -1, 1]


def spring_summer():

    tree_info.sort(key=lambda x: x[0])
    dead_tree = []
    for i in range(len(tree_info)):
        year, y, x = tree_info[i]

        if soild[y][x] >= year:
            # 양분 먹을 수 있다면,
            soild[y][x] -= year
            year += 1
            tree_info[i][0] = year
        else:
            dead_tree.append([year, y, x])
            tree_info.pop(i)
            print(tree_info)
            print("i=", i)
            i -= 1
            print("i=", i)

    for i in range(len(dead_tree)):
        year, y, x = dead_tree[i]
        soild[y][x] += int(year//2)


def fall():
    new_tree = []

    for i in range(len(tree_info)):
        year, y, x = tree_info[i]
        if year % 5 == 0:
            for d in range(8):
                ny = y + dy[d]
                nx = x + dx[d]
                if 0 <= ny < N and 0 <= nx < N:
                    new_tree.append([1, ny, nx])

    tree_info.extend(new_tree)


def winter():
    for i in range(N):
        for j in range(N):
            soild[i][j] += plus[i][j]


N, M, K = map(int, input().split())
soild = [[5]*N for _ in range(N)]
plus = [list(map(int, input().split())) for _ in range(N)]
tree_info = []

for _ in range(M):
    x, y, z = map(int, input().split())
    tree_info.append([z, y-1, x-1])

for _ in range(K):
    spring_summer()
    fall()
    winter()

print(len(tree_info))
