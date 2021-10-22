from collections import deque
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def find_union(y, x):
    q = deque((y, x))
    union = [(y, x)]
    print(union)
    while q:
        cy, cx = q.popleft()

        for i in range(4):
            ny = cy + dy[i]
            nx = cx + dx[i]

            if 0 <= nx < N and 0 <= ny < N and (ny, nx) not in visit:
                if L <= abs(board[ny][nx] - board[cy][cx]) <= R:
                    union.append((ny, nx))
                    visit.add((i, j))
                    q.append((i, j))
    if len(union) > 1:
        union_list.append(union)


def move_people(union_list):
    for union in union_list:
        total = 0

        for contry in union:
            y, x = contry
            total += board[y][x]

        people_avg = total // len(union)

        for contry in union:
            y, x = contry
            board[y][x] = people_avg


N, L, R = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
res = 0

while True:
    union_list = []
    visit = set()
    print("test")
    for i in range(N):
        for j in range(N):
            if (i, j) not in visit:
                visit.add((i, j))
                find_union(i, j)

    if union_list:
        move_people(union_list)
        res += 1
    else:
        break

print(res)
