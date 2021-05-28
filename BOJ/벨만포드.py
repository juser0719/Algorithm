def bf(start):
  dist[start] = 0
  for i in range(N):
    for j in range(M):
      now_node  = edge[j][0] #지금 노드
      next_node = edge[j][1] #도착 노드
      cost = edge[j][2]
      if dist[now_node] != INF and dist[next_node] > dist[now_node] + cost:
        dist[next_node] = dist[now_node] + cost
        if i == N-1:
          return True
  return False

INF = int(1e9)
N = int(input())
M = int(input())
edge = []
dist = [INF] * (N + 1)
for _ in range(M):
  s,e,v = map(int,input().split())
  edge.append((s,e,v))

st,ed = map(int,input().split())

if bf(st) :
  print("-1")
else:
  print(dist[ed])
