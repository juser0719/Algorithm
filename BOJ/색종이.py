import sys

def check(array, row, col, width):  # depth 크기의 색종이를 row, col 위치를 시작점으로 둘 수 있는지 확인
    # 범위 체크
    if row + width > 10 or col + width > 10:
        return False
    for i in range(row, row + width):
        for j in range(col, col + width):
            if array[i][j] == 0:
                return False
    return True

def dfs(arr,cnt,count):
    global res
    if res != -1 and sum(count) > res:
        return
    if cnt == 0: # 1이 없음.
        if res == -1:
            res = sum(count)
        else:
            res = min(res,sum(count))
        return
    
    # 색종이 삽입 위치 찾기.
    row , col = -1,-1
    for i in range(10):
        for j in range(10):
            if arr[i][j] == 1:
                row = i
                col = j
                break
        if (row != -1 and col != -1 and arr[row][col] == 1):
            break

    # row col위치에 대입 가능한 색종이 탐색.
    for width in range (1,6):
        if count[i-1] == 5:
            continue
        if check(arr, row, col, width):
        # 색종이 놓을 수 있는지 확인.
            loc = []
            for i in range(row, row + width):
                for j in range(col , col + width):
                    arr[i][j] = 0
                    loc.append((i,j))
            count[i-1] += 1
            dfs(arr,cnt -i**2 , count)
            count[i-1] -= 1
            for x,y in loc:
                arr[x][y] = 1







maps = [list(map(int, input().split())) for _ in range(10)]

one_cnt = 0
for i in range(10):
    one_cnt += map[i].count(1)
res = -1

dfs(maps,one_cnt,[0,0,0,0,0])
print(res)




