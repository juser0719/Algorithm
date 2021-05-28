# 두 노드의 공통 조상 찾기

n = int(input())
parent = [0] * (n +1) # 부모 노드 정보
d = [0] * (n +1)
c = [0] * (n +1)
g = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

def find_depth_dfs(x,depth):
  c[x] = True
  d[x] = depth
  for i in g[x]:
    if c[i]:
      continue
    parent[i] = x
    find_depth_dfs(i,depth+1)

def lca (a,b):
  # depth가 동일하도록 만듦
  while d[a] != d[b]:
    if d[a] > d[b]:
      a = parent[a]
    else:
      b = parent[b]
  # 노드가 같아지도록 만듦
  while a != b:
    a= parent[a]
    b= parent[b]
  
  return a



find_depth_dfs(1,0) # 루트 노드 1번.
