# 위상정렬
from collections import deque

N , M = map(int,input().split())
arr = []
inDegree = [0 for _ in range(32001)] # 진입차수 초기화
g = [[]for _ in range(32001)]
q = deque()
for _ in range(M):
    x,y = map(int,input().split())
    arr.append([x,y])

for x,y in arr :
    inDegree[y] += 1
    g[x].append(y)

for i in range(1,N+1):
    if inDegree[i] == 0:
        q.append(i)

while q:
    student = q.popleft()
    for i in g[student] :
        inDegree[i] -= 1
        if inDegree[i] == 0:
            q.append(i)
    print(student,end=' ')

