INF = int(1e9)

n,m = map(int,input().split())
g = [[INF]*(n+1) for _ in range(n+1)]

# 자기 자신의 비용을 0으로 초기화
for i in range(1,n+1):
  for j in range(1,n+1):
    if i == j:
      g[i][j] = 0

# 간선 정보 입력 받음
for _ in range(m):
    # A와 B가 서로에게 가는 비용은 1이라고 설정, 양 방향임.
    a, b = map(int, input().split())
    g[a][b] = 1
    g[b][a] = 1

# 거쳐갈 최종 X 와 K 입력 받기
x,k = map(int,input().split())

#플로이드 워셜
for k in range(1,n+1):
  for a in range(1,n+1):
    for b in range(1,n+1):
      g[a][b] = min(g[a][b],g[a][k] + g[k][b])

dis = g[1][k] + g[k][x]

if dis >= 1e9:
  print(-1)
else:
  print(dis)